package Screens;

import ChartTable.InitialTable;

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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
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

    public Bottles(String title){
        super(title);
        setContentPane(bottlesPanel);
        bottlesPanel.setPreferredSize(new Dimension(600,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radioButton1.setVisible(false);
        radioButton2.setVisible(false);
        radioButton3.setVisible(false);
        radioButton4.setVisible(false);
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
        if(InitialTable.getNames().size() >= 1){
            radioButton1.setVisible(true);
            pic1.setVisible(true);
            name1.setVisible(true);
            cap1.setVisible(true);
            //pic1.setIcon(InitialTable.getIcons().get(1));
            name1.setText(InitialTable.getNames().get(0));
            cap1.setText(InitialTable.getCapacity().get(0));
        }

        if(InitialTable.getNames().size() >= 2){
            radioButton2.setVisible(true);
            pic2.setVisible(true);
            name2.setVisible(true);
            cap2.setVisible(true);
            //pic2.setIcon(InitialTable.getIcons().get(1));
            name2.setText(InitialTable.getNames().get(1));
            cap2.setText(InitialTable.getCapacity().get(1));
        }

        if(InitialTable.getNames().size() >= 3){
            radioButton3.setVisible(true);
            pic3.setVisible(true);
            name3.setVisible(true);
            cap3.setVisible(true);
            //pic3.setIcon(InitialTable.getIcons().get(2));
            name3.setText(InitialTable.getNames().get(2));
            cap3.setText(InitialTable.getCapacity().get(2));
        }

        if(InitialTable.getNames().size() == 4){
            radioButton4.setVisible(true);
            pic4.setVisible(true);
            name4.setVisible(true);
            cap4.setVisible(true);
            //pic4.setIcon(InitialTable.getIcons().get(3));
            name4.setText(InitialTable.getNames().get(3));
            cap4.setText(InitialTable.getCapacity().get(3));
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
        /*deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton1.isSelected()){
                    InitialTable.setAll(0);
                }
                else if(radioButton2.isSelected()){
                    InitialTable.setAll(1);
                }
                else if(radioButton3.isSelected()){
                    InitialTable.setAll(2);
                }
                else {
                    InitialTable.setAll(3);
                }
                try {
                    Bottles.super.dispose();
                    JFrame bottles = new Bottles("Bottles");
                    bottles.setVisible(true);
                    bottles.pack();
                }
                catch (Exception b){

                }
            }
        });*/
    }


}
