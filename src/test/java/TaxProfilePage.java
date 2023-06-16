import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaxProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By taxNumber = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
    private By completeButton = By.xpath("//span[text()='Complete']");

    public TaxProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterTaxNumber(String number) {
        WebElement taxNumberField = wait.until(ExpectedConditions.elementToBeClickable(taxNumber));
        taxNumberField.sendKeys(number);
    }

    public void clickCompleteButton() throws Exception {
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();

    }




}
