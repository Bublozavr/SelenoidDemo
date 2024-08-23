package emag.pages.MainPage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import common.CommonPage;
import common.Log;



import static com.codeborne.selenide.Selenide.*;


public class MainPage extends CommonPage {



    String searchField = "//*[@id='searchboxTrigger']";
    String addToFroggerProduct = "//*[@data-name='#productName#']//*[@type='submit']";
    String pampersSizeSection = "//*[@data-name='Размер']";
    String pampersSize = "//*[@class='filter-body js-scrollable']//*[@data-name='#size#']";
    String popUpHeader = "//*[@class='modal-header']";
    String popUpAddedProduct = "//*[@class='modal-body modal-content-extra-padding pad-sep-xs hidden-xs']//*[@class='row table-layout']//*[@class='small']";
    String popUpAddedProductPrice = "//*[@class='table-layout row block-sm-layout']//p[@class='product-new-price']";

    public void checkPageIsOpened(){
        String actualUrl = WebDriverRunner.url();
        actualUrl.equals("https://www.emag.bg");
    }

    public void searchFor(String text) {
        Selenide.$x(searchField).val(text).pressEnter();
    }

    public void addProductToFrogger(String productName){
        selenide.click(addToFroggerProduct.replace("#productName#", productName));
    }

    public void selectSize(String size){
        selenide.scrollIntoView(pampersSizeSection);
        selenide.click(pampersSize.replace("#size#", size));
    }

    public void checkTitle(){
        title().equals("Pampers Premium Care 3 - \uD83D\uDD0E Търсене в - eMAG.bg");
    }

    public void checkPopUp(){
        checkPopUpHeader("Продуктът е добавен в количката");
        checkPopUpProductName("Пелени Pampers Premium Care XXL Размер 3, 6-10 кг, 200 бр");
        checkPopUpPrice();
    }

    private void checkPopUpHeader(String header){
        selenide.shouldHave(popUpHeader, header);
    }

    private void checkPopUpProductName(String productName){
        selenide.shouldHave(popUpAddedProduct, productName);
    }

    private void checkPopUpPrice(){
        Double price = Double.parseDouble(Selenide.$x(popUpAddedProductPrice).getText().
                replaceAll("[А-я]", "").
                replaceAll("\\.", "").
                replaceAll(",", "."));

        if(price > 82.00){
            Log.warning("Discount is absent. Price is " + price);
        }


    }


}