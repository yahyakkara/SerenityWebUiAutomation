package cucumbersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;

public class Hooks {
    @Before
    public void before() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }

    @After
    public void testEnd(){
        System.out.println("Test is end");
    }
}