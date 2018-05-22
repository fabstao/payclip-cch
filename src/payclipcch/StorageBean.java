/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payclipcch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

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
        try {
            //create text store
            File logFile = new File("payclipstore.dat");

            // Check real path
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(transaction + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Check null pointer
                writer.close();
            } catch (IOException e) {
            }
        }
    }
    private void saveDB() {
        System.err.println("Feature not yet implemented");
    }
}
