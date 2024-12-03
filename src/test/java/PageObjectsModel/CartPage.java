package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(className = "inventory_item_name")
    private WebElement articleInCart;

    @FindBy(id= "checkout")
    private WebElement checkoutButton ;

    WebDriver driver ;
    public CartPage(WebDriver driver) {
        this.driver  = driver ;
        PageFactory.initElements(driver, this);
    }

    public String getPageCartUrl() {
        return driver.getCurrentUrl();
    }

    public String getArticleInCarte() {
        return articleInCart.getText();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
