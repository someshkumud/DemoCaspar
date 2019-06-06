package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;


/**
 * This class is created to define page objects of Dashboard page in Caspar application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 06/06/2019
 */

public class Dashboard extends BaseUtil {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Add Patient']")
    private WebElement buttonAddPatient;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='first_name']")
    private WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='last_name']")
    private WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-1']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBDateArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-2']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBMonthArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-3']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBYearArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-0']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectGender;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='height']")
    private WebElement txtHeight;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='weight']")
    private WebElement txtWeight;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='bmi']")
    private WebElement txtBMI;

    @FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='therapy_goal']")
    private WebElement txtTherapyGoal;

    @FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='therapist_recommendations']")
    private WebElement txtTherapistRecommendations;

    @FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='other_information']")
    private WebElement txtOther;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='email']")
    private WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='phone']")
    private WebElement txtPrimaryPhoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='street']")
    private WebElement txtStreet;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='street_number']")
    private WebElement txtStreetNumber;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='zip']")
    private WebElement txtZip;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='city']")
    private WebElement txtCity;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-4']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectCountry;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement buttonSave;

    @FindBy(how = How.XPATH, using = "//span[@class='ng-star-inserted']")
    private WebElement linkMenuLogout;

    @FindBy(how = How.XPATH, using = "//button[text()='Sign out']")
    private WebElement linkLogout;

    @FindBy(how = How.XPATH, using = "//mat-dialog-container[@id='mat-dialog-0']//div[contains(@class, 'd-flex')]/div[3]/div[2]")
    private WebElement labelCasparID;


    @FindBy(how = How.XPATH, using = "//mat-dialog-container[@id='mat-dialog-0']//div[contains(@class, 'd-flex')]/div[4]/div[2]")
    private WebElement labelTemporaryPassword;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Close dialog']")
    private WebElement buttonCloseDialog;

    /**
     * addPatient method will -
     * 1. Open add patient module from dashboard
     * 2. Enter default mandatory details of patient, unless other details not entered from Feature file/set in default properties file
     * 3. Clicks on save button
     */
    public void addPatient() {
        clickOn(buttonAddPatient);
        enterPersonalInformation();
        enterTherapyDetails();
        enterContactInformation();
        clickOn(buttonSave);
    }

    /**
     * getCredentials method will be called after adding patient and this will-
     * 1. capture credentials of newly created patients and update into hashmap
     * 2. Close the dialog box
     */
    public void getCredentials() {
        defaultProperties.put("userName", labelCasparID.getText());
        defaultProperties.put("password", labelTemporaryPassword.getText());
        clickOn(buttonCloseDialog);
    }

    /**
     * logOut method will -
     * 1. Logout admin(IXE0865) user from dashboard
     */
    public void logOut() {
        clickOn(linkMenuLogout);
        clickOn(linkLogout);
    }


    /**
     * enterPersonalInformation method is created to support AddPatient method.
     * This will enter personal information on add patient page
     */
    private void enterPersonalInformation() {
        enterValueInTextBox(txtFirstName, defaultProperties.get("firstName"));
        enterValueInTextBox(txtLastName, defaultProperties.get("lastName"));
        selectDoB();
        selectDropdownByVisibleText(selectGender, defaultProperties.get("gender"));
        enterValueInTextBox(txtHeight, defaultProperties.get("height"));
        enterValueInTextBox(txtWeight, defaultProperties.get("weight"));
        enterValueInTextBox(txtBMI, defaultProperties.get("bmi"));
    }

    /**
     * enterTherapyDetails method is created to support AddPatient method.
     * This will enter Therapy Details on add patient page
     */
    private void enterTherapyDetails() {
        enterValueInTextBox(txtTherapyGoal, defaultProperties.get("therapyGoal"));
        enterValueInTextBox(txtTherapistRecommendations, defaultProperties.get("therapistRecommendations"));
        enterValueInTextBox(txtOther, defaultProperties.get("other"));
    }

    /**
     * enterContactInformation method is created to support AddPatient method.
     * This will enter Contact Information on add patient page
     */
    private void enterContactInformation() {
        enterValueInTextBox(txtEmail, defaultProperties.get("email"));
        enterValueInTextBox(txtPrimaryPhoneNumber, defaultProperties.get("primaryPhoneNumber"));
        enterValueInTextBox(txtStreet, defaultProperties.get("street"));
        enterValueInTextBox(txtStreetNumber, defaultProperties.get("streetNumber"));
        enterValueInTextBox(txtZip, defaultProperties.get("zip"));
        enterValueInTextBox(txtCity, defaultProperties.get("city"));
        txtCity.sendKeys(Keys.PAGE_DOWN);
        Wait(1);
        selectDropdownByVisibleText(selectCountry, defaultProperties.get("country"));
    }

    /**
     * selectDoB method is created to support addPersonalInformation method.
     * This will select DoB on add patient page
     */
    private void selectDoB() {
        String[] arDate = defaultProperties.get("dateOfBirth").split(" ");
        int dd = Integer.parseInt(arDate[0]);
        String mm = arDate[1];
        int yyyy = Integer.parseInt(arDate[2]);
        selectDropdownByVisibleText(selectDOBDateArrow, String.valueOf(dd));
        selectDropdownByVisibleText(selectDOBMonthArrow, mm);
        selectDropdownByVisibleText(selectDOBYearArrow, String.valueOf(yyyy));
    }
}
