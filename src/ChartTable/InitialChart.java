package ChartTable;

import Jason.EachDayLast7;
import Jason.EachHourLast24;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class InitialChart {

    private static final DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();
    private static final DefaultCategoryDataset lineChartDataSet = new DefaultCategoryDataset();
    private static final DefaultCategoryDataset barChartDayDataset = new DefaultCategoryDataset();
    private static final DefaultPieDataset pieChartDataset = new DefaultPieDataset();
    private static double eachDayGoal = 3.0;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public InitialChart() {
    }

    public static void setDataset() {
        barChartDataset.clear();
        lineChartDataSet.clear();
        barChartDayDataset.clear();
        pieChartDataset.clear();

        EachHourLast24 eachHourLast24 = new EachHourLast24();
        eachHourLast24.setLists();
        ArrayList<Double> eachHour = eachHourLast24.getEachHour();
        ArrayList<Double> cumulative = eachHourLast24.getCumulativeHour();
        ArrayList<String> hours = eachHourLast24.getHours();

        for(int i = 0; i < 24; i++){
            barChartDataset.addValue(eachHour.get(i), "water", hours.get(i));
            lineChartDataSet.addValue(cumulative.get(i), "water", hours.get(i));}

        EachDayLast7 eachDayLast7 = new EachDayLast7();
        eachDayLast7.setLists();
        ArrayList<Double> eachDay = eachDayLast7.getEachDay();
        ArrayList<String> days = eachDayLast7.getDays();

        double sumEachDayByGoal = 0.0;
        for(int i = 0; i < 7; i++){
            barChartDayDataset.addValue(eachDay.get(i), "water", days.get(i));

            double eachDayByGoal = Double.parseDouble(df.format(eachDay.get(i)/eachDayGoal));
            if(eachDayByGoal>=1.000)
                eachDayByGoal=1.000;
            sumEachDayByGoal+=eachDayByGoal;
            String display = days.get(i) + " = " + eachDayByGoal*100 + "%";
            pieChartDataset.setValue(display, eachDayByGoal);
        }
        double rest = 7.0 - sumEachDayByGoal;
        pieChartDataset.setValue("not finished", rest);
    }

    public static void setEachDayGoal(double newGoal){
        eachDayGoal = newGoal;
    }

    public static DefaultCategoryDataset getBarChartDataset() {
        return barChartDataset;
    }

    public static DefaultCategoryDataset getLineChartDataset() {
        return lineChartDataSet;
    }

    public static DefaultCategoryDataset getBarChartDayDataset() {
        return barChartDayDataset;
    }

    public static DefaultPieDataset getPieChartDataset(){
        return pieChartDataset;
    }
}
