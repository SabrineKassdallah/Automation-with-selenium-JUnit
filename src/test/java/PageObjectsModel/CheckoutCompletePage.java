package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    @FindBy(tagName = "h2")
    private WebElement titleConfirmation ;


    WebDriver driver ;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver  = driver ;
        PageFactory.initElements(driver, this);
    }


    public String getPageCheckOutCompleteUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitleConfirmation() {
        return titleConfirmation.getText();
    }


}
