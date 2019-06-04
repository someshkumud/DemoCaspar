package Util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static Util.BaseUtil.sys_default_prop;
import static Util.DriverSetup.*;

public class Hook {


    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser");

    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        closeDriver();
    }
}
