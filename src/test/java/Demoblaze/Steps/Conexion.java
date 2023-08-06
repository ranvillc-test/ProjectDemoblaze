package Demoblaze.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeOptions;


public class Conexion {

	private WebDriver driver;

	@Step
	public WebDriver abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this.driver = driver;
	}
}
