/*
 * (C) 2018 Fabian Salamanca Dominguez
 */
package payclipcch;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONException;

/**
 *
 * @author fsalaman
 */
public class ListTransactions {
    public static void tlist(String user_id){
        StorageBean leer = new StorageBean(user_id,0);
        String salida = leer.readdata(user_id+".dat");
        JSONArray jsonArr = new JSONArray(salida);
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.length(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        Collections.sort( jsonValues, new Comparator<JSONObject>() {
        //You can change "Name" with "ID" if you want to sort by ID
        private static final String KEY_NAME = "date";

        @Override
        public int compare(JSONObject a, JSONObject b) {
            String valA = new String();
            String valB = new String();

            try {
                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);
            } 
            catch (JSONException e) {
                //do something
            }

            return valA.compareTo(valB);
            //if you want to change the sort order, simply use the following:
            //return -valA.compareTo(valB);
            }
        });
        System.out.println("[");
        String coma=",";
        for (int i = 0; i < jsonArr.length(); i++) {
            sortedJsonArray.put(jsonValues.get(i));
            if(i==(jsonArr.length()-1))
                coma ="";
            System.out.println(jsonValues.get(i).toString()+coma);
        }
        System.out.println("]");
        //System.out.println(sortedJsonArray.toString());
    }
}
