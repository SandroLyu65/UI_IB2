package Initial;

import Jason.EachHourLast24;
import Jason.LEDInfo;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class InitialGoal extends InitialChart{
    private static double capacity = 0.5;
    private static double todayFinished = 3.1;
    private static boolean ledState = true;
    private static DefaultCategoryDataset bottlesDataset = new DefaultCategoryDataset();

    public InitialGoal() {
    }

    public static void setDataset() {
        bottlesDataset.clear();

        EachHourLast24 eachHourLast24 = new EachHourLast24();
        eachHourLast24.setLists();
        todayFinished = eachHourLast24.getCummulative();

        int amount = (int) Math.ceil(eachDayGoal/capacity);
        double eachBottle = eachDayGoal/amount;
        double today = todayFinished;
        double[][] eachBottleArray= new double[2][amount];

        LEDInfo ledInfo = new LEDInfo();
        if(!ledState || todayFinished>=eachDayGoal)
            ledInfo.updateLED(0,timer);
        else
            ledInfo.updateLED(1,timer);

        for(int i = 0; i < amount; i++){
            double thisBottle = today - eachBottle;
            if(thisBottle > 0) {
                eachBottleArray[1][i]=0.0;
                eachBottleArray[0][i]=eachBottle;
                today-=eachBottle;
            }
            else {
                eachBottleArray[1][i]=eachBottle-today;
                eachBottleArray[0][i]=today;
                today=0.0;
            }
        }

        bottlesDataset = (DefaultCategoryDataset) DatasetUtilities.createCategoryDataset(
                "", "", eachBottleArray);
    }

    public static void setCapacity(double newCapacity){
        capacity = newCapacity;
    }

    public static void setLedState(boolean newLedState) {
        ledState = newLedState;
    }

    public static DefaultCategoryDataset getDataset(){
        return bottlesDataset;
    }

    public static double getCapacity() {
        return capacity;
    }

    public static boolean getLedState() {
        return ledState;
    }

    public static double getTodayFinished() {
        return todayFinished;
    }
}
