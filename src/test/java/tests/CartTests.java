package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class CartTests extends BaseTest{
	

@DataProvider(name = "emails")
public Object[][] emails() {
    return new Object[][] {
        {"correo1@yopmail.com"},
        {"correo2@yopmail.com"},
        {"correo3@yopmail.com"}
    };
    

}
	
  @Test (dataProvider = "emails")
  public void validarSuscricionCarrito(String email) {
	  homePage.goToCart();
	  
	  logger.info("validando pagina de carrito");
	  assertTrue(cartPage.textoCartVisible(),"El texto no es visible");
	  assertEquals(cartPage.obtenerTextoLabelCart(),"Shopping Cart","el texto no coincide");
	  
	  logger.info("suscribiendose a pagina");
	  cartPage.suscription(email);
	  assertTrue(cartPage.validateMessageSuscription(),"Mensaje no es visible");
	  assertEquals(cartPage.getTextMessageSuscription(), "You have been successfully subscribed!");
	  }
  
  @Test
  public void removeProductFromCart() {
	  
	  assertTrue(homePage.carruselHome(),"No se muestra el carruel con productos");
	  
	  logger.info("Añadiendo prodructos");
	  
	  homePage.scrollProducts();
	  
	  homePage.addToCartContinueShopping(1);
	  
	  homePage.addToCartContinueShopping(2);
	  
	  logger.info("Navegando a carrito");
	  
	  homePage.goToCart();
	  
	  assertTrue(cartPage.textoCartVisible(),"No se muestra el texto");
	  
	  assertTrue(cartPage.isProductVisible(1),"No se muestra el producto");
	  
	  cartPage.deleteItem(1);
	  
	  assertTrue(cartPage.waitProductNotVisible(1),"El producto aun se muestra");
	  	
}
 
  
 
}
