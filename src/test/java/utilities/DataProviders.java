package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException{

        String path = ".\\testData\\LoginData.xlsx";
        ExcelUtility xlUtility = new ExcelUtility(path);

        int totalRows = xlUtility.getRowCount();
        int totalCol = xlUtility.getCellCount();
        String [][]data = new String[totalRows][totalCol];

        for (int i = 1; i<= totalRows; i++){
            for (int j = 0; j<totalCol; j++){
                data[i-1][j] = xlUtility.cellData(i, j);
            }
        }

        return data;
    }

//    public static void main(String[] args) throws IOException {
//        DataProviders dp = new DataProviders();
//        String[][] newData = dp.getData();
//
//        for (int i = 0; i<= newData.length; i++){
//            for (int j = 0; j < newData[i].length; j++){
//                System.out.println(newData[i][j]);
//            }
//            System.out.println("-----------------------------------");
//        }
//
//    }
}
