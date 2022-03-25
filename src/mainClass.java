import Charts.InitialGoal;
import Charts.InitialChart;
import Charts.InitialBottles;
import Screens.Home;

import javax.swing.*;

public class mainClass {
    public static void main(String[] args) {
        InitialChart.setDataset();
        InitialGoal.setDataset();
        InitialBottles.setBottles();

        JFrame homeScreen = new Home("D2 project V1.0_0311");
        homeScreen.setVisible(true);
        homeScreen.pack();
        homeScreen.setExtendedState(homeScreen.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}
