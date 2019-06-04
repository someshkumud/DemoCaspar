package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.ConsentPage;
import pages.Dashboard;
import pages.LoginPage;
import util.BaseUtil;

import static util.DriverSetup.*;

/**
 * Created by Somesh.
 */
public class LoginStep extends BaseUtil {


    @Given("^default properties loded into hashmap$")
    public void defaualltPropertiesLodedIntoHashmap() throws Throwable {
        load_default_props();
    }

    @When("^user log into Casper$")
    public void userLogIntoCasper() {
        LoginPage login = new LoginPage(driver);
        login.loginToCasper();
    }

    @And("^user adds a Patient$")
    public void userAddsAPatient() {

    }

    @And("^user adds a Patient and set credentials in default properties$")
    public void userAddsAPatientAndSetCredentialsInDefaultProperties() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.addPatient();
        dashboard.getCredentials();
    }

    @And("^user log out from Caspar$")
    public void userLogOutFromCaspar() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.logOut();
        Wait(2);
    }

    @And("^Launch browser and navigate to Caspar$")
    public void launchBrowserAndNavigateToCaspar() {
        createDriver();
        driver.get(sys_default_prop.get("url"));
    }

    @And("^close browser$")
    public void closeBrowser() {
        closeDriver();
    }

    @And("^navigate to release of medical information page$")
    public void navigateToReleaseOfMedicalInformationPage() {
        ConsentPage consentPage=new ConsentPage(driver);
consentPage.navigateToReleaseOfMedicalInformationPage();
    }

    @And("^verify visibility of medical information page and close it$")
    public void verifyVisibilityOfMedicalInformationPageAndCloseIt() {
        ConsentPage consentPage=new ConsentPage(driver);
        consentPage.verifyVisibilityOfMedicalInformationPageAndClosePage();
    }

    @And("^navigate to terms and conditions page$")
    public void navigateToTermsAndConditionsPage() {
        ConsentPage consentPage=new ConsentPage(driver);
        consentPage.navigateToTermsAndConditionsPage();
    }

    @And("^verify visibility of terms and conditions page and close it$")
    public void verifyVisibilityOfTermsAndConditionsPageAndCloseIt() {
        ConsentPage consentPage=new ConsentPage(driver);
        consentPage.verifyVisibilityOfTermsAndConditionsPageAndClosePage();
    }
}
