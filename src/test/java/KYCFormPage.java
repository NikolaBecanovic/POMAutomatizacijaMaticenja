import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KYCFormPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private By pitanjeBR3 = By.xpath("//*[@id='dinarsOrForeignCurrencies']");
    private By pitanjeBR4 = By.xpath("//*[@id='countryWhereMainPartOfOperationsIsConducted']");
    private By pitanjeBR2 = By.xpath("(//div[contains(@id, 'mat-select-value-')])[3]");
    private By pitanjeBR1 = By.xpath("(//div[contains(@id, 'mat-select-value-')])[2]");
    private By pitanjeBR6 = By.xpath("(//mat-select[contains(@id, 'mat-select-')])[4]");
    private By pitanjeBR1odgovor = By.xpath("//span[text()=' Current account']");
    private By pitanjeBR2odgovor = By.xpath("//span[text()=' Loan to be granted']");
    private By pitanjeBR6odg = By.xpath("//span[text()=' Securities']");
    private By dugmeComplete = By.xpath("//button[contains(@class, 'mat-button mat-button-base mat-primary')]");
    private By KycTask = By.xpath("//span[text()=' TESTFIRMA / KYC  - Dodeljeno je Vama ']");


    public KYCFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        action = new Actions(driver);

    }
    public void clickKycTask() {
        WebElement kycTaskElement = wait.until(ExpectedConditions.elementToBeClickable(KycTask));
        kycTaskElement.click();
    }


    public void enterPitanjeBR3(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(pitanjeBR3));
        driver.findElement(pitanjeBR3).click();
        driver.findElement(pitanjeBR3).sendKeys(value);
    }

    public void enterPitanjeBR4(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(pitanjeBR4));
        driver.findElement(pitanjeBR4).click();
        driver.findElement(pitanjeBR4).sendKeys(value);
    }

    public void selectPitanjeBR2() {
        wait.until(ExpectedConditions.elementToBeClickable(pitanjeBR2));
        driver.findElement(pitanjeBR2).click();
        driver.findElement(pitanjeBR2odgovor).click();
    }

    public void selectPitanjeBR1() {
        wait.until(ExpectedConditions.elementToBeClickable(pitanjeBR1));
        driver.findElement(pitanjeBR1).click();
        driver.findElement(pitanjeBR1odgovor).click();
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void selectPitanjeBR6() {
        action.sendKeys(Keys.ESCAPE).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pitanjeBR6));
        driver.findElement(pitanjeBR6).click();
        driver.findElement(pitanjeBR6odg).click();
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void clickCompleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println("Korisnik je uspješno ispunio KYC formu.");
    }



}
