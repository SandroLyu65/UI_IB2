package Jason;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BottlesInfo extends ParseJason{
    private final String basicUrl;
    private final ArrayList<String> names;
    private final ArrayList<String> capacities;

    public BottlesInfo() {
        super();
        this.basicUrl = "https://studev.groept.be/api/a21ib2d02/bottle_info";
        names = new ArrayList<>();
        capacities = new ArrayList<>();
    }

    public void setLists(){
        try {
                int i = 1;
                names.clear();
                capacities.clear();
                JSONArray array = new JSONArray(makeGETRequest(basicUrl));
                System.out.println(array.length());
                while (i < 4 && array.length() - i >= 0){
                    addToList(array.length()-i,array);
                    i++;
                }
            }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void clearLists(){
        String url = "https://studev.groept.be/api/a21ib2d02/bottle_reset";
        makeGETRequest(url);
    }

    public void insertLists(String i, String name, String capacity){
        String url = "https://studev.groept.be/api/a21ib2d02/bottle_insert";
        makeGETRequest(url+"/"+i+"/"+name+"/"+capacity);
    }

    private void addToList(int i,JSONArray array) {

        JSONObject curObject = array.getJSONObject(i);
        names.add(curObject.getString("name"));
        capacities.add(curObject.getString("capacity"));
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getCapacities() {
        return capacities;
    }
}
