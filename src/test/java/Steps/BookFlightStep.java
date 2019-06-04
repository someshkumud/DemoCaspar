package Steps;

import Util.BaseUtil;
import Pages.Dashboard;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import static Util.DriverSetup.driver;

public class BookFlightStep extends BaseUtil{

    private  BaseUtil base;

    public BookFlightStep(BaseUtil base) {
        this.base = base;
        //
    }



    @And("^I select trip type \"([^\"]*)\"$")
    public void iSelectTripType(String tripType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Dashboard page=new Dashboard(driver);
//        page.selectTripType(tripType);

    }
//
//    @And("^I select number of passengers as \"([^\"]*)\"$")
//    public void iSelectNumberOfPassengersAs(String passCount) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.selectNumberOfPass(passCount);
//        throw new PendingException();
//    }
//
//    @And("^I select departing from \"([^\"]*)\"$")
//    public void iSelectDepartingFrom(String depFrom) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.selectDepartFrom(depFrom);
//        throw new PendingException();
//    }
//
//    @And("^I select departing on \"([^\"]*)\"$")
//    public void iSelectDepartingOn(String depOn) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.selectDepartOn(depOn);
//        throw new PendingException();
//    }
//
//    @And("^I select arriving in \"([^\"]*)\"$")
//    public void iSelectArrivingIn(String arriveIn) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.selectArriveTo(arriveIn);
//        throw new PendingException();
//    }
//
//    @And("^I select service class as \"([^\"]*)\"$")
//    public void iSelectServiceClassAs(String serClass) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.selectServiceClass(serClass);
//        throw new PendingException();
//    }
//
//    @And("^I click Continue button$")
//    public void iClickContinueButton() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Dashboard page=new Dashboard(base.driver);
//        page.clickContinue();
//        throw new PendingException();
//    }
}
