package AutomationWEBSITE;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public static void beforeAll(){
        BaseTest.setupDriver();
        BaseTest.openUrl("https://cms-jip.folkatech.com");
    }

    @After
    public void afterScenario() {
        try {
            Thread.sleep(10_000); // delay 10 detik sebelum browser ditutup
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        BaseTest.stopDriver();
    }

//    @After
//    public void afterScenario() {
//        BaseTest.stopDriver();
//    }
}
