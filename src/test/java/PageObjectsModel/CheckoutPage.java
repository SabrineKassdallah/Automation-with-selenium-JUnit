package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput ;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput ;

    @FindBy(id = "continue")
     private WebElement continueButton ;



    WebDriver driver ;
    public CheckoutPage(WebDriver driver) {
        this.driver  = driver ;
        PageFactory.initElements(driver, this);
    }

    public String getPageCheckOutUrl() {
        return driver.getCurrentUrl();
    }

    public void fillInformations() {
        firstNameInput.click();
        firstNameInput.sendKeys("sabrine");

        lastNameInput.click();
        lastNameInput.sendKeys("kassdallah");

        postalCodeInput.click();
        postalCodeInput.sendKeys("4054");



    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
