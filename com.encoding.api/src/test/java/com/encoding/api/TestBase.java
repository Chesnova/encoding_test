package com.encoding.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestBase {
  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    driver = new ChromeDriver();
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    driver.quit();

  }

  protected void assertParametrStatus() {
    driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[35]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[35]")).getText(), "\"[Status]\"");
  }

  protected void assertParametrProcessor() {
    driver.findElement(By.xpath("//*[@id=\"page-responses-getstatus-extended\"]/div[2]/div[1]/div/div[2]/div[1]/button[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[26]")).getText(), "\"[AMAZON | RACKSPACE]\"");
  }

  protected void assertUrl() {
    String urlActual = "https://api.encoding.com/reference/responses-getstatus-extended";
    String urlExpected = driver.getCurrentUrl();
    assertEquals(urlActual, urlExpected);
  }

  protected void openResultSearch() {
    driver.findElement(By.xpath("//div[@id='hub-search-results']/div/div/div/div/div/div[3]/div[2]/a[2]/div/span/em")).click();
  }

  protected void enterSearchQuery() {
    driver.findElement(By.xpath("//div[@id='hub-search']/button/div[2]")).click();
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).click();
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).clear();
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).sendKeys("getStatus");
  }

  protected void openBaseUrl() {
    driver.get(ConfProperties.getProperty("baseUrl"));
  }
}
