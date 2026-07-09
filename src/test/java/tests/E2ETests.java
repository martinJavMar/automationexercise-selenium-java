package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import model.UserData;


public class E2ETests extends BaseTest {
	
	
	
  @Test (enabled =false)
  public void realizarPedidoRegistrandoseEnCheckoutTest() {
	  
	  assertTrue(
				homePage.carruselHome(),"El logo no es visible");
	  
	  logger.info("Agregando productos desde pagina de inicio");
	 
	  homePage.scrollProducts();
	  homePage.addToCartContinueShopping(1);
	  homePage.addToCartContinueShopping(2);
	  
	  logger.info("llendo al carrito");
	  
	  homePage.goToCart();
	  
	  assertTrue(cartPage.textoCartVisible(), "No es visible el texto Shopping cart");
	  
	  cartPage.goToCheckout();
	  cartPage.clickToRegisterLogin();
	
	  String email = "user" + System.currentTimeMillis() + "@test.com";
	  
	  loginPage.registerNewUser("Carlos",email);
	  
	  logger.info("llenando formulario ");
	  
	  UserData user = new UserData();

	  user.setTitle("Mr");

	  user.setName("Juan");

	  user.setEmail(email);

	  user.setPassword("123456");

	  user.setDay("10");

	  user.setMonth("May");

	  user.setYear("1995");

	  user.setNewsletter(true);

	  user.setOffers(false);

	  user.setFirstName("Juan");

	  user.setLastName("Pérez");

	  user.setCompany("OpenAI");

	  user.setAddress1("Calle Mayor");

	  user.setAddress2("");

	  user.setCountry("Canada");

	  user.setState("Ontario");

	  user.setCity("Toronto");

	  user.setZipCode("12345");

	  user.setMobileNumber("666123456");
	  
	  singUpPage.fillForm(user);
	  
	  singUpPage.clickCreateAccount();
	  
	  assertTrue(accountCreatedPage.isPresentAccountCreated(),"No esta presente el texto");
	  
	  accountCreatedPage.continuar();
	  
	  logger.info("validando icicio de sesión");
	  
	  assertTrue(loginPage.getLoggedInText().contains("Logged in as"),"No se encontro el mensaje ");
	  
	  homePage.goToCart();
	  
	  logger.info("Haciendo checkout");
	  
	  cartPage.goToCheckout();
	  
	  checkoutPage.comment("comentario de prueba");
	  
	  checkoutPage.goToPayment();
	  
	  logger.info("Ingresando datos de pago");
	  
	  assertTrue(paymentPage.validatePage(), "No es visible el texto");
	  
	  paymentPage.payment("juan", "12345", "098", "09", "2024");
	  
	  assertEquals(paymentDonePage.getConfirmationMessage(),"Congratulations! Your order has been confirmed!");
	  
	  paymentDonePage.clickContinue();
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");

	  logger.info("Eliminando cuenta");
	  
	  homePage.deleteAccount();
	  
	  deleteAccountPage.waitForAccountDeletedMessage();
	  
	  deleteAccountPage.clickConinue();
	  
	  logger.info("Validando que se elimino la cuenta y no este logueada");
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");
	  
	  assertFalse(homePage.isLogoutVisible(), "El boton Logout todavía es visible");

	   
  }
  
 @Test (enabled =false)
 public void placeOrderRegisterBeforeCheckout() {
	 
	 assertTrue(
				homePage.carruselHome(),"El logo no es visible");
	 
	 homePage.irLogin();
	 
	 String email = "user" + System.currentTimeMillis() + "@test.com";
	  
	  loginPage.registerNewUser("Carlos",email);
	  
	  logger.info("llenando formulario ");
	  
	  UserData user = new UserData();

	  user.setTitle("Mr");

	  user.setName("Pedro");

	  user.setEmail(email);

	  user.setPassword("123456");

	  user.setDay("10");

	  user.setMonth("May");

	  user.setYear("1995");

	  user.setNewsletter(true);

	  user.setOffers(false);

	  user.setFirstName("Pedro");

	  user.setLastName("Pérez");

	  user.setCompany("OpenAI");

	  user.setAddress1("Calle Mayor");

	  user.setAddress2("");

	  user.setCountry("Canada");

	  user.setState("Ontario");

	  user.setCity("Toronto");

	  user.setZipCode("12345");

	  user.setMobileNumber("666123456");
	  
	  singUpPage.fillForm(user);
	  
	  singUpPage.clickCreateAccount();
	  
	  assertTrue(accountCreatedPage.isPresentAccountCreated(),"No esta presente el texto");
	  
	  accountCreatedPage.continuar();
	  
      logger.info("validando icicio de sesión");
	  
	  assertTrue(loginPage.getLoggedInText().contains("Logged in as"),"No se encontro el mensaje ");
	 
	  logger.info("Agregando productos desde pagina de inicio");
		 
	  homePage.scrollProducts();
	  
	  homePage.addToCartContinueShopping(1);
	  
	  homePage.addToCartContinueShopping(2);
	  
	  logger.info("navegando a carrito");
	  
	  homePage.goToCart();
	  
	  assertTrue(cartPage.textoCartVisible(),"El texto no es visible");
	  
	  assertEquals(cartPage.obtenerTextoLabelCart(),"Shopping Cart","el texto no coincide");
	  
	  cartPage.goToCheckout();
	  
      checkoutPage.comment("comentario de prueba");
	  
	  checkoutPage.goToPayment();
	  
      logger.info("Ingresando datos de pago");
	  
	  assertTrue(paymentPage.validatePage(), "No es visible el texto");
	  
	  paymentPage.payment("juan", "12345", "098", "09", "2024");
	  
	  assertEquals(paymentDonePage.getConfirmationMessage(),"Congratulations! Your order has been confirmed!");
	  
	  paymentDonePage.clickContinue();
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");

	  logger.info("Eliminando cuenta");
	  
	  homePage.deleteAccount();
	  
	  deleteAccountPage.waitForAccountDeletedMessage();
	  
	  deleteAccountPage.clickConinue();
	  
	  logger.info("Validando que se elimino la cuenta y no este logueada");
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");
	  
	  assertFalse(homePage.isLogoutVisible(), "El boton Logout todavía es visible");

	  
	  
 }
 
 @Test  (enabled= false)
 public void placeOrderLogInBeforeCheckout() {
	 
	 assertTrue(homePage.carruselHome(),"El logo no es visible");
	 
	 homePage.irLogin();
	 
	 loginPage.login("correo0107@yopmail.com", "12345");
	 
	 logger.info("validando icicio de sesión");
	  
	 assertTrue(loginPage.getLoggedInText().contains("Logged in as"),"No se encontro el mensaje ");
	 
	 logger.info("Agregando productos desde pagina de inicio");
	 
	  homePage.scrollProducts();
	  
	  homePage.addToCartContinueShopping(1);
	  
	  homePage.addToCartContinueShopping(2);
	  
	  logger.info("navegando a carrito");
	  
	  homePage.goToCart();
	  
      assertTrue(cartPage.textoCartVisible(),"El texto no es visible");
	  
	  assertEquals(cartPage.obtenerTextoLabelCart(),"Shopping Cart","el texto no coincide");
	  
	  cartPage.goToCheckout();
	  
      checkoutPage.comment("comentario de prueba");
	  
	  checkoutPage.goToPayment();
	  
      logger.info("Ingresando datos de pago");
	  
	  assertTrue(paymentPage.validatePage(), "No es visible el texto");
	  
	  paymentPage.payment("juan", "12345", "098", "09", "2024");
	  
      assertEquals(paymentDonePage.getConfirmationMessage(),"Congratulations! Your order has been confirmed!");
	  
	  paymentDonePage.clickContinue();
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");

	  logger.info("Eliminando cuenta");
	  
	  homePage.deleteAccount();
	  
	  deleteAccountPage.waitForAccountDeletedMessage();
	  
	  deleteAccountPage.clickConinue();
	  
	  logger.info("Validando que se elimino la cuenta y no este logueada");
	  
	  assertTrue(homePage.carruselHome(),"No es visible la pagina de inicio");
	  
	  assertFalse(homePage.isLogoutVisible(), "El boton Logout todavía es visible");

	 	 
	 
 }
 
 
 @Test (enabled= false)
 public void verifyCartAfterLogin() {
	 
	 homePage.irProducts();
	 
	 assertTrue(productsPage.imagenVisibleProducs(),"No es visible la imagen");
	 
	 logger.info("Buscando producto");
	 
	 productsPage.searchProduct("Blue Top");
	 
	 productsPage.clickBtnSearch();
	 
	 productsPage.scrollProdusctsSearch();
	 
	 assertTrue(productsPage.visibleListProducts(),"Los productos no son visibles");
	 
	 logger.info("Agregando al carrito");
	 
	 productsPage.addToCartViewCart(1);
	 
	 logger.info("navegando a carrito y validando producto agregado");
	 
	 assertTrue(cartPage.isProductVisible(1), "No es visible el producto");
	 
	 cartPage.goToCheckout();
	 
	 cartPage.clickToRegisterLogin();
	 
	 logger.info("Iniciando sesion");
	 
	 loginPage.login("correo0107@yopmail.com", "12345");
	 
	 logger.info("Validando que se muestren los productos agregados anteriormente");
	 
	 homePage.goToCart();
	 
	 assertTrue(cartPage.isProductVisible(1), "No es visible el producto");
	 
 }
 
 @Test  (enabled= false)
 public void verifyUserCanAddProductFromRecommendedItemsToCart() {
	 
	 logger.info("Validando pagina de inicio");
	 
	 assertTrue(homePage.carruselHome(), "No es visible el carrusel de articulos");
	 
	 logger.info("Haciendo scroll y validando que se muestren las recomendaciones");
	 
	 homePage.scrollRecommendedItems();
	 
	 assertTrue(homePage.isVisibleRecommendedItems(), "No se muestran las recomendaciones ");
	 
	 logger.info("Añadiendo a carrito primer recomendacion");
	 
	 homePage.addFirtsRecommendedItem();
	 
	 logger.info("Navegando a carrito validando que se agrego el producto");
	 
	 homePage.goToCart();
	 
	 assertTrue(cartPage.isProductRecommendationVisible(1), "No se agrego el producto");
	 	 
	 
 }
 
 @Test (enabled= false)
public void shouldDisplayCorrectAddressDetailsAtCheckout() {
	 
	 logger.info("Validando pagina principal");
	 
	 assertTrue(homePage.carruselHome(), "No es visible el carrusel");
	 
	 homePage.irLogin();
	 
	 String email = "user" + System.currentTimeMillis() + "@test.com";
	  
	  loginPage.registerNewUser("Carlos",email);
	  
	  logger.info("llenando formulario ");
	  
	  UserData user = new UserData();

	  user.setTitle("Mr");

	  user.setName("Pedro");

	  user.setEmail(email);

	  user.setPassword("123456");

	  user.setDay("10");

	  user.setMonth("May");

	  user.setYear("1995");

	  user.setNewsletter(true);

	  user.setOffers(false);

	  user.setFirstName("Pedro");

	  user.setLastName("Pérez");

	  user.setCompany("OpenAI");

	  user.setAddress1("Calle Mayor");

	  user.setAddress2("");

	  user.setCountry("Canada");

	  user.setState("Ontario");

	  user.setCity("Toronto");

	  user.setZipCode("12345");

	  user.setMobileNumber("666123456");
	  
	  singUpPage.fillForm(user);
	  
	  singUpPage.clickCreateAccount();
	  
	  assertTrue(accountCreatedPage.isPresentAccountCreated(),"No esta presente el texto");
	  
	  accountCreatedPage.continuar();
	  
     logger.info("validando icicio de sesión");
	  
	  assertTrue(loginPage.getLoggedInText().contains("Logged in as"),"No se encontro el mensaje ");
	  
	  homePage.scrollProducts();
	  
	  logger.info("Añadiendo productos al carrito");
	  
	  homePage.addToCartContinueShopping(1);
	  
	  homePage.addToCartViewCart(2);
	  
	  logger.info("Navegando a carrito");
	  
	  assertTrue(cartPage.textoCartVisible(), "No se muestra el texto");
	  
	  cartPage.goToCheckout();
	  
	  checkoutPage.verifyDeliveryAddress(user);

	  checkoutPage.verifyBillingAddress(user);
	 
 }
 

 
  
  
  
}
