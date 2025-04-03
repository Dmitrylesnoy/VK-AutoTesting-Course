import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class RedirectToForgetPage {
    private WebDriver driver;
    JavascriptExecutor js;
    
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void shouldNavigateToVkProjects() {
        driver.get("https://ok.ru/");
        driver.manage().window().setSize(new Dimension(974, 1032));
        driver.findElement(By.linkText("Не получается войти?")).click();
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div/ul/li[9]/a")).click();

        // Ожидаем, пока URL обновится
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ok.ru/help";

        assertEquals(expectedUrl, currentUrl,
                "После нажатия кнопок должен произойти переход на " + expectedUrl);
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}