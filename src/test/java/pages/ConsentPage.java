package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.BaseUtil;

import static util.DriverSetup.driver;

public class ConsentPage extends BaseUtil {

    public ConsentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[text()='release of medical information.']")
    private WebElement linkReleaseOfMedicalInformation;

    @FindBy(how = How.XPATH, using = "//span[text()='terms and conditions']")
    private WebElement linkTermsAndConditions;

    @FindBy(how = How.XPATH, using = "//app-contract-preview[@title='Release of medical information']")
    private WebElement pageTitleReleaseOfMedicalInformation;

    @FindBy(how = How.XPATH, using = "//app-contract-preview[@title='Terms and Conditions']")
    private WebElement pageTitleTermsAndConditions;

    @FindBy(how = How.XPATH, using = "//mat-icon[text()='close']")
    private WebElement linkClose;


    public void navigateToReleaseOfMedicalInformationPage() {
        clickOn(linkReleaseOfMedicalInformation);
    }

    public void navigateToTermsAndConditionsPage() {
        clickOn(linkTermsAndConditions);
    }

    public void verifyVisibilityOfMedicalInformationPageAndClosePage() {
        try {
            Assert.assertTrue(pageTitleReleaseOfMedicalInformation.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
        clickOn(linkClose);
    }


    public void verifyVisibilityOfTermsAndConditionsPageAndClosePage() {
        try {
            Assert.assertTrue(pageTitleTermsAndConditions.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
        clickOn(linkClose);
    }
}
