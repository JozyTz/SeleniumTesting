package com.example.pages;

import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Sample page
 */
public class HomePage extends BasePage
{
  public HomePage(WebDriver driver)
  {
    super(driver);
  }

  public boolean isPageLoaded()
  {
    return driver.getCurrentUrl().startsWith("localhost") && driver.getTitle().equals("React App");
  }

}