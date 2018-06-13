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
    public static void tadd(String userid, String otransaction) {
        transactionid = UUID.randomUUID();
        String transaction = "";
        try{
            transaction = new String(otransaction.getBytes("UTF-8"), "UTF-8");
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        JSONObject jtrans = new JSONObject(transaction);
        String muserid="";
        try {
            muserid = jtrans.getString("user_id");
            if(muserid.equals(userid)) {
                jtrans.put("transaction_id", transactionid);
                log(jtrans);
                SaveTransaction.tsave(userid, jtrans.toString());
            }
            else {
                System.out.println("ERROR: Not saved, incorrect transaction: user_id: " + 
                        muserid + " " + userid);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Not saved, incorrect transaction: user_id | "+
                    e.getLocalizedMessage());
        }
        
    }
    private static void log(Object theObject){
        System.out.println("Transaction: "+String.valueOf(theObject) );
    }
}
