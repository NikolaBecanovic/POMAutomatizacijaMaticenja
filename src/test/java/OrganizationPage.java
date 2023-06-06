import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cif = By.xpath("(//span[@class='mat-list-item-content'])[8]");
    private By newOrganization = By.xpath("//span[text()='New organization']");
    private By enrollmentLevel = By.xpath("(//div[contains(@id, 'mat-select-value-')])[2]");
    private By klijent = By.xpath("//span[text()=' Klijent']");
    private By startProcess = By.xpath("//span[text()='Start process']");

    public OrganizationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void startOrganizationEnrollment() {
        wait.until(ExpectedConditions.elementToBeClickable(cif));
        driver.findElement(cif).click();
        wait.until(ExpectedConditions.elementToBeClickable(newOrganization));
        driver.findElement(newOrganization).click();
        wait.until(ExpectedConditions.elementToBeClickable(enrollmentLevel));
        driver.findElement(enrollmentLevel).click();
        wait.until(ExpectedConditions.elementToBeClickable(klijent));
        driver.findElement(klijent).click();
        driver.findElement(startProcess).click();
    }

}
