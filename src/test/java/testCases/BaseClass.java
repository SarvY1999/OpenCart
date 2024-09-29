package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    WebDriver driver;
    Logger logger;
    Properties p;     // need to import properties class

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws IOException {

        // Reading file
        FileReader file = new FileReader(".src//test//resources//config.properties"); // reading file
        p = new Properties();  // Creating object of Properties
        p.load(file);  // Loading file

        logger = LogManager.getLogger(this.getClass());
        switch(browser){
            case "Chrome": driver = new ChromeDriver(); break;
            case "Edge" : driver = new EdgeDriver(); break;
            default:
                System.out.println("Please Provide a browser name");
            return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(p.getProperty("Url"));   // getting property from Config file
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    // random string generation
    public String randomStringGeneration(){
        String randString = RandomStringUtils.randomAlphabetic(5);
        return randString;
    }
}
