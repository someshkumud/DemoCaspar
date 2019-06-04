package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static Util.DriverSetup.driver;

/**
 * Created to operate on properties file
 */
public class BaseUtil {
//    public static WebDriver driver;
    public static HashMap<String, String> sys_default_prop = new HashMap<String, String>();

    public static void load_default_props() {
        Properties load_props = new Properties();
        get_default_props(load_props, sys_default_prop);
        process_properties(load_props, sys_default_prop);

    }

    private static void process_properties(Properties load_props, HashMap<String, String> default_prop) {
        default_prop.put("browser", load_props.getProperty("browser"));
        default_prop.put("implicitWait", load_props.getProperty("implicitWait"));
        default_prop.put("url", load_props.getProperty("url"));

//        *****************Login
        default_prop.put("userName", load_props.getProperty("userName"));
        default_prop.put("password", load_props.getProperty("password"));

//        ******************Add Patient
        default_prop.put("firstName", load_props.getProperty("firstName"));
        default_prop.put("lastName", load_props.getProperty("lastName"));
        default_prop.put("dateOfBirth", load_props.getProperty("dateOfBirth"));
        default_prop.put("gender", load_props.getProperty("gender"));
        default_prop.put("height", load_props.getProperty("height"));
        default_prop.put("weight", load_props.getProperty("weight"));
        default_prop.put("bmi", load_props.getProperty("bmi"));
        default_prop.put("therapyGoal", load_props.getProperty("therapyGoal"));
        default_prop.put("therapistRecommendations", load_props.getProperty("therapistRecommendations"));
        default_prop.put("other", load_props.getProperty("other"));
        default_prop.put("email", load_props.getProperty("email"));
        default_prop.put("primaryPhoneNumber", load_props.getProperty("primaryPhoneNumber"));
        default_prop.put("street", load_props.getProperty("street"));
        default_prop.put("streetNumber", load_props.getProperty("streetNumber"));
        default_prop.put("zip", load_props.getProperty("zip"));
        default_prop.put("city", load_props.getProperty("city"));
        default_prop.put("country", load_props.getProperty("country"));
    }


    public static void get_default_props(Properties load_props, HashMap<String, String> sys_default_prop) {
        FileInputStream input = null;
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\config\\default.properties");
            input = new FileInputStream(file);
            load_props.load(input);
            //load_props.load(BaseUtil.class.getResourceAsStream("default.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void Wait(int timeInSec){
        try {
            Thread.sleep(timeInSec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterValueInTextBox(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }


    public void clickOn(WebElement webElement) {
        webElement.click();
    }

    public void selectDropdownByVisibleText(WebElement webElement, String value){
        clickOn(webElement);
        driver.findElement(By.xpath("//span[text()='"+value+"']")).click();
    }


}

