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
    private final ArrayList<Double> cumulativeHour;

    public EachHourLast24() {
        super();
        this.basicUrl = "https://studev.groept.be/api/a21ib2d02/byHour_test_by_shengzhe_0310/";
        hours = new ArrayList<>();
        eachHour = new ArrayList<>();
        cumulativeHour = new ArrayList<>();
    }

    public void setLists(){
        try {
            int endHour = 0;
            if(getNowHour() == 0)
                endHour = 23;
            else
                endHour = getNowHour() - 1;

            for(int i = getNowHour(); i < 24; i++){
                String url = basicUrl + i + ":00:00/" + i + ":59:59/" + getYesterday() ;
                addToList(i, url);
            }

            for(int i = 0; i <= endHour; i++){
                String url = basicUrl + i + ":00:00/" + i + ":59:59/" + getToday();
                addToList(i, url);
            }

            for(int i = 0; i < eachHour.size(); i++){
                double sumSoFar = 0.0;
                for(int j = 0; j <= i; j++){
                    sumSoFar += eachHour.get(j);
                }
                cumulativeHour.add(sumSoFar);
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
        else
            eachHour.add(parseDouble(curObject.getString("sumByHour")));
        hours.add(String.valueOf(i));
    }

    public int getNowHour(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        //return Integer.parseInt(sdf.format(cal.getTime()));
        return 10;
    }

    public String getYesterday(){
        LocalDate todayDate = LocalDate.now();
        //return String.valueOf(todayDate.minusDays(1));
        return "2022-03-23";
    }

    public String getToday(){
        LocalDate todayDate = LocalDate.now();
        //return String.valueOf(todayDate);
        return "2022-03-24";
    }

    public ArrayList<String> getHours() {
        return hours;
    }

    public ArrayList<Double> getEachHour() {
        return eachHour;
    }

    public ArrayList<Double> getCumulativeHour() {
        return cumulativeHour;
    }
}
