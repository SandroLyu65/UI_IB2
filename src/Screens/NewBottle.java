package Screens;

import Initial.InitialBottles;
import Initial.InitialGoal;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewBottle extends JFrame{
    private JPanel newBottlePanel;
    private JTextField newBottleNameTextField;
    private JButton saveButton;
    private JLabel newBottleNameLabel;
    private JLabel newCapacityLabel;
    private JTextField newCapacityTextField;
    private JButton selectFromFileButton;
    private JLabel newPictureLabel;
    private JLabel newPicturePath;
    private JButton backToBottle;
    private static final Font uiFont = new Font("Segoe UI",Font.BOLD,16);
    private static final Font x = new Font("Monospaced",1,16);

    public NewBottle(String title) {
        super(title);
        setContentPane(newBottlePanel);
        newBottlePanel.setPreferredSize(new Dimension(600,400));
        newPicturePath.setSize(50,0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        selectFromFileButton.setFont(uiFont);
        backToBottle.setFont(uiFont);
        newPictureLabel.setFont(uiFont);
        newBottleNameLabel.setFont(uiFont);
        newCapacityLabel.setFont(uiFont);
        saveButton.setFont(uiFont);

        newPicturePath.setVisible(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    InitialBottles.insertRecord(newBottleNameTextField.getText(),newCapacityTextField.getText(),newPicturePath.getText());
                    InitialBottles.setBottles();
                    if(InitialBottles.getCapacity().size()==1)
                        InitialGoal.setDataset();
                    NewBottle.super.dispose();
                    JFrame bottles = new Bottles("Bottles");
                    String src = "./files/window.png";
                    bottles.setIconImage(new ImageIcon(src).getImage());
                    bottles.setVisible(true);
                    bottles.pack();
                    bottles.setLocationRelativeTo(null);
                }
                catch (Exception e){
                    newBottleNameTextField.setText("Do that again");
                }
            }
        });


        selectFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setMultiSelectionEnabled(true);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
                jFileChooser.setFileFilter(filter);
                int returnVal = jFileChooser.showOpenDialog(selectFromFileButton);
                if (returnVal == jFileChooser.APPROVE_OPTION){
                    File[] arrfiles = jFileChooser.getSelectedFiles();
                    if(arrfiles == null || arrfiles.length == 0){
                        return;
                    }
                    File file = jFileChooser.getSelectedFile();
                    String fileName = file.getName();
                    String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
                    if(!(prefix.equals("jpg")||prefix.equals("png"))){
                        JOptionPane.showMessageDialog(new JDialog(),"Please open the .jpg or .png in './icons/'");
                        return;
                    }
                    //String absolutePath = jFileChooser.getSelectedFile().getAbsolutePath();
                    newPicturePath.setVisible(true);
                    newPicturePath.setText(fileName);
                }
            }
        });

        backToBottle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NewBottle.super.dispose();
                    JFrame bottles = new Bottles("Bottles");
                    String src = "./files/window.png";
                    bottles.setIconImage(new ImageIcon(src).getImage());
                    bottles.setVisible(true);
                    bottles.pack();
                    bottles.setLocationRelativeTo(null);
                }
                catch (Exception b){
                    newBottleNameTextField.setText("Do that again");
                }
            }
        });
    }
}

