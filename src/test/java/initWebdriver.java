import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initWebdriver {
    @Test

    public void t001_initWebdriver() {

        WebDriverManager.chromedriver().clearDriverCache().setup();

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");




    }
}
