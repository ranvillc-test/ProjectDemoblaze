package Demoblaze.Websites;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductDetail {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-success btn-lg']")
    private WebElement addcart;

    public ProductDetail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @Step
    public void AgregarProductoCarro() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(addcart));
        addcart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
