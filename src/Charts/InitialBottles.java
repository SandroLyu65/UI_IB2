package Charts;

import Jason.BottlesInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class InitialBottles {
    private static final BottlesInfo BottlesInfo = new BottlesInfo();
    private static final ArrayList<Icon> icons = new ArrayList<>(4);
    private static ArrayList<String> names = new ArrayList<>(4);
    private static ArrayList<Double> capacity = new ArrayList<>(4);
    private static ArrayList<String> paths = new ArrayList<>(4);

    public InitialBottles() {
    }

    public static void setBottles(){
        BottlesInfo.setList();
        names = BottlesInfo.getNames();
        capacity = BottlesInfo.getCapacities();
        paths = BottlesInfo.getFileNames();
        setIcons();
    }

    public static void insertRecord(String name, String capacity, String path){
        BottlesInfo.insertBottle(names.size() + 1, name, capacity, path);
    }

    public static void deleteRecord(int index){
        BottlesInfo.deleteBottle(index);
    }

    public static void setIcons(){
        icons.clear();
        for (String path : paths) {
            ImageIcon newIcon = new ImageIcon(path);
            int ratio = 100 / newIcon.getIconHeight();
            int newWidth = ratio * newIcon.getIconWidth();
            Image img = newIcon.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT);
            Icon finalIcon = new ImageIcon(img);
            icons.add(finalIcon);
        }
    }

    public static ArrayList<Icon> getIcons(){
        return icons;
    }

    public static ArrayList<String> getNames(){
        return names;
    }

    public static ArrayList<Double> getCapacity(){
        return capacity;
    }
}
