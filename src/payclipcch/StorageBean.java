package payclipcch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.attribute.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
//import org.json.JSONObject;
import java.nio.file.Paths;

/**
 *
 * @author fsalaman
 */
public class StorageBean {
    public static final int FILE=0;
    public static final int DB=1;
    private int option;
    
    public StorageBean(int option){
        this.option = option;
    }
    
    public void Commit(String transaction) {
        switch(this.option){
            case 0:
                saveFile(transaction);
                break;
            case 1:
                saveDB();
                break;
        }
    }
    
    private void saveFile(String transaction) {
    	BufferedWriter writer = null;
    	String pafile = "pcchstore.dat";
    	
        try {
            //create text store
        	if(!checkife(pafile, transaction)) {
        		File logFile = new File(pafile);
            
        		// Check real path
        		System.out.println("No encontre archivo, creando uno: "+logFile.getCanonicalPath());

        		writer = new BufferedWriter(new FileWriter(logFile, true));
        		writer.write("{[\n"+transaction + "\n]}\n");
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
}
