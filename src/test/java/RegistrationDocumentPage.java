import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationDocumentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By registrationDocumentNumber = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
    private By issuingDate = By.xpath("(//input[contains(@id, 'mat-input-')])[4]");
    private By completeButton = By.xpath("//span[text()='Complete']");

    public RegistrationDocumentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterRegistrationDocumentNumber(String number) {
        WebElement registrationDocumentNumberField = wait.until(ExpectedConditions.elementToBeClickable(registrationDocumentNumber));
        registrationDocumentNumberField.sendKeys(number);

    }

    public void enterIssuingDate(String date) {
        WebElement issuingDateField = wait.until(ExpectedConditions.elementToBeClickable(issuingDate));
        issuingDateField.sendKeys(date);
    }

    public void clickCompleteButton() throws Exception {
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();

    }



}
