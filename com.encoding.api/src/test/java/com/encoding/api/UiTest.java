package com.encoding.api;


import org.testng.annotations.Test;

  /*Тест 1
1. Открыть https://api.encoding.com/
2. В поиске ввести 'getStatus'
3. Перейти по результату 'GetStatus (extended)'
4. Проверить текущий URL 'https://api.encoding.com/reference#responses-getstatus-extended'
5. На открытой странице в секции 'Response' во вкладке JSON проверить:
 - параметр 'processor' содержит значения 'AMAZON' и 'RACKSPACE'
 - на уровне 'format' параметр 'status' равен 'Status'
*/

public class UiTest extends TestBase{


  @Test
  public void testCaseOne() {
    //  1. Открыть https://api.encoding.com/
    openBaseUrl();
    // 2. В поиске ввести 'getStatus'
    enterSearchQuery();
    // 3. Перейти по результату 'GetStatus (extended)'
    openResultSearch();
    //4. Проверить текущий URL 'https://api.encoding.com/reference#responses-getstatus-extended'
    assertUrl();
    //5. На открытой странице в секции 'Response' во вкладке JSON проверить:
    // - параметр 'processor' содержит значения 'AMAZON' и 'RACKSPACE'
    assertParametrProcessor();
    // - на уровне 'format' параметр 'status' равен 'Status'
    assertParametrStatus();
  }


}
