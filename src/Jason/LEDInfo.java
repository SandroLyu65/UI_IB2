package Jason;

import org.json.JSONArray;
import org.json.JSONObject;

import static java.lang.Double.parseDouble;

public class LEDInfo extends ParseJason{
    private final String updateUrl;

    public LEDInfo() {
        this.updateUrl = "https://studev.groept.be/api/a21ib2d02/led_update/";
    }

    public void updateLED(int state, int timer){
        makeGETRequest(updateUrl + state + "/" + timer);
    }
}
