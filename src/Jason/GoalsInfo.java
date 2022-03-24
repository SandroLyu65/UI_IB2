package Jason;

import org.json.JSONArray;
import org.json.JSONObject;

public class GoalsInfo extends ParseJason{
    private final String getUrl;
    private final String updateUrl;

    public GoalsInfo() {
        this.getUrl = "https://studev.groept.be/api/a21ib2d02/goalsget";
        this.updateUrl = "https://studev.groept.be/api/a21ib2d02/GoalsSet/";
    }

    public int getGoal() {
        JSONArray array = new JSONArray(makeGETRequest(getUrl));
        JSONObject curObject = array.getJSONObject(0);

        return Integer.parseInt(curObject.getString("day_goal"));
    }

    public int getTimer() {
        JSONArray array = new JSONArray(makeGETRequest(getUrl));
        JSONObject curObject = array.getJSONObject(0);

        return Integer.parseInt(curObject.getString("timer"));
    }

    public void updateGoal(int goal, int timer){
        makeGETRequest(updateUrl + goal + "/" + timer);
    }
}