package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Util.BaseUtil.sys_default_prop;

public class DriverSetup {
    public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

    public static WebDriver driver;

    public static void createDriver() {
        switch (sys_default_prop.get("browser").toUpperCase()) {
            case "CHROME":
                System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

//            case "IE":
//                System.setProperty(IE_DRIVER_PROPERTY,"C:\\Users\\somesh12339\\Downloads\\iedriver.exe");
//                driver = new InternetExplorerDriver();
//                break;
//
//            default:
//                System.setProperty(CHROME_DRIVER_PROPERTY,"C:\\Users\\somesh12339\\Downloads\\chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(sys_default_prop.get("implicitWait")), TimeUnit.SECONDS);
    }


    public static void closeDriver() {
        try {
//            driver.close();
            driver.quit();
        } catch (RuntimeException ex) {
            throw new RuntimeException("Fail to close driver : " + ex.getMessage());
        }
    }
}
