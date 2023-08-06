package Demoblaze.Definitions;

import Demoblaze.Websites.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Demoblaze.Steps.*;
import java.io.IOException;


public class DefinitionsSteps {
	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private Home home;
	private Purchase purchase;
	private ProductDetail productDetail;
	private Cart cart;
	private Form form;

	@Given("^usuario abre el navegador$")
	public void usuario_abre_el_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}

	@When("^Usuario agrega productos al carrito$")
	public void Usuario_agrega_dos_productos_al_carrito() throws InterruptedException {
		this.home = new Home(driver);
		this.productDetail = new ProductDetail(driver);
		this.home.SeleccionarProductoSamsung();
		this.productDetail.AgregarProductoCarro();
		this.home.SeleccionarInicio();
		this.home.SeleccionarProductoNokia();
		this.productDetail.AgregarProductoCarro();
		System.out.println(" ");
	}

	@When("^Usuario visualiza el carrito$")
	public void Usuario_visualiza_el_carrito() throws InterruptedException {
		this.home = new Home(driver);
		this.cart = new Cart(driver);
		this.home.SeleccionarCarrito();
		this.cart.ValidarCarrito();
	}

	@When("^Usuario Completa el formulario$")
	public void Usuario_completa_el_formulario() throws InterruptedException {
		this.cart = new Cart(driver);
		this.form = new Form(driver);
		this.cart.RealizarPedido();
		this.form.GestionarFormulario();
		this.form.SeleccionarPurchase();
	}

	@Then("validar compra finalizada")
	public void validar_compra_finalizada() throws IOException {
		this.purchase = new Purchase(driver);
		this.purchase.ValidarCompra();
	}

}
