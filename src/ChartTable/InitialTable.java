package ChartTable;

import java.util.Arrays;

public class InitialTable {
    private static String[][] data = {{"id", "name"}};

    public InitialTable() {
    }

    public static void addToTable(String newName){
        Integer rowNumber = data.length;
        String idString = rowNumber.toString();
        String[][] newRow = {{idString, newName}};

        String[][] result = Arrays.copyOf(data, data.length + newRow.length);
        System.arraycopy(newRow, 0, result, data.length, newRow.length);

        data = result;
    }

    public static String[][] getData() {
        return data;
    }
}
