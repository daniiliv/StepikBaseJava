// Don't edit this file

import org.testng.annotations.Test;

/**
 * @author meanmail
 */
public class MainTest {
    @Test(timeOut = 5000)
    public void mainTest() throws Throwable {
        TestUtils.assertOutputEquals("It's alive! It's alive!");
    }
}