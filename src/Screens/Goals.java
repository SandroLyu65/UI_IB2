package Screens;

import ChartTable.InitialChart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Goals extends JFrame{
    private JButton goalsToHome;
    private JPanel goalsPanel;
    private JLabel goalsLabel;
    private JTextField eachDayGoalTextField;
    private JLabel eachDayGoalLabel;
    private JButton saveButton;
    private JLabel nowEachDayGoalLabel;

    public Goals(String title){
        super(title);
        setContentPane(goalsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nowEachDayGoalLabel.setText("Now goal: 3.0 per day");

        goalsToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Goals.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                home.setVisible(true);
                home.pack();
            };
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    InitialChart.setEachDayGoal(Double.parseDouble(eachDayGoalTextField.getText()));
                    nowEachDayGoalLabel.setText("Now goal: " + Double.parseDouble(eachDayGoalTextField.getText()) + " per day");
                    InitialChart.setDataset();
                }
                catch (Exception e){
                    nowEachDayGoalLabel.setText("Please input double and save");
                }
            };
        });
    }
}
