import PageObjectsModel.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Form {
    static ChromeDriver driver;
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();

    }

    @Test
    public void t001_fillInForm(){

        MainPage objMainPage = new MainPage(driver);


        // Username
        objMainPage.fillUsername("hello");

        // Password
        objMainPage.fillPassword("Udemy");

        // TextArea
        objMainPage.fillInTextArea("ceci est un test");

        // Upload Image
        objMainPage.upload().sendKeys("/home/sabrine/IdeaProjects/Selenuim_project/target/images/img.jpeg");

        // Checkbox items

        objMainPage.clickCheckBox("cb2");
        objMainPage.clickCheckBox("cb3");


        // Radio buttons
        objMainPage.clickRadio();

        // Multi Field
        objMainPage.clickMultiField("ms1");
        objMainPage.clickMultiField("ms2");
        objMainPage.clickMultiField("ms4");


        // Drop Down
        objMainPage.clickDropDown();

        // button

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button  = driver.findElement(By.cssSelector("input[type='submit']"));
        js.executeScript("arguments[0].click();", button);

    }


    @Test
    public void t002_CheckFormFields(){

        // vérification des champs

        WebElement chkUsername = driver.findElement(By.id("_valueusername"));
        WebElement chkPwd = driver.findElement(By.id("_valuepassword"));
        WebElement chkCmt = driver.findElement(By.id("_valuecomments"));
        WebElement chkFile = driver.findElement(By.id("_valuefilename"));
        WebElement chkChkBox = driver.findElement(By.id("_valuecheckboxes0"));
        WebElement chkRadio = driver.findElement(By.id("_valueradioval"));
        WebElement chkMultiSelect1 = driver.findElement(By.id("_valuemultipleselect0"));
        WebElement chkMultiSelect2 = driver.findElement(By.id("_valuemultipleselect1"));
        WebElement chkDropDown = driver.findElement(By.id("_valuedropdown"));

        assertEquals(chkUsername.getText(), "hello");
        assertEquals(chkPwd.getText(), "Udemy");
        assertEquals(chkCmt.getText(), "ceci est un test");
        assertEquals(chkFile.getText(), "img.jpeg");
        assertEquals(chkChkBox.getText(), "cb2");
        assertEquals(chkRadio.getText(), "rd1");
        assertEquals(chkMultiSelect1.getText(), "ms1");
        assertEquals(chkMultiSelect2.getText(), "ms2");
        assertEquals(chkDropDown.getText(), "dd6");



    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
