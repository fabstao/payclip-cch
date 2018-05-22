/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;
import java.util.*;
import org.json.*;
/**
 *
 * @author fsalaman
 */
public class AddTransaction {
    private static UUID transactionid;
    public static void tadd(String userid, String transaction) {
        transactionid = UUID.randomUUID();
        JSONObject jtrans = new JSONObject(transaction);
        jtrans.put("transaction_id", transactionid);
        log(jtrans);
        SaveTransaction.tsave(transaction);
    }
    private static void log(Object theObject){
        System.out.println("Transaction: "+String.valueOf(theObject) );
    }
}
