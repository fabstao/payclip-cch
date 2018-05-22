/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payclipcch;

/**
 *
 * @author fsalaman
 */
public class SaveTransaction {
    public static void tsave(String transaction) {
        //In order to use MongoDB instead of files, change option to 1
        StorageBean tsave = new StorageBean(0);
        tsave.Commit(transaction);
    }
    
}
