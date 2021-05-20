package com.encoding.api;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UiTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   // driver.get(ConfProperties.getProperty("baseUrl"));
  }

  /*Тест 1
1. Открыть https://api.encoding.com/
2. В поиске ввести 'getStatus'
3. Перейти по результату 'GetStatus (extended)'
4. Проверить текущий URL 'https://api.encoding.com/reference#responses-getstatus-extended'
5. На открытой странице в секции 'Response' во вкладке JSON проверить:
 - параметр 'processor' содержит значения 'AMAZON' и 'RACKSPACE'
 - на уровне 'format' параметр 'status' равен 'Status'
*/
  @Test
  public void testCaseOne() throws Exception {
 //   1. Открыть https://api.encoding.com/
    driver.get(ConfProperties.getProperty("baseUrl"));
    //Нажать Поиск
    driver.findElement(By.xpath("//div[@id='hub-search']/button/div[2]")).click();
    /*for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='hub-search-results']/div/div/div/div/div"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }*/


//Нажать в поисковую строку
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).click();
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).clear();
    // 2. В поиске ввести 'getStatus'
    driver.findElement(By.cssSelector("input.Input.Input_md.SearchBox-Input3Go53QMpazG-")).sendKeys("getStatus");
    /*for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='page-general-gettingstarted']/div/div/header/div/p"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }*/
   // 3. Перейти по результату 'GetStatus (extended)'
    driver.findElement(By.xpath("//div[@id='hub-search-results']/div/div/div/div/div/div[3]/div[2]/a[2]/div/span/em")).click();
//4. Проверить текущий URL 'https://api.encoding.com/reference#responses-getstatus-extended'
    String urlActual = "https://api.encoding.com/reference/responses-getstatus-extended";
    String urlExpected = driver.getCurrentUrl();
    assertEquals(urlActual, urlExpected);
//5. На открытой странице в секции 'Response' во вкладке JSON проверить:
// - параметр 'processor' содержит значения 'AMAZON' и 'RACKSPACE'
    //driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[26]")).click();
    driver.findElement(By.xpath("//*[@id=\"page-responses-getstatus-extended\"]/div[2]/div[1]/div/div[2]/div[1]/button[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[26]")).getText(), "\"[AMAZON | RACKSPACE]\"");

// - на уровне 'format' параметр 'status' равен 'Status'
    driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[35]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='page-responses-getstatus-extended']/div[2]/div/div/div[2]/div[2]/pre[2]/code/div/span[35]")).getText(), "\"[Status]\"");
    /*

  */
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }




}
