package Screens;

import Charts.InitialChart;
import Charts.InitialGoal;
import Jason.GoalsInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Goals extends JFrame {
    private JButton goalsToHome;
    private JPanel goalsPanel;
    private JTextField eachDayGoalTextField;
    private JLabel eachDayGoalLabel;
    private JButton saveButton;
    private JLabel nowEachDayGoalLabel;
    private JLabel ledSetting;
    private JRadioButton openRadioButton;
    private JRadioButton closeRadioButton;
    private JLabel timerSetting;
    private JTextField timerTextField;

    public Goals(String title) {
        super(title);
        setContentPane(goalsPanel);
        //goalsLabel.setPreferredSize(new Dimension(600,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        eachDayGoalTextField.setText(String.valueOf(InitialChart.getEachDayGoal()));
        timerTextField.setText(String.valueOf(InitialChart.getTimer()));
        nowEachDayGoalLabel.setText("Now goal: " + InitialChart.getEachDayGoal() + " per day");

        openRadioButton.setSelected(true);
        goalsToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Goals.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                String src = "./files/window.png";
                home.setIconImage(new ImageIcon(src).getImage());
                home.setVisible(true);
                home.pack();
            }

        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    nowEachDayGoalLabel.setText("Now goal: " + Double.parseDouble(eachDayGoalTextField.getText()) + " per day");
                    double newGoalDay = Double.parseDouble(eachDayGoalTextField.getText());
                    int newTimer = Integer.parseInt(timerTextField.getText());
                    GoalsInfo goalsInfo = new GoalsInfo();
                    goalsInfo.updateGoal(newGoalDay, newTimer);
                    InitialChart.setDataset();
                    InitialGoal.setDataset();
                } catch (Exception e) {
                    nowEachDayGoalLabel.setText("Please input double and save");
                }
            }

        });

        openRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (openRadioButton.isSelected()) {
                    closeRadioButton.setSelected(false);
                }
            }
        });

        closeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (closeRadioButton.isSelected()) {
                    openRadioButton.setSelected(false);
                }
            }
        });
    }
}