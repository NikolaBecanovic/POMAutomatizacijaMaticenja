import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LegalAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By mesto = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
    private By popUp = By.xpath("(//span[@class='ng-star-inserted'])[2]");
    private By street = By.xpath("(//input[contains(@id, 'mat-input-')])[4]");
    private By buildingNo = By.xpath("(//input[contains(@id, 'mat-input-')])[5]");
    private By completeButton = By.xpath("//span[text()='Complete']");

    public LegalAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterMesto(String mestoValue) {
        WebElement mestoField = wait.until(ExpectedConditions.elementToBeClickable(mesto));
        mestoField.sendKeys(mestoValue);
    }

    public void clickPopUp() {
        WebElement popUpElement = wait.until(ExpectedConditions.elementToBeClickable(popUp));
        popUpElement.click();

    }

    public void enterStreet(String streetValue) {
        WebElement streetField = wait.until(ExpectedConditions.elementToBeClickable(street));
        streetField.sendKeys(streetValue);

    }

    public void enterBuildingNo(String buildingNoValue) {
        WebElement buildingNoField = wait.until(ExpectedConditions.elementToBeClickable(buildingNo));
        buildingNoField.sendKeys(buildingNoValue);

    }

    public void clickCompleteButton() throws InterruptedException {
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();

    }




}
