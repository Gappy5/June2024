package org.execute;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.err.println("InValid Browser Type");
			break;
		}

	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void winMax() {
		driver.manage().window().maximize();

	}

	public void sendKeys(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void sendKeysJS(WebElement element, String keysToSend) {
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);

	}

	public void click(WebElement element) {
		element.click();
	}

	public void clickByJS(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	public void scroll(String scrollType, WebElement element) {

		switch (scrollType) {
		case "Up":
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		case "Down":
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			break;
		default:
			System.err.println("In Valid Scroll Type");
			break;
		}

	}

	public void screenCapture(String name) throws IOException {

		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File screenshotAs = takesScreenShot.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\velu\\JavaEnt\\SELENIUM\\New folder\\" + name + ".png");
		FileUtils.copyFile(screenshotAs, target);
	}

	public void windowsHandle(int index) {
		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();
		// Empty List Creation
		List<String> list = new LinkedList<String>();
		// To Add all the Values from Set to List
		list.addAll(allWindowsID);
		// To get Required Datas
		String ChildWindowsId = list.get(index);
		// To Switch To Windows
		driver.switchTo().window(ChildWindowsId);

	}

	public String getWindowsID(int index) {
		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();
		// Empty List Creation
		List<String> list = new LinkedList<String>();
		// To Add all the Values from Set to List
		list.addAll(allWindowsID);
		// To get Required Datas
		String ChildWindowsId = list.get(index);

		return ChildWindowsId;

	}

	public void switchWindows(String ChildWindowsId) {
		driver.switchTo().window(ChildWindowsId);
	}

	public String readExcel(int rownum, int cellnum) throws IOException {

		// To Locate Where the File is there
		File file = new File("C:\\Users\\kumar\\OneDrive\\Desktop\\eclipse-workspace\\AdactinHotel\\InputData\\AdactinCredentials.xlsx");

		FileInputStream stream = new FileInputStream(file);

		XSSFWorkbook book = new XSSFWorkbook(stream);

		Sheet sheet = book.getSheet("Sheet1");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		String value = null;
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();
			}
			break;

		default:
			break;
		}

		return value;

	}

}
