package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPart2Page {

    @FindBy(className = "inventory_item_name")
    private WebElement articleTitle ;

    @FindBy(className = "inventory_item_price")
    private WebElement articlePrice ;


    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    private WebElement articleTotalPrice ;

    //@FindBy(id = "finish")
    @FindBy(xpath = "//button[contains(text(), 'Finish')]")
    private WebElement finishBtn ;


    WebDriver driver ;
    public CheckoutPart2Page(WebDriver driver) {
        this.driver  = driver ;
        PageFactory.initElements(driver, this);
    }

    public String getPageCheckOut2Url() {
        return driver.getCurrentUrl();
    }

    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public String getArticlePrice() {
        return articlePrice.getText();
    }

    public String getArticleTotalPrice() {
        return articleTotalPrice.getText();
    }

    public void clickToFinish() {
        finishBtn.click();
    }

}
