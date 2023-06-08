import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UploadDocumentsTask {

    private WebDriver driver;
    private WebDriverWait wait;

    private By UploadSignedDocument = By.xpath("//span[text()=' TESTFIRMA / KYC / Upload signed documents  - Dodeljeno je Vama ']");

    public UploadDocumentsTask(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void openUploadSignedDocuments() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadSignedDocument));
        driver.findElement(UploadSignedDocument).click();
    }
}
