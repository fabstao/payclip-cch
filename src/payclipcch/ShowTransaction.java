/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author fsalaman
 */
public class ShowTransaction {
    public static void tshow(String transaction_id){
        String indice = StorageBean.readJson(StorageBean.indexfile);
        JSONArray oindice = new JSONArray(indice);
        int j = oindice.length();
        String ui = "";
        int flag = 0;
        for (int i=0;i<j;i++){
            JSONObject jobj = oindice.getJSONObject(i);
            try {
                ui = jobj.getString(transaction_id);
                flag = 1;
            } catch(Exception e) {
            
            }
        }
        if(flag==0){
            System.out.println("Transaction not found");
            System.exit(0);
        }
        String jstransa = StorageBean.readJson(ui+".dat");
        JSONArray otransa = new JSONArray(jstransa);
        j = otransa.length();
        for (int i=0;i<j;i++){
            JSONObject jobj = otransa.getJSONObject(i);
            if(jobj.getString("transaction_id").equals(transaction_id)) 
                System.out.println(jobj.toString());
        }
    }
}
