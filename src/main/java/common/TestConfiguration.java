package common;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestConfiguration {
    public static void setUpSelenide() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "127.0";
        Configuration.browserSize = "1920x1080";
    }
}
