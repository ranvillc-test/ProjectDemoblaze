package Demoblaze.Steps;


import Demoblaze.Websites.Cart;
import Demoblaze.Websites.Form;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Questions {
	Actor user = Actor.named("User");
	private WebDriver driver;
	private Form form;
	private Cart cart;
	private String total;
	private String name;
	private String card;
	private static final String STATUS_PURCHASE = "Thank you for your purchase!";

	public Questions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.cart= new Cart();
		this.form = new Form();
	}

	@FindBy(how = How.XPATH, using = "//tr[@class='success']")
	private List<WebElement> productos;
	@FindBy(how = How.XPATH, using = "//tr[@class='success']")
	private WebElement producto;
	@FindBy(how = How.XPATH, using = "*//div[10]/h2")
	private WebElement status;
	@FindBy(how = How.XPATH, using = "//p[@class='lead text-muted ']")
	private WebElement text;

	@Step
	public void Assertproductos()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(producto));
		int num_producto = 2;
		int num_product_cart = 0;

		for (WebElement producto: productos) {
			num_product_cart+= 1;
		}

		user.attemptsTo(Ensure.that(num_product_cart).isEqualTo(num_producto));
	}

	@Step
	public void Assertpurchase()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(status));

		String[] sTexto = (text.getText()).split("\n");
		for(String i:sTexto){
			if (i.contains("Amount: ")){
				total = i.replace("Amount: ", "").replace(" USD", "");
			}else if(i.contains("Name: ")){
				name = i.replace("Name: ", "");
			}else if(i.contains("Card Number: ")){
				card = i.replace("Card Number: ", "");
			}
		}

		user.attemptsTo(Ensure.that(status.getText()).isEqualTo(STATUS_PURCHASE));
		user.attemptsTo(Ensure.that(this.cart.getTotal()).isEqualTo(total));
		user.attemptsTo(Ensure.that(this.form.getCard()).isEqualTo(card));
		user.attemptsTo(Ensure.that(this.form.getName()).isEqualTo(name));

	}

}