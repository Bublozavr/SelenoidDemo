package Tests;

import common.CommonTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SecondTest extends CommonTest {

    @Test
    public void testPampersSize(){
        //open Emag web site
        open("https://www.emag.bg/homepage");

        //Check Emag website is opened
        mainPage.checkPageIsOpened();

        //Search 'Pampers Premium Care 3'
        mainPage.searchFor("Pampers Premium Care 3");

        //Check title
        mainPage.checkTitle();

        //Select 3 size
        mainPage.selectSize("3");

        //Add Product to Frogger
        mainPage.addProductToFrogger("Пелени Pampers Premium Care XXL Размер 3, 6-10 кг, 200 бр");

        //Check pop-up
        mainPage.checkPopUp();
    }
}
