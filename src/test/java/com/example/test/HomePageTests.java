package com.example.test;

import com.example.base.BaseTest;
import com.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseTest
{
    @Test
    public void pageLoadTest()
    {
        HomePage homePage = new HomePage(getDriver());
        boolean isPageLoaded = homePage.isPageLoaded();
        Assertions.assertTrue(isPageLoaded, "Home page has not loaded correctly");
    }
}