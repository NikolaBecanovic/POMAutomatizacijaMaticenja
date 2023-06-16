import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerSegmentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By customerSegment = By.xpath("(//input[contains(@id, 'mat-input-')])[1]");
    private By noSegment = By.xpath("//span[text()='No segment']");
    private By completeButton = By.xpath("//span[text()='Complete']");

    public CustomerSegmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    }

    public void enterCustomerSegment(String segment) {

        WebElement customerSegmentField = wait.until(ExpectedConditions.elementToBeClickable(customerSegment));
        customerSegmentField.sendKeys(segment);
    }

    public void selectNoSegment() {

        WebElement noSegmentElement = wait.until(ExpectedConditions.elementToBeClickable(noSegment));
        noSegmentElement.click();
    }

    public void clickCompleteButton() throws InterruptedException {

        WebElement completeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completeButton));
        completeButtonElement.click();
    }


}
