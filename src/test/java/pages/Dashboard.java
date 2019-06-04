package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;

import static util.DriverSetup.driver;

public class Dashboard extends BaseUtil {

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@uisref='core.new-patient']")
    private WebElement buttonAddPatient;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-7']")
    private WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-8']")
    private WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-1']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBDateArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-2']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBMonthArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-3']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectDOBYearArrow;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-0']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectGender;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-11']")
    private WebElement txtHeight;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-12']")
    private WebElement txtWeight;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-13']")
    private WebElement txtBMI;

    @FindBy(how = How.XPATH, using = "//textarea[@id='mat-input-14']")
    private WebElement txtTherapyGoal;

    @FindBy(how = How.XPATH, using = "//textarea[@id='mat-input-15']")
    private WebElement txtTherapistRecommendations;

    @FindBy(how = How.XPATH, using = "//textarea[@id='mat-input-16']")
    private WebElement txtOther;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-9']")
    private WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-10']")
    private WebElement txtPrimaryPhoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-17']")
    private WebElement txtStreet;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-18']")
    private WebElement txtStreetNumber;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-19']")
    private WebElement txtZip;

    @FindBy(how = How.XPATH, using = "//input[@id='mat-input-20']")
    private WebElement txtCity;

    @FindBy(how = How.XPATH, using = "//mat-select[@id='mat-select-4']//div[contains(@class, 'mat-select-arrow-wrapper')]")
    private WebElement selectCountry;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement buttonSave;

    @FindBy(how = How.XPATH, using = "//span[@class='ng-star-inserted']")
    private WebElement linkMenuLogout;

    @FindBy(how = How.XPATH, using = "//button[@class='mat-menu-item ng-star-inserted']")
    private WebElement linkLogout;


    public void addPatient() {
        clickOn(buttonAddPatient);
        enterPersonalInformation();
        enterTherapyDetails();
        enterContactInformation();
        clickOn(buttonSave);
    }

    public void getCredentials() {
        String tempUserNname = driver.findElement(By.xpath("//mat-dialog-container[@id='mat-dialog-0']//div[contains(@class, 'd-flex')]/div[3]/div[2]")).getText();
        String tempPassword = driver.findElement(By.xpath("//mat-dialog-container[@id='mat-dialog-0']//div[contains(@class, 'd-flex')]/div[4]/div[2]")).getText();
        sys_default_prop.put("userName", tempUserNname);
        sys_default_prop.put("password", tempPassword);
        System.out.println(tempUserNname);
        System.out.println(tempPassword);
        driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
    }


    public void logOut() {
        clickOn(linkMenuLogout);
        clickOn(linkLogout);
    }

    private void enterPersonalInformation() {
        enterValueInTextBox(txtFirstName, sys_default_prop.get("firstName"));
        enterValueInTextBox(txtLastName, sys_default_prop.get("lastName"));
        selectDoB();
        selectDropdownByVisibleText(selectGender, sys_default_prop.get("gender"));
        enterValueInTextBox(txtHeight, sys_default_prop.get("height"));
        enterValueInTextBox(txtWeight, sys_default_prop.get("weight"));
        enterValueInTextBox(txtBMI, sys_default_prop.get("bmi"));
    }


    private void enterTherapyDetails() {
        enterValueInTextBox(txtTherapyGoal, sys_default_prop.get("therapyGoal"));
        enterValueInTextBox(txtTherapistRecommendations, sys_default_prop.get("therapistRecommendations"));
        enterValueInTextBox(txtOther, sys_default_prop.get("other"));
    }

    private void enterContactInformation() {
        enterValueInTextBox(txtEmail, sys_default_prop.get("email"));
        enterValueInTextBox(txtPrimaryPhoneNumber, sys_default_prop.get("primaryPhoneNumber"));
        enterValueInTextBox(txtStreet, sys_default_prop.get("street"));
        enterValueInTextBox(txtStreetNumber, sys_default_prop.get("streetNumber"));
        enterValueInTextBox(txtZip, sys_default_prop.get("zip"));
        enterValueInTextBox(txtCity, sys_default_prop.get("city"));
        txtCity.sendKeys(Keys.PAGE_DOWN);
        Wait(1);
        selectDropdownByVisibleText(selectCountry, sys_default_prop.get("country"));
    }

    private void selectDoB() {
        String[] arDate = sys_default_prop.get("dateOfBirth").split(" ");
        int dd = Integer.parseInt(arDate[0]);
        String mm = arDate[1];
        int yyyy = Integer.parseInt(arDate[2]);
        selectDropdownByVisibleText(selectDOBDateArrow, String.valueOf(dd));
        selectDropdownByVisibleText(selectDOBMonthArrow, mm);
        selectDropdownByVisibleText(selectDOBYearArrow, String.valueOf(yyyy));
    }
}
