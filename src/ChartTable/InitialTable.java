package ChartTable;

import Jason.BottlesInfo;

import javax.swing.*;
import java.util.ArrayList;

public class InitialTable {
    //private static Object[][] data = {{"id","path","name","capacity"}};
    //private static ArrayList<String> paths = new ArrayList<>(4);
    private static BottlesInfo BottlesInfo = new BottlesInfo();
    private static ArrayList<Icon> icons = new ArrayList<>(4);
    private static ArrayList<String> names = new ArrayList<>(4);
    private static ArrayList<String> capacity = new ArrayList<>(4);
    public InitialTable() {
    }

    /*public static void addToTable(String newPath,String newName,String newCapacity){
        GetBottleInfo.setLists();
        if(GetBottleInfo.getNames().size() == 4){
            //paths.remove(0);
            icons.remove(0);
            names.remove(0);
            capacity.remove(0);
            GetBottleInfo.clearLists();
            for(int i = 0 ; i <= 3; i++){
                GetBottleInfo.insertLists(String.valueOf(i+1),names.get(i),capacity.get(i));
            }
        }
        //paths.add(newPath);
        ImageIcon newIcon = new ImageIcon(newPath);
        int ratio = 100/newIcon.getIconHeight();
        int newWidth = ratio*newIcon.getIconWidth();
        Image img = newIcon.getImage().getScaledInstance(80,100,Image.SCALE_DEFAULT);
        Icon finalIcon = new ImageIcon(img);
        icons.add(finalIcon);
        names.add(newName);
        capacity.add(newCapacity);
    }*/

    public static void initialArray(){
        BottlesInfo.setLists();
        names = BottlesInfo.getNames();
        capacity = BottlesInfo.getCapacities();
        System.out.println(names);
        System.out.println(BottlesInfo.getNames());
    }

    public static ArrayList<Icon> getIcons(){
        return icons;
    }

    public static ArrayList<String> getNames(){
        return names;
    }

    public static ArrayList<String> getCapacity(){
        return capacity;
    }

    public static void insertRecord(String name, String capacity){
        BottlesInfo.insertLists(String.valueOf(names.size()),name,capacity);
    }
}
