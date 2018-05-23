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
        System.out.println("List from User ID: "+user_id);
        StorageBean leer = new StorageBean(0);
        String salida = leer.readdata("pcchstore.dat");
        System.out.println(salida);
    }
}
