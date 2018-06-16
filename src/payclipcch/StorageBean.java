package payclipcch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.nio.file.attribute.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.JSONObject;
import org.json.JSONArray;
import java.nio.file.Paths;

/**
 *
 * @author fsalaman
 */
public class StorageBean {
    public static final int FILE=0;
    public static final int DB=1;
    private final int option;
    private final String userid;
    public static String indexfile = "index.idx";
    
    public StorageBean(String userid, int option){
        this.option = option;
        this.userid = userid;
    }
    
    public void Commit(String transaction) {
        switch(this.option){
            case 0:
                saveFile(this.userid, transaction);
                break;
            case 1:
                saveDB();
                break;
        }
    }
    
    private void saveFile(String userid, String transaction) {
    	BufferedWriter writer = null;
    	//String pafile = "pcchstore.dat";
        String pafile = userid+".dat";
    	
        try {
            //create text store
        	if(!checkife(pafile, transaction)) {
        		File logFile = new File(pafile);
            
        		// Check real path
        		System.out.println("No encontre archivo, creando uno: "+logFile.getCanonicalPath());

        		writer = new BufferedWriter(new FileWriter(logFile, true));
        		writer.write("[\n"+transaction + "\n]\n");
        		writer.close();
        	}
                
                //index transactions for per transaction_id query
                if(!checkifi(indexfile, transaction)) {
        		File logFile = new File(indexfile);
                        JSONObject json4index = new JSONObject(transaction);
        		// Check real path
        		System.out.println("No encontre índices, creando uno: "+logFile.getCanonicalPath());

        		writer = new BufferedWriter(new FileWriter(logFile, true));
        		writer.write("[\n{\""+json4index.getString("transaction_id")+"\": \""+json4index.getString("user_id")+"\"}\n]\n");
        		writer.close();
        	}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
        }
    }
    private void saveDB() {
        System.err.println("Feature not yet implemented");
    }
    
    private boolean checkife(String ipath, String transaction) {
    	try {
    		Path path = Paths.get(ipath);
    		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    		int position = 1;  
    		lines.add(position, transaction+",");
    		Files.write(path, lines, StandardCharsets.UTF_8);
    		System.out.println("Escribiendo a archivo en posición: "+ Integer.toString(position) );
    	} catch(Exception e) {
    		System.err.println(e.getMessage());
    		return false;
    	} finally {
    		
    	}
    	return true;
    }
    
    private boolean checkifi(String ipath, String transaction) {
    	try {
    		Path path = Paths.get(ipath);
    		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    		int position = 1;
                JSONObject json4index = new JSONObject(transaction);
    		lines.add(position, "{\""+json4index.getString("transaction_id")+"\": \""+json4index.getString("user_id")+"\"}"+",");
    		Files.write(path, lines, StandardCharsets.UTF_8);
    		System.out.println("Escribiendo a archivo en posición: "+ Integer.toString(position) );
    	} catch(Exception e) {
    		System.err.println(e.getMessage());
    		return false;
    	} finally {
    		
    	}
    	return true;
    }
    
    public static String readdata(String fileName) {
        // This will reference one line at a time
        String line = null;
        String salida = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                salida += line;
                salida += "\n";
            }   
            JSONArray jdata = new JSONArray(salida);
            for (int i = 0; i < jdata.length(); i++) {
                JSONObject jobj = jdata.getJSONObject(i);
		//System.out.println("Transaction: "+jobj.getString("transaction_id"));
                //System.out.println("User ID: "+jobj.getInt("user_id"));
            }
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return salida;
    }
    
    public static int sumdata(String fileName) {
        
        
        String salida = "";
        int sum=0;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                salida += line;
                salida += "\n";
            }   
            JSONArray jdata = new JSONArray(salida);
            sum = jdata.length();
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return sum;
    }
    
    public static String readJson(String fileName) {
        String salida="";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
            
            try ( // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    salida += line;
                    salida += "\n";
                }
                //JSONArray jdata = new JSONArray(salida);
                // Always close files.
            }         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return salida;
    }
}
