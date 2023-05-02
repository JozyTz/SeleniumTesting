package com.example.test;

import com.example.base.BaseTest;
import com.example.pages.CheckoutPage;
import com.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutPageTests extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private CheckoutPage checkoutPage = new CheckoutPage(getDriver(), homePage);

    @Test
    void navigateToPageTest() {
        checkoutPage.navigateToSelf();

        Assertions.assertTrue(checkoutPage.pageDidLoad());
    }

    @Test
    void emptyProductCartTest() {
        checkoutPage.navigateToSelf();

        Assertions.assertTrue(checkoutPage.cartIsEmpty());
    }

    @Test
    void ProductInCartTest() {
        String productName = "Blitzing Cap";
        homePage.incrementProductCount(productName, 2);

        checkoutPage.navigateToSelf();
        Assertions.assertFalse(checkoutPage.cartIsEmpty());
    }
}
