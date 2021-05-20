package com.encoding.api;

import org.testng.annotations.Test;

public class GetTest {
  @Test
  public static void testOne(){
    System.out.println("test");
    /*Тест 2
Отправить 2 варианта GET запроса
XML: https://status.encoding.com/status.php?format=xml
JSON: https://status.encoding.com/status.php?format=json

Проверить следующие параметры в ответе:
1. Параметр status равен Ok
2. Параметр lastYear меньше 10
3. Проверить uptime (сек) больше 1 суток

*/

  }
}
