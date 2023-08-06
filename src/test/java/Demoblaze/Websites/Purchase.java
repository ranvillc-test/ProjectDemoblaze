package Demoblaze.Websites;

import Demoblaze.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Purchase {
    private WebDriver driver;
    private Questions questions;

    public Purchase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.questions= new Questions(driver);
    }
    @Step
    public void ValidarCompra() {
        this.questions.Assertpurchase();
        driver.quit();
    }
}
