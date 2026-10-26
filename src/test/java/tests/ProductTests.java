package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ProductTests extends BaseTest {
	
	
	@BeforeMethod
	public void goToProducts() {
		assertTrue(
				homePage.carruselHome(),"El logo no es visible");
		
		
		
	}
	
	
	@Test(groups = {"smoke", "regression"})
	public void validarProductos() {
		
        homePage.irProducts();
		
		productsPage.imagenVisibleProducs();
		
		
		productsPage.scroollToHeading();
		
		assertTrue(productsPage.headingIsVisible(), "no es visible");
		
		System.out.println(productsPage.getTextHeading());
		
		
        assertEquals(productsPage.getTextHeading(),"ALL PRODUCTS");
		
		assertTrue(productsPage.visibleListProducts(),"no es visible la lista de procutos");
		
		productsPage.getProducto(1).click();
		
		assertTrue(productsPage.textProduct(),"No es visible el producto");
		
		assertEquals(productsPage.getTextProduct1(),"Blue Top");
		
				
	}
	
	@DataProvider(name = "products")
	public Object[][] emails() {
	    return new Object[][] {
	        {"Blue Top"},
	        {"Blue Cotton Indie Mickey Dress"},
	        {"Grunt Blue Slim Fit Jeans"}
	    };
	}
	
	@Test(dataProvider = "products",groups = {"smoke", "regression"})
	
	public void busquedaProductos(String producto) {
		
		
       homePage.irProducts();
		
		productsPage.imagenVisibleProducs();
		productsPage.searchProduct(producto);
		productsPage.clickBtnSearch();
		assertTrue(productsPage.isSearchResultDisplayed(),"No es visible el texto");
		 List<String> products = productsPage.getProductNames();
		 assertFalse(products.isEmpty());
		 boolean found = products.stream()
		            .anyMatch(product ->
		                    product.toLowerCase()
		                           .contains(producto.toLowerCase()));

		 assertTrue(
		            found,
		            "No se encontró el producto: " + producto
		    );
			
	}
	
	
	@Test(groups = {"smoke", "regression"})
	public void agregarProductos() {
homePage.irProducts();
		
		productsPage.imagenVisibleProducs();
		productsPage.scroollToHeading();
		productsPage.addToCartContinueShopping(1);
		productsPage.addToCartViewCart(2);
		assertTrue(cartPage.validateProductsCart("Blue Top"),"No es visible el articulo");
		assertTrue(cartPage.validateProductsCart("Men Tshirt"),"No es visible el articulo");
		assertEquals(cartPage.getPrice(1), "Rs. 500");
		assertEquals(Integer.parseInt(cartPage.getQuanty(1)), 1);
		assertEquals(cartPage.getTotal(1), "Rs. 500");
		assertEquals(cartPage.getPrice(2), "Rs. 400");
		assertEquals(Integer.parseInt(cartPage.getQuanty(2)), 1);
		assertEquals(cartPage.getTotal(2), "Rs. 400");
		
	}
	
	@Test (groups = {"regression"})
	public void VerificarCantidadProductoEnCarritoTest() {
homePage.irProducts();
		
		productsPage.imagenVisibleProducs();
		logger.info("Iniciando test ");
		productsPage.scroollToHeading();
		productsPage.viewProduct(3);
		assertTrue(productDetailsPage.informationProductVisible(),"No es visible la informacion");
		productDetailsPage.enterAmount(4);
		productDetailsPage.addToCartViewCart();
		assertTrue(cartPage.validateProductsCart("Sleeveless Dress"),"No es visible el articulo");
		assertEquals(Integer.parseInt(cartPage.getQuanty(1)), 4);		
		
	}
	
	
	@Test (groups = {"regression"})
	public void verifyProductReviewSubmissio() {
		
		logger.info("Validando que cargue pantalla home");
		assertTrue(homePage.carruselHome(), "No es visible el carrusel de imagenes");

		logger.info("Navegando a productos y validando pantalla");
		
		homePage.irProducts();
		
		assertTrue(productsPage.imagenVisibleProducs(),"No es visible la imagen de la pantalla produstos");
		
		productsPage.scroollToHeading();
		
		productsPage.viewProduct(2);
		
		logger.info("Navegando a detalles del producto");
		
		productDetailsPage.enterReview("juan", "juan123@yopmail.com", "reviwe de producto prueba");
		
		assertEquals(productDetailsPage.validateMessageReview(),"Thank you for your review.","No coincide el mensaje");
		
		
	}

	
}
