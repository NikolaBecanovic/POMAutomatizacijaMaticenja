import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OwnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addOwner = By.xpath("//span[text()='Add owner']");
    private By vlasnici = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
    private By procenatVlasnistva = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");
    private By vlasnikTestKlik = By.xpath("//span[text()=' Julijan Test ']");

    public OwnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void addOwner(String ownerName, String percentage) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(addOwner));
        driver.findElement(addOwner).click();
        wait.until(ExpectedConditions.elementToBeClickable(vlasnici));
        driver.findElement(vlasnici).click();
        driver.findElement(vlasnici).sendKeys(ownerName);
        wait.until(ExpectedConditions.elementToBeClickable(vlasnikTestKlik));
        driver.findElement(vlasnikTestKlik).click();
        wait.until(ExpectedConditions.elementToBeClickable(procenatVlasnistva));
        driver.findElement(procenatVlasnistva).click();
        driver.findElement(procenatVlasnistva).sendKeys(percentage);
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();

        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println("Korisnik je uspješno unio vlasnika pravnog lica.");
    }



}
