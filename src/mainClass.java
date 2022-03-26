import Initial.InitialGoal;
import Initial.InitialChart;
import Initial.InitialBottles;
import Screens.Home;

import javax.swing.*;

public class mainClass {
    public static void main(String[] args) {
        InitialChart.setDataset();
        InitialBottles.setBottles();
        InitialGoal.setDataset();

        JFrame homeScreen = new Home("Home");
        String src = "./files/window.png";
        homeScreen.setIconImage(new ImageIcon(src).getImage());
        homeScreen.setVisible(true);
        homeScreen.pack();
        homeScreen.setLocationRelativeTo(null);
        //homeScreen.setExtendedState(homeScreen.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}
