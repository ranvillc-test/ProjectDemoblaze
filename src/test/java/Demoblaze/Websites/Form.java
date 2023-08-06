package Demoblaze.Websites;

import lombok.Getter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Form {
    @FindBy(how = How.XPATH, using = "//h5[@class='modal-title' and @id= 'orderModalLabel' ]")
    private WebElement pedidolbl;
    @FindBy(how = How.ID, using = "name")
    private WebElement input_name;
    @FindBy(how = How.ID, using = "country")
    private WebElement input_country;
    @FindBy(how = How.ID, using = "city")
    private WebElement input_city;
    @FindBy(how = How.ID, using = "card")
    private WebElement input_card;
    @FindBy(how = How.ID, using = "month")
    private WebElement input_month;
    @FindBy(how = How.ID, using = "year")
    private WebElement input_year;
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Purchase')]")
    private WebElement purchasebtn;

    private WebDriver driver;
    @Getter
    private static final String NAME ="Rafael";
    private static final String COUNTRY ="Colombia";
    private static final String CITY ="Santa Marta";
    private static final String CARD ="1234567890123456";
    private static final String MONTH ="Julio";
    private static final String YEAR ="2023";
    public Form(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public Form() {
    }
    @Step
    public void GestionarFormulario() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(pedidolbl));

        wait.until(ExpectedConditions.elementToBeClickable(input_name));
        input_name.click();
        input_name.sendKeys(NAME);

        wait.until(ExpectedConditions.elementToBeClickable(input_country));
        input_country.click();
        input_country.sendKeys(COUNTRY);

        wait.until(ExpectedConditions.elementToBeClickable(input_city));
        input_city.click();
        input_city.sendKeys(CITY);

        wait.until(ExpectedConditions.elementToBeClickable(input_card));
        input_card.click();
        input_card.sendKeys(CARD);

        wait.until(ExpectedConditions.elementToBeClickable(input_month));
        input_month.click();
        input_month.sendKeys(MONTH);

        wait.until(ExpectedConditions.elementToBeClickable(input_year));
        input_year.click();
        input_year.sendKeys(YEAR);

    }

    @Step
    public void SeleccionarPurchase() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(purchasebtn));
        purchasebtn.click();
    }

    public String getName(){
        return NAME;
    }
    public String getCard(){
        return CARD;
    }

}
