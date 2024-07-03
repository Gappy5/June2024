package org.execute;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class AdactinHotel {
	public static BaseClass base = new BaseClass();
	public static LoginPage loginPage = new LoginPage();
	public static SearchHotel searchHotel = new SearchHotel();
	public static SelectHotel Hotel = new SelectHotel();
	public static BookHotel bookhotel = new BookHotel();

	@BeforeClass
	public static void LoginPageValidation() {
		String browserType = "";

		try {

			base.getDriver(base.readExcel(0, 1));
			// browserType = base.readExcel(0, 1);
			System.out.println(browserType + "_Browser Launched Successfully ");
			// Report - browserType + "_Browser Launched Successfully "

		} catch (SessionNotCreatedException e) {
			System.out.println(browserType + "_Browser Not Launched Successfully " + e.getMessage());
			// Report - browserType + "_Browser Not Launched Successfully " + screenCapture
		} catch (WebDriverException e) {
			System.out.println(browserType + "_Browser Not Launched Successfully " + e.getMessage());
			// Report - browserType + "_Browser Not Launched Successfully " + screenCapture
		} catch (Exception e) {
			System.out.println(browserType + "_Browser Not Launched Successfully " + e.getMessage());
			// Report - browserType + "_Browser Not Launched Successfully " + screenCapture
		}

		try {
			base.getUrl(base.readExcel(1, 1));
			base.winMax();

			if (base.getCurrentUrl().equals(base.readExcel(1, 1))) {
				System.out.println("Url  Launched Successfully ");
				// report - url Launched Successfully
			} else {
				// report - url Not Launched Successfully\
				base.getUrl(base.readExcel(1, 1));
				// Report - Url Launched Successfully - Current url had failure
			}

		} catch (Exception e) {
			System.out.println("_Url Not Launched Successfully " + e.getMessage());
			// Report -"_Url Not Launched Successfully " + screenCapture
		}

		try {
			loginPage = new LoginPage();

//			WebElement loginUserText = loginPage.getLoginUserText();
//			boolean displayed = loginUserText.isDisplayed();

			if (loginPage.getLoginUserText().isDisplayed()) {

//				WebElement loginUserText = loginPage.getLoginUserText();
//				String text = loginUserText.getText();
//				
				System.out.println("User is in " + loginPage.getLoginUserText().getText());

				// Report - "User is in " + loginPage.getLoginUserText().getText()
			}

		} catch (Exception e) {
			System.out.println("User is Not in " + loginPage.getLoginUserText().getText());

			// Report - "User is in " + loginPage.getLoginUserText().getText()

		}
		try {
			loginPage = new LoginPage();
//			WebElement userName = loginPage.getUserName();
//			base.sendKeys(userName, base.readExcel(2, 1));

			loginPage.getUserName().sendKeys(base.readExcel(2, 1));
//			
//			if (userName.isDisplayed()) {
//				
//				base.sendKeys(userName, base.readExcel(2, 1));
//				
//			}

//			WebElement password = loginPage.getPassword();
//			base.sendKeys(password, base.readExcel(3, 1));
			loginPage.getPassword().sendKeys(base.readExcel(3, 1));

			WebElement loginButton = loginPage.getLoginButton();

			if (loginButton.isEnabled()) {
				// Report - Login Button Enabled + loginButton.getText();
				System.out.println(loginButton.getAttribute("value") + "_Login Button Enabled ");
				base.click(loginButton);

			}

		} catch (Exception e) {
			System.out.println("Datas Not Entered / Button Not Cliked " + e.getMessage());
			// Report - "Datas Not Entered / Button Not Cliked " +e.getMessage()

		}

		try {
			searchHotel = new SearchHotel();
			if (searchHotel.getSearchHotelText().isDisplayed()) {

				System.out.println("Login Page Successfully Loged In / Search Hotel Displayed Successfully ");
				// Report - Login Page Successfully Loged In / Search Hotel Displayed
				// Successfully
			}

		} catch (Exception e) {
			System.out.println(" Button Not Cliked " + e.getMessage());
			// Report - "Button Not Cliked " +e.getMessage()
		}

	}

	@Before
	public void SearchPageValidation() {

		try {

			searchHotel = new SearchHotel();

			searchHotel.getlocation().sendKeys(base.readExcel(4, 1));
			searchHotel.gethotels().sendKeys(base.readExcel(5, 1));
			searchHotel.getroomType().sendKeys(base.readExcel(6, 1));
			searchHotel.getroomNos().sendKeys(base.readExcel(7, 1));
//			searchHotel.getcheckInDate().sendKeys(base.readExcel(8, 1));
//			searchHotel.getcheckOutDate().sendKeys(base.readExcel(9, 1));
			searchHotel.getadultPerRoom().sendKeys(base.readExcel(10, 1));
			searchHotel.getchildPerRoom().sendKeys(base.readExcel(11, 1));
			WebElement getsearchBtn = searchHotel.getsearchBtn();
			if (getsearchBtn.isEnabled()) {
				System.out.println(getsearchBtn.getAttribute("value") + "Search button is enabled");
				getsearchBtn.click();

			}
		} catch (Exception e) {
			System.out.println("Button Not Cliked " + e.getMessage());
		}

		try {
			Hotel = new SelectHotel();
			if (Hotel.getSelectHotelText().isDisplayed()) {
				System.out.println("Search Hotel clicked Successfully / Select Hotel Displayed Successfully ");

			}

		} catch (Exception e) {
			System.out.println(" search Button Not Cliked " + e.getMessage());
		}
		try {
			Hotel = new SelectHotel();
			WebElement radioButton = Hotel.getRadioButton();
			if (radioButton.isEnabled()) {
				System.out.println(radioButton.getAttribute("value") + "Radio button is enabled");
				radioButton.click();
			}
		} catch (Exception e) {
			System.out.println("Radio button is not  enabled" + e.getMessage());
		}

		try {
			Hotel = new SelectHotel();
			WebElement continueButton = Hotel.getContinueButton();
			if (continueButton.isEnabled()) {
				System.out.println(continueButton.getAttribute("value") + "Radio button is enabled");
				continueButton.click();
			}
		} catch (Exception e) {
			System.out.println("Radio button is not  enabled" + e.getMessage());
		}
	}

	@Test
	public void BookAHotel() {
		try {
			bookhotel = new BookHotel();
			if (bookhotel.getBookHotelText().isDisplayed()) {
				System.out.println("Search Hotel clicked Successfully/ Book Hotel Displayed Successfully");
			}
		} catch (Exception e) {
			System.out.println("Search Hotel not clicked Successfull" + e.getMessage());
		}

		try {
			bookhotel = new BookHotel();
			bookhotel.getFirstName().sendKeys(base.readExcel(12, 1));
			bookhotel.getLastName().sendKeys(base.readExcel(13, 1));
			bookhotel.getAddress().sendKeys(base.readExcel(14, 1));
			bookhotel.getCardNo().sendKeys(base.readExcel(15, 1));
			bookhotel.getCardType().sendKeys(base.readExcel(16, 1));
			bookhotel.getExpiryDateMonth().sendKeys(base.readExcel(17, 1));
			bookhotel.getExpiryDateYear().sendKeys(base.readExcel(18, 1));
			bookhotel.getCvNumber().sendKeys(base.readExcel(19, 1));

			WebElement buttonBook = bookhotel.getButtonBook();
			if (buttonBook.isEnabled()) {
				System.out.println(buttonBook.getAttribute("value" + "Book Now Button is Enabled"));
				buttonBook.click();
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			System.out.println("Book Now Button is not Enabled");
		}
	}
	private void sysout() {
		System.out.println("Hello Gappy");

	}
}
