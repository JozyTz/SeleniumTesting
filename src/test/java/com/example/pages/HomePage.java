package com.example.pages;

import com.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    String url = driver.getCurrentUrl();
    WebElement element = driver.findElement(By.xpath("/html/head/title"));
    String pageTitle = element.getAttribute("textContent");
    return (url.contains("localhost") && pageTitle.equals("React App"));
  }

}