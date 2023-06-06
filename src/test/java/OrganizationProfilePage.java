import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By ownershipKind = By.xpath("(//div[contains(@id, 'mat-select-value-')])[2]");
    private By privateEntity = By.xpath("//span[text()=' Identifies an that is owned by private entity(es)']");
    private By legalStructure = By.xpath("(//div[contains(@id, 'mat-select-value-')])[3]");
    private By doo = By.xpath("//span[text()=' Društvo sa ograničenom odgovornošću']");
    private By delatnost = By.xpath("//input[contains(@id, 'mat-input-')]");
    private By bezDelatnosti = By.xpath("//span[text()='0000 – 00000–Bez oznake delatnosti']");
    private By organizationSize = By.xpath("(//div[contains(@id, 'mat-select-value-')])[4]");
    private By notClassified = By.xpath("//span[text()=' Not classified']");
    private By microOrganization = By.xpath("//span[text()=' Micro organization']");
    private By residentalStatus = By.xpath("(//div[contains(@id, 'mat-select-value-')])[5]");
    private By notClassifiedResidental = By.xpath("//span[text()=' Not classified']");
    private By dugmeComplete = By.xpath("//span[text()='Complete']");

    public OrganizationProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void selectOwnershipKindPrivateEntity() {
        WebElement ownershipKindElement = wait.until(ExpectedConditions.elementToBeClickable(ownershipKind));
        ownershipKindElement.click();
        WebElement privateEntityElement = wait.until(ExpectedConditions.elementToBeClickable(privateEntity));
        privateEntityElement.click();
    }

    public void selectLegalStructureDOO() {
        WebElement legalStructureElement = wait.until(ExpectedConditions.elementToBeClickable(legalStructure));
        legalStructureElement.click();
        WebElement dooElement = wait.until(ExpectedConditions.elementToBeClickable(doo));
        dooElement.click();
    }

    public void enterDelatnost(String delatnostValue) {
        WebElement delatnostElement = wait.until(ExpectedConditions.elementToBeClickable(delatnost));
        delatnostElement.click();
        delatnostElement.sendKeys(delatnostValue);
    }

    public void selectBezDelatnosti() {
        WebElement bezDelatnostiElement = wait.until(ExpectedConditions.elementToBeClickable(bezDelatnosti));
        bezDelatnostiElement.click();
    }

    public void selectOrganizationSizeMicro() {
        WebElement organizationSizeElement = wait.until(ExpectedConditions.elementToBeClickable(organizationSize));
        organizationSizeElement.click();
        WebElement microOrganizationElement = wait.until(ExpectedConditions.elementToBeClickable(microOrganization));
        microOrganizationElement.click();
    }

    public void selectResidentalStatusNotClassified() {
        WebElement residentalStatusElement = wait.until(ExpectedConditions.elementToBeClickable(residentalStatus));
        residentalStatusElement.click();
        WebElement notClassifiedResidentalElement = wait.until(ExpectedConditions.elementToBeClickable(notClassifiedResidental));
        notClassifiedResidentalElement.click();
    }

    public void clickCompleteButton() {
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(dugmeComplete));
        completeButtonElement.click();
    }


}
