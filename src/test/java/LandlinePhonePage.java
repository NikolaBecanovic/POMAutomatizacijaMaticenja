import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandlinePhonePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By areaCode = By.xpath("(//input[contains(@id, 'mat-input-')])[2]");
    private By number = By.xpath("(//input[contains(@id, 'mat-input-')])[3]");
    private By completeButton = By.xpath("//span[text()='Complete']");

    public LandlinePhonePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterAreaCode(String code) {

        WebElement areaCodeField = wait.until(ExpectedConditions.elementToBeClickable(areaCode));
        areaCodeField.sendKeys(code);
    }

    public void enterNumber(String phoneNumber) {
        WebElement numberField = wait.until(ExpectedConditions.elementToBeClickable(number));
        numberField.sendKeys(phoneNumber);
    }

    public void clickCompleteButton() throws InterruptedException {
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();

    }







}
