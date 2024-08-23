package common;

import emag.pages.MainPage.MainPage;
import org.testng.annotations.BeforeClass;

public class CommonTest {

    @BeforeClass
    public void setUp() {
        TestConfiguration.setUpSelenide();
    }

    public MainPage mainPage = new MainPage();

}
