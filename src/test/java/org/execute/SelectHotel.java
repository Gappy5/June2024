package org.execute;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//td[text()='Welcome to Adactin Group of Hotels']")
	private WebElement SelectHotelText;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radiobutton_0']")
	private WebElement radioButton;
	

	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	private WebElement continueButton;
	
	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getSelectHotelText() {
		return SelectHotelText;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
}