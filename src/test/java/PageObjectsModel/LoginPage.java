
// cette classe est une page d'object, elle été initialiser en tant que page factory

// La Page Factory est une extension du modèle d’objet de page (POM) qui fournit une manière plus élégante et plus efficace de gérer les éléments de la page Web.
// Elle utilise des annotations pour initialiser les éléments Web de manière dynamique.

// @FindBy sont utilisées pour localiser les éléments Web


package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   // Page Factory
    // username
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    // password
    @FindBy(id = "password")
    private WebElement passwordInput;

    // button Login
    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    WebDriver driver ;
    // constructeur
    public LoginPage(WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver, this); // initialiser page factory
    }

    // page d'object

    public void logInAsUser() {
        usernameInput.click();
        usernameInput.sendKeys("standard_user");

        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        loginButton.click();

    }
}
