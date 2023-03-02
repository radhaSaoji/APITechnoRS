package testScripts;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoTest {

	@Test
	public void printPhoneNumberTest() {
		RestAssured.baseURI = "https://0e686aed-6e36-4047-bcb4-a2417455c2d7.mock.pstmn.io";

		Response res = RestAssured.given()
				.headers("Accept", "application/json")
				.when()
				.get("/test");

		System.out.println(res.asPrettyString());
		List<String> listOfType = res.jsonPath().getList("phoneNumbers.type");
		System.out.println(listOfType);
	}

	@Test
	public void printPhoneNumberTypeTest() {
		RestAssured.baseURI = "https://0e686aed-6e36-4047-bcb4-a2417455c2d7.mock.pstmn.io";

		Response res = RestAssured.given()
				.log().all()
				.headers("Accept", "application/json")
				.when()
				.get("/test");

		List<Object> phoneNumberList = res.jsonPath().getList("phoneNumbers");

		for (Object obj : phoneNumberList) {
			Map<String, String> phoneNumberMap = (Map<String, String>) obj;
			if (phoneNumberMap.get("type").equals("iPhone"))
				Assert.assertTrue(phoneNumberMap.get("number").startsWith("3456"));
			else if (phoneNumberMap.get("type").equals("home"))
				Assert.assertTrue(phoneNumberMap.get("number").startsWith("0123"));
			System.out.println(phoneNumberMap.get("type") + "-" + phoneNumberMap.get("number"));
		}
	}

}
