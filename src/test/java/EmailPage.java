import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By email = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
    private By completeButton = By.xpath("//span[text()='Complete']");


    public EmailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterEmail(String emailAddress) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(email));
        emailField.sendKeys(emailAddress);
    }

    public void clickCompleteButton() throws InterruptedException{
        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();

    }






}
