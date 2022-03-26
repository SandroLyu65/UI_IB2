package Screens;

import Initial.InitialChart;
import Initial.InitialGoal;
import Jason.GoalsInfo;

import javax.swing.*;
import java.awt.*;
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
    private static final Font uiFont = new Font("Segoe UI",Font.BOLD,16);
    private static final Font x = new Font("Monospaced",1,16);

    public Goals(String title) {
        super(title);
        setContentPane(goalsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(700, 350));

        goalsToHome.setFont(uiFont);
        saveButton.setFont(uiFont);
        nowEachDayGoalLabel.setFont(x);
        eachDayGoalLabel.setFont(uiFont);
        timerSetting.setFont(uiFont);
        ledSetting.setFont(uiFont);
        openRadioButton.setFont(x);
        closeRadioButton.setFont(x);

        eachDayGoalTextField.setText(String.valueOf(InitialChart.getEachDayGoal()));
        timerTextField.setText(String.valueOf(InitialChart.getTimer()));
        nowEachDayGoalLabel.setText("Today's goal: " + InitialChart.getEachDayGoal() + "L per day");

        openRadioButton.setSelected(true);
        goalsToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Goals.super.dispose();
                JFrame home = new Home("Home");
                String src = "./files/window.png";
                home.setIconImage(new ImageIcon(src).getImage());
                home.setVisible(true);
                home.pack();
                home.setLocationRelativeTo(null);
                //home.setExtendedState(home.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    nowEachDayGoalLabel.setText("Today's goal: " + Double.parseDouble(eachDayGoalTextField.getText()) + "L per day");
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
                    InitialGoal.setLedState(true);
                    closeRadioButton.setSelected(false);
                }
            }
        });

        closeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (closeRadioButton.isSelected()) {
                    InitialGoal.setLedState(false);
                    openRadioButton.setSelected(false);
                }
            }
        });
    }
}