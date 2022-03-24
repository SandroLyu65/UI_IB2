import ChartTable.InitialChart;
import ChartTable.InitialTable;
import Screens.Home;

import javax.swing.*;

public class mainClass {
    public static void main(String[] args) {
        InitialChart.setDataset();
        InitialTable.initialArray();
        JFrame homeScreen = new Home("D2 project V1.0_0311");
        homeScreen.setVisible(true);
        homeScreen.pack();
        homeScreen.setExtendedState(homeScreen.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}
