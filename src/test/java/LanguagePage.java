import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguagePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By promenaJezika = By.xpath("//div[@class='mat-select-arrow ng-tns-c236-13']");
    private By promenaJezikaSrpski = By.xpath("//span[text()=' Srpski ']");

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void changeLanguageToSerbian() {
        wait.until(ExpectedConditions.presenceOfElementLocated(promenaJezika));
        driver.findElement(promenaJezika).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(promenaJezikaSrpski));
        driver.findElement(promenaJezikaSrpski).click();
    }
}
