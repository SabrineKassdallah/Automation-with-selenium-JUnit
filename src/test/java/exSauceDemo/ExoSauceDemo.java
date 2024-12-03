package exSauceDemo;

import PageObjectsModel.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class ExoSauceDemo {

    // initialisation notre driver
    static ChromeDriver driver ;
    @BeforeAll
    public static void  setUp() {
        WebDriverManager.chromedriver().setup();

        // supprimer l'affichage de la fenetre se sélection le moteur de recherche dans google chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(options) ;
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void t001_logInUser() {
        LoginPage log = new LoginPage(driver);
        ProductPage objProductPage = new ProductPage(driver);
        log.logInAsUser();

        // une fois qu'on s'est logué , on va vérifier que notre product page contient bien inventory.html
        // pour cela on utilise une methode d'assertion depuis jUnit

        Assertions.assertTrue(objProductPage.getPageProductUrl().contains("inventory.html"), "Error: Article page is not reached");

    }

    @Test
    public void t002_Filter() {
        ProductPage objProductPage = new ProductPage(driver);
        objProductPage.setFilterLoHi();
        Assertions.assertTrue(objProductPage.isListInOrder(), "Error: list not ordered correctly");

    }

    @Test
    public void t003_addProductToCart() {
        ProductPage objProductPage = new ProductPage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objProductPage.clickAddToCartBikeLight();
        Assertions.assertTrue(objHeaderPage.isArticleAddedInCart(),"Error: cart does not contains 1 element");

    }

    @Test
    public void t004_accessToCart() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        CartPage objCartPage = new CartPage(driver);
        objHeaderPage.clickOnCart();
        Assertions.assertTrue(objCartPage.getPageCartUrl().contains("cart.html"), "Error: Carte page is not reached");
        Assertions.assertEquals(objCartPage.getArticleInCarte(),"Sauce Labs Bike Light","Error: Article in carte is not the one expected");
        objCartPage.clickCheckout();
    }

    @Test
    public void t005_checkout() {
        CheckoutPage objCheckout = new CheckoutPage(driver);
        Assertions.assertTrue(objCheckout.getPageCheckOutUrl().contains("checkout-step-one.html"), "Error: Wrong URL");
        objCheckout.fillInformations();
        objCheckout.clickContinueButton();

    }


    @Test
    public void t006_confirmationInformation() {
        CheckoutPart2Page objCheckout2 = new CheckoutPart2Page(driver);
        Assertions.assertTrue(objCheckout2.getPageCheckOut2Url().contains("checkout-step-two.html"), "Error: Wrong URL");
        Assertions.assertTrue(objCheckout2.getArticleTitle().contains("Bike Light") && objCheckout2.getArticlePrice().contains("9.99") && objCheckout2.getArticleTotalPrice().contains("10.79"));
        objCheckout2.clickToFinish();

    }

    @Test
    public void t007_confirmationPayment() {
        CheckoutCompletePage objCheckoutCompeted = new CheckoutCompletePage(driver);
        Assertions.assertTrue(objCheckoutCompeted.getPageCheckOutCompleteUrl().contains("checkout-complete.html"),"Error: Wrong URL");
        Assertions.assertTrue(objCheckoutCompeted.getTitleConfirmation().equals("Thank you for your order!"));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }



}