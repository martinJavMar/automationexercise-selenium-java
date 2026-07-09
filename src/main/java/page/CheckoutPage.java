package page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import model.UserData;

public class CheckoutPage  extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By textArea=By.className("form-control");
	By btnPago=By.cssSelector("a[href='/payment']");
    By deliveryName =By.cssSelector("#address_delivery .address_firstname");
    By deliveryAddressLines =By.cssSelector("#address_delivery .address_address1");
    By deliveryCityStateZip =By.cssSelector("#address_delivery .address_city");
    By deliveryCountry =By.cssSelector("#address_delivery .address_country_name");
    By deliveryPhone = By.cssSelector("#address_delivery .address_phone"); 
    By billingName =By.cssSelector("#address_invoice .address_firstname");
    By billingAddressLines =By.cssSelector("#address_invoice .address_address1");
    By billingCityStateZip =By.cssSelector("#address_invoice .address_city");
    By billingCountry =By.cssSelector("#address_invoice .address_country_name");
    By billingPhone = By.cssSelector("#address_invoice .address_phone"); 
	
	
	
	 public void comment(String comment) {
		 type(comment, textArea);
	 }
	 
	 public void goToPayment() {
		 click(btnPago);
	 }
	 
	 public void verifyDeliveryAddress(UserData user) {

		    assertEquals(
		            getText(deliveryName),
		            user.getTitle() + ". "
		                    + user.getFirstName()
		                    + " "
		                    + user.getLastName(),
		            "El nombre de entrega no coincide."
		    );

		    List<WebElement> addressLines = driver.findElements(deliveryAddressLines);

		    assertEquals(
		            addressLines.get(0).getText(),
		            user.getCompany()
		    );

		    assertEquals(
		            addressLines.get(1).getText(),
		            user.getAddress1()
		    );

		    assertEquals(
		            addressLines.get(2).getText(),
		            user.getAddress2()
		    );

		    assertEquals(
		            getText(deliveryCityStateZip),
		            user.getCity() + " "
		                    + user.getState() + " "
		                    + user.getZipCode(),
		            "Ciudad, estado o código postal incorrectos."
		    );

		    assertEquals(
		            getText(deliveryCountry),
		            user.getCountry(),
		            "El país no coincide."
		    );

		    assertEquals(
		            getText(deliveryPhone),
		            user.getMobileNumber(),
		            "El teléfono no coincide."
		    );

		}
	 
	 
	 public void verifyBillingAddress(UserData user) {

		    assertEquals(
		            getText(billingName),
		            user.getTitle() + ". "
		                    + user.getFirstName()
		                    + " "
		                    + user.getLastName(),
		            "El nombre de entrega no coincide."
		    );

		    List<WebElement> addressLines = driver.findElements(billingAddressLines);

		    assertEquals(
		            addressLines.get(0).getText(),
		            user.getCompany()
		    );

		    assertEquals(
		            addressLines.get(1).getText(),
		            user.getAddress1()
		    );

		    assertEquals(
		            addressLines.get(2).getText(),
		            user.getAddress2()
		    );

		    assertEquals(
		            getText(billingCityStateZip),
		            user.getCity() + " "
		                    + user.getState() + " "
		                    + user.getZipCode(),
		            "Ciudad, estado o código postal incorrectos."
		    );

		    assertEquals(
		            getText(billingCountry),
		            user.getCountry(),
		            "El país no coincide."
		    );

		    assertEquals(
		            getText(billingPhone),
		            user.getMobileNumber(),
		            "El teléfono no coincide."
		    );

		}

}
