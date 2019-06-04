package pages;

import util.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseUtil {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='login']")
    private WebElement txtLoginEmailOrCasparID;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='password']")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//span[text()='Login']")
    private WebElement btnLogin;


    public void loginToCasper() {
        enterValueInTextBox(txtLoginEmailOrCasparID, sys_default_prop.get("userName"));
        enterValueInTextBox(txtPassword, sys_default_prop.get("password"));
        Wait(5);
        clickOn(btnLogin);
    }
}
