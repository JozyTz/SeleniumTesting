package com.example.pages;

import com.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final static String checkoutPageSignal = "//h1[text() = 'Payment Information']";
    private final static String emptyCartSignal = "//p[text() = 'Your cart is empty!']";

    private final HomePage homePage;

    public CheckoutPage(WebDriver driver, HomePage homePage) {
        super(driver);
        this.homePage = homePage;
    }

    public void navigateToSelf() {
        homePage.getCheckoutElement().click();
    }

    public boolean pageDidLoad() {
        final WebElement element = driver.findElement(By.xpath(checkoutPageSignal));

        return element.isDisplayed();
    }

    public boolean cartIsEmpty() {
        try {
            final WebElement element = driver.findElement(By.xpath(emptyCartSignal));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
