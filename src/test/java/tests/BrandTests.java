package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;

public class BrandTests extends BaseTest {
  @Test
  public void verifyProductFilteringByBrand() {
	  
	  logger.info("Validando carrusel de home");
	  
	  assertTrue(homePage.carruselHome(), "No es visible");
	  
	  logger.info("Navegando a products");
	  
	  homePage.irProducts();
	  
	  assertTrue(productsPage.imagenVisibleProducs(),"No es visible la imagen");
	  
	  logger.info("Haciendo scroll marcas");
	  
	  assertTrue(productsPage.areVisibleBrands(),"No se muestran las marcas");
	  
	  logger.info("Seleccionando marca");
	  
	  String brand="Polo";
	  
	  productsPage.selectBrand(brand);

	  assertTrue(brandPage.getURL().contains(brand),"No navega a la pagina de la maraca");
	  
      logger.info("Haciendo scroll marcas");
	  
	  assertTrue(productsPage.areVisibleBrands(),"No se muestran las marcas");
	  
	  logger.info("Seleccionando marca");
	  
	  String brand2="H&M";
	  
	  productsPage.selectBrand(brand2);

	  assertTrue(brandPage.getURL().contains(brand2),"No navega a la pagina de la maraca");
	  
  }
}
