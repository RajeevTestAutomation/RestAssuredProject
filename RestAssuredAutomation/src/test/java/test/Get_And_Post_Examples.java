package test;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Get_And_Post_Examples {
	
	//@Test
	public void TestGet() {
		
		baseURI = "https://reqres.in/api";
	    
	    given().
	    get("/users?page=2").
	    then().
	    statusCode(200).body("data[4].first_name", equalTo("George")).
	    body("data.first_name",hasItems("George","Rachel"));
		
		
	}

	@Test
	public void Post_Method() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("name", "Rajeev");
//		map.put("job","Engineer");
//		System.out.println(map);
//		
		JSONObject request = new JSONObject();
		
		request.put("name", "Rajeev");
		
		request.put("job","Engineer");
				
				
		System.out.println(request.toJSONString());
				
		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).log().all();
		
		
		
	}
	
	}


