package PageObjectsModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver ;

    }

    private WebElement username() {
        return driver.findElement(By.cssSelector("input[name='username']"));
    }

    private WebElement password() {
        return driver.findElement(By.cssSelector("input[name='password']"));
    }

    private WebElement textArea() {
        return driver.findElement(By.cssSelector("textarea[name='comments']"));
    }

    public WebElement upload() {
        return driver.findElement(By.xpath("//input[@name='filename']"));
    }

    private WebElement checkbox(String checkbox) {
        return driver.findElement(By.cssSelector(String.format("input[value='%s']", checkbox)));
    }

    private WebElement radio() {
        return driver.findElement(By.xpath("//input[@value='rd1']"));
    }

    private WebElement field(String field) {
        return driver.findElement(By.cssSelector(String.format("option[value='%s']", field)));
        // %s -> c à d n'importe qu'elle string
    }

    private WebElement dropdown() {
        return driver.findElement(By.cssSelector("option[value='dd6']"));
    }

    public void fillUsername(String username) {
        username().click();
        username().sendKeys(username);

    }

    public void fillPassword(String password) {
        password().click();
        password().sendKeys(password);

    }

    public void fillInTextArea(String text) {
        textArea().click();
        textArea().clear();
        textArea().sendKeys(text);
    }


    public void clickMultiField(String field) {
        field(field).click();
    }

    public void clickCheckBox(String checkbox) {

        checkbox(checkbox).click();
    }

    public void clickRadio() {
        radio().click();
    }

    public void clickDropDown() {
        dropdown().click();
    }






}
