package testScripts;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.request.create.BookingDates_POJO;
import pojo.request.create.CreateBookingDetails;

public class CreateBookingWithJsonObjectTest {
	String token ;
	int bookingID;
	CreateBookingDetails bookingObj;
	
	@BeforeMethod
	public void getToken() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response res = RestAssured.given()
			.log().all()
			.headers("Content-Type","application/json")
			.body("{\r\n"
					+ "	\"username\" : \"admin\",\r\n"
					+ "	\"password\" : \"password123\"\r\n"
					+ "}")
			.when()
			.post("/auth");
			//.then().assertThat().statusCode(200)
			//.extract().response();
			 
		System.out.println(res.statusCode());
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(res.asPrettyString());
		token = res.jsonPath().getString("token");
		System.out.println(token);
	}
	
	@Test (enabled  = false)
	public void createNewBooking() {
		Response res1 = RestAssured.given()
				.headers("Content-Type","application/json")
				.headers("Accept","application/json")
				.body("{\r\n" + 
						"    \"firstname\" : \"Jim\",\r\n" + 
						"    \"lastname\" : \"Brown\",\r\n" + 
						"    \"totalprice\" : 111,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2018-01-01\",\r\n" + 
						"        \"checkout\" : \"2019-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
				.when()
				.post("/booking");
		
		Assert.assertEquals(res1.statusCode(), 200);
		System.out.println(res1.asPrettyString());
	}
	
	@Test
	public void createNewBookingusingPOJO() {
		
		JSONObject jsonObj = new JSONObject();
		
		JSONObject bookingDates = new JSONObject();
		bookingDates.put("checkin", "2018-01-01");
		bookingDates.put("checkout", "2019-01-01");
		
		jsonObj.put("firstname", "Radha");
		jsonObj.put("lastname", "Saoji");
		jsonObj.put("totalprice", 2000);
		jsonObj.put("depositpaid", true);
		jsonObj.put("bookingdates", bookingDates);
		jsonObj.put("additionalneeds", "Breakfast");
		
		Response res2 = RestAssured.given()
				.log().all()
				.headers("Content-Type","application/json")
				.headers("Accept","application/json")
				.body(bookingObj)
				.when()
				.post("/booking");
		
		Assert.assertEquals(res2.statusCode(), 200);
		System.out.println(res2.asPrettyString());
		bookingID = res2.jsonPath().getInt("bookingid");
		Assert.assertTrue(bookingID > 0);
		validateResponse(res2, bookingObj, "booking.");
	}
	
	private void validateResponse(Response res, CreateBookingDetails bookingObj, String object) {
		Assert.assertEquals(res.jsonPath().getString(object+"firstname"), bookingObj.getFirstname());
		Assert.assertEquals(res.jsonPath().getString(object+"lastname"), bookingObj.getLastname());
		Assert.assertEquals(res.jsonPath().getInt(object+"totalprice"), bookingObj.getTotalprice());
		Assert.assertEquals(res.jsonPath().getBoolean(object+"depositpaid"), bookingObj.isDepositpaid());
		Assert.assertEquals(res.jsonPath().getString(object+"bookingdates.checkin"), bookingObj.bookingdates.getCheckin());
		Assert.assertEquals(res.jsonPath().getString(object+"bookingdates.checkout"), bookingObj.bookingdates.getCheckout());
	}

}
