package Screens;

import ChartTable.InitialChart;
import Jason.GoalsInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Goals extends JFrame{
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
    private JTextField a30TextField;
    private int goalDay;
    private int Timer;
    private String basicUrl;

    public Goals(String title){
        super(title);
        setContentPane(goalsPanel);
        //goalsLabel.setPreferredSize(new Dimension(600,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GoalsInfo t = new GoalsInfo();
        eachDayGoalTextField.setText(String.valueOf(t.getGoal()));
        a30TextField.setText(String.valueOf(t.getTimer()));

        nowEachDayGoalLabel.setText("Now goal: "+t.getGoal()+ " per day");
        openRadioButton.setSelected(true);
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
                    goalDay=Integer.parseInt(eachDayGoalTextField.getText());
                    Timer=Integer.parseInt(a30TextField.getText());
                    GoalsInfo goalsInfo = new GoalsInfo();
                    goalsInfo.updateGoal(goalDay,Timer);


                }
                catch (Exception e){
                    nowEachDayGoalLabel.setText("Please input double and save");
                }
            };
        });
        openRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(openRadioButton.isSelected()){
                    closeRadioButton.setSelected(false);
                }
            }
        });
        closeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(closeRadioButton.isSelected()){
                    openRadioButton.setSelected(false);
                }
            }
        });
    }
}