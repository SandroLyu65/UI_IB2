import ChartTable.InitialChart;
import Screens.Home;

import javax.swing.*;

public class mainClass {
    public static void main(String[] args) {
        InitialChart.setDataset();
        JFrame homeScreen = new Home("D2 project V1.0_0311");
        homeScreen.setVisible(true);
        homeScreen.pack();
    }
}
