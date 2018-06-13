/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;

/**
 *
 * @author fsalaman
 */
public class ListTransactions {
    public static void tlist(String user_id){
        StorageBean leer = new StorageBean(user_id,0);
        String salida = leer.readdata(user_id+".dat");
        System.out.println(salida);
    }
}
