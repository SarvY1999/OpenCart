package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    public FileInputStream fi;
    public XSSFWorkbook wb;
    public XSSFSheet sh;
    String path;

    public ExcelUtility(String path) throws FileNotFoundException {
        this.path = path;
    }



    public void getRowCount() throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);



    }



}
