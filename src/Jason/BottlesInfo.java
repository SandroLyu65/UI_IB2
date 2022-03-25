package Jason;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BottlesInfo extends ParseJason {
    private final String getUrl;
    private final String insertUrl;
    private final String deleteUrl;
    private final ArrayList<String> names;
    private final ArrayList<Double> capacities;
    private final ArrayList<String> fileNames;

    public BottlesInfo() {
        super();
        this.getUrl = "https://studev.groept.be/api/a21ib2d02/bottle_info";
        this.insertUrl = "https://studev.groept.be/api/a21ib2d02/bottle_insert/";
        this.deleteUrl = "https://studev.groept.be/api/a21ib2d02/bottle_delete/";
        names = new ArrayList<>();
        capacities = new ArrayList<>();
        fileNames = new ArrayList<>();
    }

    public void setList() {
        try {
            names.clear();
            capacities.clear();
            fileNames.clear();
            JSONArray array = new JSONArray(makeGETRequest(getUrl));
            int i = 0;
            while (i < 4 && array.length() - i - 1 >= 0) {
                addToList(i, array);
                i++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addToList(int index, JSONArray array) {
        JSONObject curObject = array.getJSONObject(index);
        names.add(curObject.getString("name"));
        capacities.add(Double.parseDouble(curObject.getString("capacity")));
        fileNames.add("./icons/" + curObject.getString("file_name"));
    }

    public void insertBottle(int index, String name, String capacity, String fileName) {
        makeGETRequest(insertUrl + index + "/" + name + "/" + capacity + "/" + fileName);
    }


    public void deleteBottle(int index) {
        makeGETRequest(deleteUrl + index);
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Double> getCapacities() {
        return capacities;
    }
    public ArrayList<String> getFileNames() {
        return fileNames;
    }

}
