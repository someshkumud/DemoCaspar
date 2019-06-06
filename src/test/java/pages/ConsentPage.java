package pages;
/**
 * This class is created to define page objects of Consent page in Caspar application
 * Bugs: NA
 *
 * @author       Somesh Kumud
 * @version      1.0
 * @since       06/06/2019
 */


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;

public class ConsentPage extends BaseUtil {

    /**
     * Page factory constructor function will instantiate objects
     * @param driver
     */
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

    /**
     * navigateToReleaseOfMedicalInformationPage method will -
     * 1. navigate To Release Of Medical Information Page
     */
    public void navigateToReleaseOfMedicalInformationPage() {
        clickOn(linkReleaseOfMedicalInformation);
    }

    /**
     * navigateToTermsAndConditionsPage method will -
     * 1. navigate To Terms And Conditions Page
     */
    public void navigateToTermsAndConditionsPage() {
        clickOn(linkTermsAndConditions);
    }

    /**
     * verifyVisibilityOfMedicalInformationPageAndClosePage method will -
     * 1. verify Visibility Of Medical Information Page And Close Page
     * 2. Close Page
     */
    public void verifyVisibilityOfMedicalInformationPageAndClosePage() {
        try {
            Assert.assertTrue(pageTitleReleaseOfMedicalInformation.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
        clickOn(linkClose);
    }

    /**
     * verifyVisibilityOfTermsAndConditionsPageAndClosePage method will -
     * 1. verify Visibility Of Terms And Conditions Page
     * 2. Close Page
     */
    public void verifyVisibilityOfTermsAndConditionsPageAndClosePage() {
        try {
            Assert.assertTrue(pageTitleTermsAndConditions.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
        clickOn(linkClose);
    }
}
