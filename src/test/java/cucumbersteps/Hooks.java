package cucumbersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void testStart(){
        System.out.println("Test is started");
    }

    @After
    public void testEnd(){
        System.out.println("Test is end");
    }
}