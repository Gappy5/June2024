package org.execute;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public void SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//td[text()='Search Hotel ']")
	private WebElement searchHotelText;

	public WebElement getSearchHotelText() {
		return searchHotelText;
	}

	@FindBy(how = How.XPATH, using = "//select[@name='location']")
	private WebElement location;

	@FindBy(how = How.XPATH, using = "//select[@name='hotels']")
	private WebElement hotels;

	@FindBy(how = How.XPATH, using = "//select[@name='room_type']")
	private WebElement roomType;

	@FindBy(how = How.XPATH, using = "//select[@name='room_nos']")
	private WebElement roomNos;

	@FindBy(how = How.XPATH, using = "//select[@name='datepick_in']")
	private WebElement checkInDate;

	@FindBy(how = How.XPATH, using = "//input[@name='datepick_out']")
	private WebElement checkOutDate;

	@FindBy(how = How.XPATH, using = "//select[@name='adult_room']")
	private WebElement adultPerRoom;

	@FindBy(how = How.XPATH, using = "//select[@name='child_room']")
	private WebElement childPerRoom;

	@FindBy(how = How.XPATH, using = "(//input[@class='reg_button'])[1]")
	private WebElement searchBtn;

	public WebElement getlocation() {
		return location;
	}

	public WebElement gethotels() {
		return hotels;
	}

	public WebElement getroomType() {
		return roomType;
	}

	public WebElement getroomNos() {
		return roomNos;
	}

	public WebElement getcheckInDate() {
		return checkInDate;
	}

	public WebElement getcheckOutDate() {
		return checkOutDate;
	}

	public WebElement getadultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getchildPerRoom() {
		return childPerRoom;
	}

	public WebElement getsearchBtn() {
		return searchBtn;
	}

}
