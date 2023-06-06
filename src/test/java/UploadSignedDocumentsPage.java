import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadSignedDocumentsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By UploadSignedDocument = By.xpath("//span[text()=' TESTFIRMA / KYC / Upload signed documents  - Dodeljeno je Vama ']");
    private By KycForm = By.xpath("//span[text()=' • Mandatory']");
    private By DragAndDrop = By.xpath("(//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color'])[9]");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");
    private Robot robot;

    public UploadSignedDocumentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickUploadSignedDocument() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadSignedDocument));
        driver.findElement(UploadSignedDocument).click();
    }

    public void clickKycForm() {
        wait.until(ExpectedConditions.elementToBeClickable(KycForm));
        driver.findElement(KycForm).click();
    }

    public void clickDragAndDrop() {
        wait.until(ExpectedConditions.elementToBeClickable(DragAndDrop));
        driver.findElement(DragAndDrop).click();
    }

    public void uploadDocument(String filePath) throws AWTException, InterruptedException {
        // Otvori dijalog za odabir datoteke

        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(1000);
        robot = new Robot();

        // Simulira pritisak na dugmad CTRL+V za zalijepiti putanju do datoteke

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.setAutoDelay(1000);

        // Simulira pritisak na Enter  za potvrdu odabira datoteke

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println("Korisnik je uspješno uradio upload KYC forme.");
    }


}
