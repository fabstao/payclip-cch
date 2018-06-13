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
public class SumTransactions {
    public static void tsum(String user_id){
        StorageBean suma = new StorageBean(user_id,0);
        int salida = suma.sumdata(user_id+".dat");
        System.out.println("{ \"user_id\": \""+user_id+
                "\", \"sum\": "+String.valueOf(salida)+" }");
    }
    
}
