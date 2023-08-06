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

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Samsung galaxy s6')]")
    private WebElement samsung;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Nokia lumia 1520')]")
    private WebElement nokia;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Home')]")
    private WebElement home;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Cart')]")
    private WebElement cart;

    @Step
    public void SeleccionarProductoSamsung() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(samsung));
        samsung.click();
    }

    @Step
    public void SeleccionarInicio() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(home));
        home.click();
    }
    @Step
    public void SeleccionarProductoNokia() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nokia));
        nokia.click();
    }

    @Step
    public void SeleccionarCarrito() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        cart.click();
    }

}
