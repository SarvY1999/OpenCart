package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    public FileInputStream fi;
    public XSSFWorkbook wb;
    public XSSFSheet sh;
    public XSSFRow row;
    public XSSFCell cell;
    String path;

    public ExcelUtility(String path) throws FileNotFoundException {
        this.path = path;
    }



    public int getRowCount() throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet("Sheet1");

        // getting rows
        int rows = sh.getLastRowNum();
        wb.close();
        fi.close();
        return rows;
    }

    public int getCellCount() throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet("Sheet1");

        // getting columns
        row = sh.getRow(0);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public String cellData(int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet("Sheet1");
        row = sh.getRow(rowNum);
        cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell);
        }catch (Exception e){
            data="";
        }
        return data;
    }
}
