package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import model.UserData;

public class SingUpPage extends BasePage{

	public SingUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By inputName=By.id("name");
	By inputEmail= By.id("email");
	By inputPassword=By.id("password");
	By selectDays= By.id("days");
	By selectMonth=By.id("months");
	By selectYears=By.id("years");
	By checkNewsletter=By.id("newsletter");
	By checkOffers=By.id("optin");
	By inputfirstNameAddress=By.id("first_name");
	By inputLastName=By.id("last_name");
	By inputCompany=By.id("company");
	By inputAdress=By.id("address1");
	By inputAddress2=By.id("address2");
	By selectCountry=By.id("country");
	By inputState=By.id("state");
	By inputCity=By.id("city");
	By inputZipcode=By.id("zipcode");
	By inputMobileNumber=By.id("mobile_number");
	By btnCreateAccount=By.cssSelector("button[data-qa='create-account']");
	
	

	public void selectTitle(String value) {
	    driver.findElement(
	        By.xpath("//input[@name='title' and @value='" + value + "']")
	    ).click();
	}
	
	public void enterName(String name) {
		type(name, inputName);
	}
	
	public void enterEmail(String email) {
		type(email, inputEmail);
	}
	
	public void enterPass(String password) {
		type(password, inputPassword);
	}
	
	public void selectDayBrith(String day) {
		selectByVisibleText(selectDays, day);
	}
	
	public void selectMonthBirth(String month) {
		selectByVisibleText(selectMonth, month);
	}
	
	public void selectYearBirth(String year) {
		selectByVisibleText(selectYears, year);
	}
	
	public void setNewsletter(boolean option) {
		setCheckbox(checkNewsletter, option);
	}
	
	public void setOffers(boolean option) {
		setCheckbox(checkOffers, option);
	}
	
	public void enterFirtsName(String name) {
		type(name, inputfirstNameAddress);
	}
	
	public void enterLastName(String lastName) {
		type(lastName, inputLastName);
	}
	
	public void enterCompany(String company) {
		type(company, inputCompany);
	}
	
	public void enterAddres(String address) {
		type(address, inputAdress);
	}
	
	public void fillCompany(String address) {

	    if (address != null && !address.isBlank()) {
	        type(address, inputAddress2);
	    }
	}
	
	public void selectCountry(String option) {
		selectByVisibleText(selectCountry, option);
	}
	
	public void enterState(String state) {
		type(state, inputState);
	}
	
	public void enterCity(String city) {
		type(city, inputCity);
	}
	
	public void enterZip(String zipCode) {
		type(zipCode, inputZipcode);
	}
	
	public void enterMobileNumber(String numero) {
		type(numero, inputMobileNumber);
	}
	
	public void clickCreateAccount() {
		click(btnCreateAccount);
	}
	
	
	public void fillForm(UserData user){

	    selectTitle(user.getTitle());

	    enterName(user.getName());

	    enterPass(user.getPassword());

	    selectDayBrith(user.getDay());

	    selectMonthBirth(user.getMonth());

	    selectYearBirth(user.getYear());

	    setNewsletter(user.isNewsletter());

	    setOffers(user.isOffers());

	    enterFirtsName(user.getFirstName());

	    enterLastName(user.getLastName());

	    enterCompany(user.getCompany());

	    enterAddres(user.getAddress1());

	    fillCompany(user.getAddress2());

	    selectCountry(user.getCountry());

	    enterState(user.getState());

	    enterCity(user.getCity());

	    enterZip(user.getZipCode());

	    enterMobileNumber(user.getMobileNumber());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
