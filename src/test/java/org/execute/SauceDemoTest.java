package org.execute;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceDemoTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSauceDemoWorkflow() {
        // Step 1 - Launch Url
        driver.get("https://www.saucedemo.com/");

        // Step 2 - Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 3 - Validate logged in
        String productsUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(productsUrl, driver.getCurrentUrl());

        // Step 4 - Add all 6 items to cart
        List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));
        for (WebElement button : addToCartButtons) {
            button.click();
        }

        // Step 5 - Validate cart has 6 items
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals("6", cartBadge.getText());

        // Step 6 - Remove items
        removeItemFromCart("Sauce Labs Onesie");
        removeItemFromCart("Sauce Labs Fleece Jacket");

        // Step 7 - Validate cart has 4 items
        Assert.assertEquals("4", cartBadge.getText());

        // Step 8 - Click checkout button
        driver.findElement(By.className("checkout_button")).click();

        // Step 9 - Validate checkout page appeared
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));

        // Step 10 - Fill checkout information
        driver.findElement(By.id("first-name")).sendKeys("Ganapathy");
        driver.findElement(By.id("last-name")).sendKeys("Kumar");
        driver.findElement(By.id("postal-code")).sendKeys("600018");
        driver.findElement(By.className("btn_primary")).click();

        // Step 11 - Validate checkout overview page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
        driver.findElement(By.className("cart_button")).click();

        // Step 12 - Validate order confirmation page and message
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));

        WebElement completeHeader = driver.findElement(By.className("complete-header"));
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", completeHeader.getText());

        // Step 13 - Back to home page and logout
        driver.findElement(By.className("btn_secondary")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        // Step 14 - Validate user logged out
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }

    private void removeItemFromCart(String itemName) {
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        for (WebElement item : cartItems) {
            WebElement itemDescription = item.findElement(By.className("inventory_item_name"));
            if (itemDescription.getText().equals(itemName)) {
                WebElement removeButton = item.findElement(By.className("btn_secondary"));
                removeButton.click();
                break;
            }
        }
    }
}
