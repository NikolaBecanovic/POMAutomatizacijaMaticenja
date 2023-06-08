import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BeneficialOwnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By BeneficialOwner = By.xpath("//input[contains(@id, 'mat-input-')]");
    private By BeneficialOwnerZastupnikTest = By.xpath("//span[text()=' Test Test ']");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");

    public BeneficialOwnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterBeneficialOwner(String beneficialOwnerName) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(BeneficialOwner));
        driver.findElement(BeneficialOwner).sendKeys(beneficialOwnerName);
        wait.until(ExpectedConditions.elementToBeClickable(BeneficialOwnerZastupnikTest));
        driver.findElement(BeneficialOwnerZastupnikTest).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println("Korisnik je uspješno unio stvarnog vlasnika pravnog lica.");
        Thread.sleep(5000);
    }




}
