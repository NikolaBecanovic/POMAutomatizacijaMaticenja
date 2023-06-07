import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RepresentativePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By zastupnik = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
    private By zastupnikTestKlik = By.xpath("//span[text()=' Julijan Test ']");
    private By startDate = By.xpath("(//input[contains(@id, 'mat-input-')])[4]");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");

    public RepresentativePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterRepresentative(String representativeName, String startDateValue) throws InterruptedException {
        Thread.sleep(15000);
        wait.until(ExpectedConditions.presenceOfElementLocated(zastupnik));
        driver.findElement(zastupnik).click();
        driver.findElement(zastupnik).sendKeys(representativeName);
        wait.until(ExpectedConditions.elementToBeClickable(zastupnikTestKlik));
        driver.findElement(zastupnikTestKlik).click();
        wait.until(ExpectedConditions.elementToBeClickable(startDate));
        driver.findElement(startDate).click();
        driver.findElement(startDate).sendKeys(startDateValue);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println("Korisnik je uspješno unio zastupnika pravnog lica.");
    }

}
