Feature: Pruebas funcional de compra en Demozable

	@tag1
	Scenario: Finalizacion de compra con dos productos
		Given usuario abre el navegador
		When  Usuario agrega productos al carrito
		When  Usuario visualiza el carrito
		And   Usuario Completa el formulario
		Then  validar compra finalizada
