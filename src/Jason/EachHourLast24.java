package Jason;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Double.parseDouble;

public class EachHourLast24 extends ParseJason{
    private final String basicUrl;
    private final ArrayList<String> hours;
    private final ArrayList<Double> eachHour;
    private double cummulative;

    public EachHourLast24() {
        super();
        this.basicUrl = "https://studev.groept.be/api/a21ib2d02/water_get_byHour/";
        hours = new ArrayList<>();
        eachHour = new ArrayList<>();
    }

    public void setLists(){
        try {
            int endHour = getNowHour();

            for(int i = 0; i <= endHour; i++){
                String url = basicUrl + i + ":00:00/" + i + ":59:59/" + getToday();
                addToList(i, url);
            }

            if(endHour < 24){
                for(int i = endHour + 1; i < 24; i++){
                    String url = basicUrl + i + ":00:00/" + i + ":59:59/" + getToday();
                    addToList(i, url);
                }
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void addToList(int i, String url) {
        JSONArray array = new JSONArray(makeGETRequest(url));
        JSONObject curObject = array.getJSONObject(0);

        if(JSONObject.NULL.equals(curObject.get("sumByHour")))
            eachHour.add(0.0);
        else {
            eachHour.add(parseDouble(curObject.getString("sumByHour")));
            cummulative+=parseDouble(curObject.getString("sumByHour"));
        }
        hours.add(String.valueOf(i));
    }

    public int getNowHour(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return Integer.parseInt(sdf.format(cal.getTime()));
    }

    public String getToday(){
        LocalDate todayDate = LocalDate.now();
        return String.valueOf(todayDate);
    }

    public ArrayList<String> getHours() {
        return hours;
    }

    public ArrayList<Double> getAmountEachHour() {
        return eachHour;
    }

    public double getCummulative(){
        return cummulative;
    }
}
