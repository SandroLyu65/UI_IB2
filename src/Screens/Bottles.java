package Screens;

import ChartTable.InitialTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bottles extends JFrame{
    private JButton bottlesToHome;
    private JPanel bottlesPanel;
    private JLabel bottlesLabel;
    private JTable bottlesTable;
    private JButton addBottleButton;

    public Bottles(String title){
        super(title);
        setContentPane(bottlesPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }

    private void createUIComponents() {
        String[] columnNames = { "ID", "name"};
        bottlesTable = new JTable(InitialTable.getData(), columnNames);
    }
}
