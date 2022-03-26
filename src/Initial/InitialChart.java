package Initial;

import Jason.EachDayLast7;
import Jason.EachHourLast24;
import Jason.GoalsInfo;
import org.jfree.data.category.DefaultCategoryDataset;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class InitialChart {

    private static final DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();
    private static final DefaultCategoryDataset barChartDayDataset = new DefaultCategoryDataset();
    private static final DefaultCategoryDataset lineBase = new DefaultCategoryDataset();
    protected static double eachDayGoal = 4;
    protected static int timer = 10;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public InitialChart() {
    }

    public static void setDataset() {
        barChartDataset.clear();
        barChartDayDataset.clear();
        lineBase.clear();

        GoalsInfo goalsInfo = new GoalsInfo();
        eachDayGoal = goalsInfo.getGoal();
        timer = goalsInfo.getTimer();

        EachHourLast24 eachHourLast24 = new EachHourLast24();
        eachHourLast24.setLists();
        ArrayList<Double> eachHour = eachHourLast24.getAmountEachHour();
        ArrayList<String> hours = eachHourLast24.getHours();

        for(int i = 0; i < 24; i++){
            barChartDataset.addValue(eachHour.get(i), "water", hours.get(i));
        }

        EachDayLast7 eachDayLast7 = new EachDayLast7();
        eachDayLast7.setLists();
        ArrayList<Double> eachDay = eachDayLast7.getEachDay();
        ArrayList<String> days = eachDayLast7.getDays();

        for(int i = 0; i < 7; i++){
            lineBase.addValue(eachDayGoal,"water", days.get(i));
            barChartDayDataset.addValue(eachDay.get(i), "water", days.get(i));
        }
    }

    public static DefaultCategoryDataset getBarChartDataset() {
        return barChartDataset;
    }

    public static DefaultCategoryDataset getBarChartDayDataset() {
        return barChartDayDataset;
    }

    public static DefaultCategoryDataset getLineBase() {return lineBase;}

    public static double getEachDayGoal() {
        return eachDayGoal;
    }

    public static int getTimer() {
        return timer;
    }
}
