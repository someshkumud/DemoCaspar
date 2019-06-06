package util;

/**
 * This class is created to define utility/supporting functions
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 06/06/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static util.DriverSetup.driver;

public class BaseUtil {

    public static HashMap<String, String> defaultProperties = new HashMap<String, String>();

    /**
     * loadDefaultProperties method will load properties from default.properties file into hash map
     */
    public static void loadDefaultProperties() {
        Properties properties = new Properties();
        readDefaultProperties(properties);
        processProperties(properties, defaultProperties);

    }

    /**
     * processProperties method created to support loadDefaultProperties, this will read properties from properties object and put into hash map
     */
    private static void processProperties(Properties properties, HashMap<String, String> default_properties) {
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            default_properties.put(key, value);
        }
    }

    /**
     * readDefaultProperties method created to support loadDefaultProperties, this will read properties from default.properties file and put into properties object
     */
    public static void readDefaultProperties(Properties properties) {
        FileInputStream input = null;
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\config\\default.properties");
            input = new FileInputStream(file);
            properties.load(input);
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


    /**
     * Wait method will allow wait till specified time (in seconds)
     */
    public static void Wait(int timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * enterValueInTextBox method will enter Value In TextBox
     *
     * @param webElement object of text box
     */
    public void enterValueInTextBox(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    /**
     * clickOn method will click on links/button
     *
     * @param webElement object of link/button
     */
    public void clickOn(WebElement webElement) {
        webElement.click();
    }

    /**
     * selectDropdownByVisibleText method will select Dropdown value By Visible Text
     *
     * @param webElement object of dropdown
     */
    public void selectDropdownByVisibleText(WebElement webElement, String value) {
        clickOn(webElement);
        driver.findElement(By.xpath("//span[text()='" + value + "']")).click();
    }


}

