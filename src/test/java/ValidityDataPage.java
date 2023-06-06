import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.OptionsWithArguments;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class ValidityDataPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By validityDataTask = By.xpath("//span[@class='mat-tooltip-trigger activity-name ng-star-inserted']");
    private By validitityDataUpload = By.xpath("//span[text()=' • Confirmation of the validity of the data of the legal entity']");
    private By dragAndDropValidity = By.xpath("//span[text()='Drag and drop file or click to upload']");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");
    private Robot robot;
    public ValidityDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickValidityDataTask() {

        wait.until(ExpectedConditions.presenceOfElementLocated(validityDataTask));
        driver.findElement(validityDataTask).click();
    }

    public void clickCompleteButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(dugmeComplete));
        driver.findElement(dugmeComplete).click();
    }

    public void clickValidityDataUpload() {
        wait.until(ExpectedConditions.elementToBeClickable(validitityDataUpload));
        driver.findElement(validitityDataUpload).click();
    }

    public void clickDragAndDropValidity() {
        wait.until(ExpectedConditions.elementToBeClickable(dragAndDropValidity));
        driver.findElement(dragAndDropValidity).click();
    }

    public void uploadValidityData(String filePath) throws InterruptedException {
        // Otvori dijalog za odabir datoteke
        StringSelection validityDataSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(validityDataSelection, null);
        robot.setAutoDelay(1000);

        // Simulira pritisak na dugmad CTRL+V za zalijepiti putanju do datoteke

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.setAutoDelay(1000);

        // Simuliraj pritisak na tipku Enter za potvrdu odabira datoteke

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        driver.findElement(dugmeComplete).click();
        System.out.println(" Klijent je uspješno umatičen. ");
    }
}
