import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class ApiTestXML {
  @Test
  public void apiTestXml(){
/*Тест 2
Отправить 2 варианта GET запроса
XML: https://status.encoding.com/status.php?format=xml
JSON: https://status.encoding.com/status.php?format=json

Проверить следующие параметры в ответе:
1. Параметр status равен Ok
2. Параметр lastYear меньше 10
3. Проверить uptime (сек) больше 1 суток

*/
    RestAssured.when()
            .get("https://status.encoding.com/status.php?format=xml")
            .then().assertThat().statusCode(200);
            //.then().body("status", is("Ok"));
  }
}
