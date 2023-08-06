package Demoblaze.Websites;
import Demoblaze.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    private WebDriver driver;
    private Questions questions;
    private static String total;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-success']")
    private WebElement pedido;
    @FindBy(how = How.ID, using = "totalp")
    private WebElement totallbl;

    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.questions= new Questions(driver);
    }

    public Cart() {

    }

    @Step
    public void ValidarCarrito() throws InterruptedException {
        this.questions.Assertproductos();
    }

    @Step
    public void RealizarPedido() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(pedido));
        pedido.click();
        wait.until(ExpectedConditions.elementToBeClickable(totallbl));
        this.total = totallbl.getText();
    }

    public String getTotal(){
        return total;
    }

}
