import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GeneralInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By idNumber = By.xpath("//*[@id='mat-input-0']");
    private By commercialName = By.xpath("//*[@id='mat-input-1']");
    private By legalName = By.xpath("//*[@id='mat-input-2']");
    private By establishmentDate = By.xpath("//*[@id='mat-input-3']");
    private By dugmeZatvori = By.xpath("//span[text()='Zatvori']");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");

    public GeneralInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterGeneralInformation (String idNumberValue, String commercialNameValue, String legalNameValue, String establishmentDateValue) {
        wait.until(ExpectedConditions.elementToBeClickable(idNumber));
        driver.findElement(idNumber).click();
        driver.findElement(idNumber).sendKeys(idNumberValue);
        driver.findElement(commercialName).click();
        driver.findElement(commercialName).sendKeys(commercialNameValue);
        driver.findElement(legalName).click();
        driver.findElement(legalName).sendKeys(legalNameValue);
        driver.findElement(establishmentDate).click();
        driver.findElement(establishmentDate).sendKeys(establishmentDateValue);
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeZatvori));
        driver.findElement(dugmeZatvori).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
    }




}
