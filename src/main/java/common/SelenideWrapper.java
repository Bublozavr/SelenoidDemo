package common;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;

public class SelenideWrapper {

    public void click(String xpathLocator){
        Log.info("Click to locator " + xpathLocator);
        Selenide.$x(xpathLocator).click();
    }

    public void scrollIntoView(String xpathLocator){
        Log.info("Scroll into view " + xpathLocator);
        Selenide.$x(xpathLocator).scrollIntoView(true);
    }

    public void shouldHave(String xpathLocator, String expected) {
        Log.info("Check name is " + expected);
        Selenide.$x(xpathLocator).shouldHave(text(expected));
    }

}
