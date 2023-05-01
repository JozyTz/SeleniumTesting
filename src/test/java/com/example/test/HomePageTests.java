package com.example.test;

import com.example.base.BaseTest;
import com.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseTest
{
    private HomePage homePage = new HomePage(getDriver());

    @Test
    public void pageLoadTest()
    {
        boolean isPageLoaded = homePage.isPageLoaded();
        Assertions.assertTrue(isPageLoaded, "Home page has not loaded correctly");
    }

    @Test
    public void productIncrementTest()
    {
        String productName = "Blitzing Cap";
        boolean countIncremented = homePage.incrementProductCount(productName, 5);
        Assertions.assertTrue(countIncremented, "Product count was not incremented when clicking the button");
    }

    @Test
    public void productDecrementTest()
    {
        String productName = "Blitzing Cap";
        boolean initCountUpdated = homePage.incrementProductCount(productName, 3);
        Assertions.assertTrue(initCountUpdated, "Failed to initialized count as 5 for the given product");
        boolean countDecremented = homePage.decrementProductCount(productName, 5);
        Assertions.assertTrue(countDecremented, "Product count was not decremented when clicking the button");
    }
}