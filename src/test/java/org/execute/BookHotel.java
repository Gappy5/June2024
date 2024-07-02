package org.execute;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookHotel {

	public BookHotel() {
		SearchContext driver = null;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//td[text()='Book A Hotel ']")
	private WebElement BookHotelText;

	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	private WebElement FirstName;

	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	private WebElement LastName;

	@FindBy(how = How.XPATH, using = "//textarea[@name='address']")
	private WebElement Address;

	@FindBy(how = How.XPATH, using = "//input[@name='cc_num']")
	private WebElement CardNo;

	@FindBy(how = How.XPATH, using = "//select[@name='cc_type']")
	private WebElement CardType;

	@FindBy(how = How.XPATH, using = "//select[@name='cc_exp_month']")
	private WebElement ExpiryDateMonth;

	@FindBy(how = How.XPATH, using = "//select[@name='cc_exp_year']")
	private WebElement ExpiryDateYear;

	@FindBy(how = How.XPATH, using = "//input[@name='cc_cvv']")
	private WebElement CvNumber;

	@FindBy(how = How.XPATH, using = "//input[@type='button']")
	private WebElement buttonBook;


	@FindBy(how = How.XPATH, using = "//input[@name='order_no']")
	private WebElement orderNo;
	
@FindBy(xpath="(//input[@type='button'])[2]")	
private WebElement buttonItinerary;

	public WebElement getButtonItinerary() {
		return buttonItinerary;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getCardNo() {
		return CardNo;
	}

	public WebElement getCardType() {
		return CardType;
	}

	public WebElement getExpiryDateMonth() {
		return ExpiryDateMonth;
	}

	public WebElement getExpiryDateYear() {
		return ExpiryDateYear;
	}

	public WebElement getCvNumber() {
		return CvNumber;
	}

	public WebElement getButtonBook() {
		return buttonBook;
	}

	public WebElement getBookHotelText() {
		return BookHotelText;
	}
	public WebElement getOrderNo() {
		return orderNo;
	}
}