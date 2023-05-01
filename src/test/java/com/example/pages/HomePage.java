package com.example.pages;

import com.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * Sample page
 */
public class HomePage extends BasePage
{
  public HomePage(WebDriver driver)
  {
    super(driver);
  }

  String itemQuantityXpath = "//div[@class='item-quantity']/p";
  String addButtonXpath = "//button[@class='btn btn-add-item']";
  String subtractButtonXpath = "//button[@class='btn btn-subtract-item']";

  private String getProductCardXpath(String productName)
  {
    return String.format("//div[@class='card-title h5' and text()='%s']/..", productName);
  }

  public boolean isPageLoaded()
  {
    String url = driver.getCurrentUrl();
    WebElement element = driver.findElement(By.xpath("/html/head/title"));
    String pageTitle = element.getAttribute("textContent");
    return (url.contains("localhost") && pageTitle.equals("React App"));
  }

  public int getProductCount(String productName)
  {
    String cardXpath = getProductCardXpath(productName);
    WebElement itemQuantityElement = driver.findElement(By.xpath(cardXpath + itemQuantityXpath));
    return Integer.parseInt(itemQuantityElement.getAttribute("textContent"));
  }

  public boolean incrementProductCount(String productName, int amount)
  {
    int count = getProductCount(productName);
    String cardXpath = getProductCardXpath(productName);
    WebElement addItemButton = driver.findElement(By.xpath(cardXpath + addButtonXpath));
    for (int i = 1; i <= amount; i++)
    {
      addItemButton.click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardXpath + itemQuantityXpath + "[text()='" + (count + i) + "']")));
    }
    return (getProductCount(productName) == count + amount);
  }

  public boolean decrementProductCount(String productName, int amount)
  {
    int count = getProductCount(productName);
    String cardXpath = getProductCardXpath(productName);
    WebElement subtractItemButton = driver.findElement(By.xpath(cardXpath + subtractButtonXpath));
    for (int i = 1; i <= amount; i++)
    {
      subtractItemButton.click();
      if (count - i < 0) continue;
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardXpath + itemQuantityXpath + "[text()='" + (count - i) + "']")));
    }
    if (count - amount < 0) return getProductCount(productName) == 0;
    return (getProductCount(productName) == count - amount);
  }
}