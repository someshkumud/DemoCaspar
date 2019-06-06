package pages;

/**
 * This class is created to define page objects of Login page in Caspar application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 06/06/2019
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;

public class LoginPage extends BaseUtil {
    /**
     * Page factory constructor function will instantiate objects
     * @param driver
     */

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='login']")
    private WebElement txtLoginEmailOrCasparID;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='password']")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//span[text()='Login']")
    private WebElement btnLogin;


    /**
     * loginToCasper method will be called after navigating to Caspar application and it will-
     * 1. Enter login credentials on login page and click on login button
     */

    public void loginToCasper() {
        enterValueInTextBox(txtLoginEmailOrCasparID, defaultProperties.get("userName"));
        enterValueInTextBox(txtPassword, defaultProperties.get("password"));
        clickOn(btnLogin);
    }
}
