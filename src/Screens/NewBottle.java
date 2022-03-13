package Screens;

import ChartTable.InitialChart;
import ChartTable.InitialTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBottle extends JFrame{
    private JPanel newBottlePanel;
    private JTextField newBottleNameTextField;
    private JButton saveButton;
    private JLabel newBottleNameLabel;

    public NewBottle(String title) {
        super(title);
        setContentPane(newBottlePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    InitialTable.addToTable(newBottleNameTextField.getText());
                    NewBottle.super.dispose();
                    JFrame bottles = new Bottles("Bottles");
                    bottles.setVisible(true);
                    bottles.pack();
                }
                catch (Exception e){
                    newBottleNameTextField.setText("Do that again");
                }
            }
        });
    }
}
