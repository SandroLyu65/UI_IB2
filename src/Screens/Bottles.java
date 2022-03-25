package Screens;

import Charts.InitialBottles;
import Charts.InitialGoal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bottles extends JFrame{
    private JButton bottlesToHome;
    private JPanel bottlesPanel;
    private JLabel bottlesLabel;
    private JButton addBottleButton;
    private JButton deleteButton;
    private JRadioButton selectRadioButton1;
    private JRadioButton selectRadioButton2;
    private JRadioButton selectRadioButton3;
    private JRadioButton selectRadioButton4;
    private JLabel colName1;
    private JLabel colName2;
    private JLabel colName3;
    private JLabel colName4;
    private JLabel pic1;
    private JLabel pic2;
    private JLabel pic3;
    private JLabel pic4;
    private JLabel name1;
    private JLabel name2;
    private JLabel name3;
    private JLabel name4;
    private JLabel cap1;
    private JLabel cap2;
    private JLabel cap3;
    private JLabel cap4;
    private JButton selectButton;

    public Bottles(String title){
        super(title);
        setContentPane(bottlesPanel);
        bottlesPanel.setPreferredSize(new Dimension(600,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectRadioButton1.setVisible(false);
        selectRadioButton2.setVisible(false);
        selectRadioButton3.setVisible(false);
        selectRadioButton4.setVisible(false);
        pic1.setVisible(false);
        pic2.setVisible(false);
        pic3.setVisible(false);
        pic4.setVisible(false);
        name1.setVisible(false);
        name2.setVisible(false);
        name3.setVisible(false);
        name4.setVisible(false);
        cap1.setVisible(false);
        cap2.setVisible(false);
        cap3.setVisible(false);
        cap4.setVisible(false);

        if(InitialBottles.getNames().size() >= 1){
            selectRadioButton1.setVisible(true);
            pic1.setVisible(true);
            name1.setVisible(true);
            cap1.setVisible(true);
            pic1.setIcon(InitialBottles.getIcons().get(0));
            name1.setText(InitialBottles.getNames().get(0));
            cap1.setText(String.valueOf(InitialBottles.getCapacity().get(0)));
        }

        if(InitialBottles.getNames().size() >= 2){
            selectRadioButton2.setVisible(true);
            pic2.setVisible(true);
            name2.setVisible(true);
            cap2.setVisible(true);
            pic2.setIcon(InitialBottles.getIcons().get(1));
            name2.setText(InitialBottles.getNames().get(1));
            cap2.setText(String.valueOf(InitialBottles.getCapacity().get(1)));
        }

        if(InitialBottles.getNames().size() >= 3){
            selectRadioButton3.setVisible(true);
            pic3.setVisible(true);
            name3.setVisible(true);
            cap3.setVisible(true);
            pic3.setIcon(InitialBottles.getIcons().get(2));
            name3.setText(InitialBottles.getNames().get(2));
            cap3.setText(String.valueOf(InitialBottles.getCapacity().get(2)));
        }

        if(InitialBottles.getNames().size() == 4){
            selectRadioButton4.setVisible(true);
            pic4.setVisible(true);
            name4.setVisible(true);
            cap4.setVisible(true);
            pic4.setIcon(InitialBottles.getIcons().get(3));
            name4.setText(InitialBottles.getNames().get(3));
            cap4.setText(String.valueOf(InitialBottles.getCapacity().get(3)));
        }

        bottlesToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Bottles.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                home.setVisible(true);
                home.pack();
            };
        });

        addBottleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bottles.super.dispose();
                JFrame newBottle = new NewBottle("New Bottle");
                newBottle.setVisible(true);
                newBottle.pack();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectRadioButton1.isSelected()){
                    InitialBottles.deleteRecord(1);
                }
                else if(selectRadioButton2.isSelected()){
                    InitialBottles.deleteRecord(2);
                }
                else if(selectRadioButton3.isSelected()){
                    InitialBottles.deleteRecord(3);
                }
                else {
                    InitialBottles.deleteRecord(4);
                }
                try {
                    InitialBottles.setBottles();
                    Bottles.super.dispose();
                    JFrame bottles = new Bottles("Bottles");
                    bottles.setVisible(true);
                    bottles.pack();
                }
                catch (Exception b){
                    b.printStackTrace();
                }
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectRadioButton1.isSelected()){
                    InitialGoal.setCapacity(InitialBottles.getCapacity().get(0));
                }
                else if(selectRadioButton2.isSelected()){
                    InitialGoal.setCapacity(InitialBottles.getCapacity().get(1));
                }
                else if(selectRadioButton3.isSelected()){
                    InitialGoal.setCapacity(InitialBottles.getCapacity().get(2));
                }
                else if(selectRadioButton4.isSelected()){
                    InitialGoal.setCapacity(InitialBottles.getCapacity().get(3));
                }
                else{
                    InitialGoal.setCapacity(InitialBottles.getCapacity().get(0));
                }
                InitialGoal.setDataset();
            }
        });

        selectRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectRadioButton1.isSelected()) {
                    selectRadioButton2.setSelected(false);
                    selectRadioButton3.setSelected(false);
                    selectRadioButton4.setSelected(false);
                }
            }
        });

        selectRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectRadioButton2.isSelected()) {
                    selectRadioButton1.setSelected(false);
                    selectRadioButton3.setSelected(false);
                    selectRadioButton4.setSelected(false);
                }
            }
        });

        selectRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectRadioButton3.isSelected()) {
                    selectRadioButton1.setSelected(false);
                    selectRadioButton2.setSelected(false);
                    selectRadioButton4.setSelected(false);
                }
            }
        });

        selectRadioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectRadioButton4.isSelected()) {
                    selectRadioButton1.setSelected(false);
                    selectRadioButton2.setSelected(false);
                    selectRadioButton3.setSelected(false);
                }
            }
        });
    }
}
