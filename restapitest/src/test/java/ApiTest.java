import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Тест 2
Отправить 2 варианта GET запроса
XML: https://status.encoding.com/status.php?format=xml
JSON: https://status.encoding.com/status.php?format=json

Проверить следующие параметры в ответе:
1. Параметр status равен Ok
2. Параметр lastYear меньше 10
3. Проверить uptime (сек) больше 1 суток

*/
public class ApiTest {
  @Test
  public void apiTestJsn() {

    //   1. Параметр status равен Ok
    String r1 = RestAssured.when()
            .get("https://status.encoding.com/status.php?format=json")
            .then()
            .extract().response().body().path("status");
    Assert.assertTrue(r1.contains("Ok"));

    //   2. Параметр lastYear меньше 10
    String r = RestAssured.when()
            .get("https://status.encoding.com/status.php?format=json")
            .then()
            .extract().response().body().path("incident_count.lastYear");

    int y = Integer.parseInt(r);
    int x = 10;
    Assert.assertTrue(y < x);

    //    3. Проверить uptime (сек) больше 1 суток
    int r3 = RestAssured.when()
            .get("https://status.encoding.com/status.php?format=json")
            .then()
            .extract().response().body().path("uptime");
    int h = r3 / 86400;
    int h2 = 24;
    Assert.assertTrue(h > h2);

  }

  @Test
  public void apiTestXml() {
    String response1 = RestAssured.get("https://status.encoding.com/status.php?format=xml").asString();


    //   1. Параметр status равен Ok
    String response = RestAssured.get("https://status.encoding.com/status.php?format=xml")
            .then().extract().response().body().path("[0].status");
    Assert.assertTrue(response.contains("Ok"));

    //   2. Параметр lastYear меньше 10

    XmlPath xmlPath = XmlPath.from(response1);
    String r6 = xmlPath.getString("response.incident_count.lastYear");
    int y = Integer.parseInt(r6);
    int x = 10;
    Assert.assertTrue(y < x);

//    3. Проверить uptime (сек) больше 1 суток
    String response3 = RestAssured.get("https://status.encoding.com/status.php?format=xml")
            .then().extract().response().body().path("[0].uptime");
    int r3 = Integer.parseInt(response3);
    int h = r3 / 86400;
    int h2 = 24;
    Assert.assertTrue(h > h2);
  }
}
