package Jason;

public class LEDInfo extends ParseJason{
    private final String basicUrl;

    public LEDInfo() {
        this.basicUrl = "https://studev.groept.be/api/a21ib2d02/led_update/";
    }

    public void updateLED(int state, int timer){
        makeGETRequest(basicUrl + state + "/" + timer);
    }
}
