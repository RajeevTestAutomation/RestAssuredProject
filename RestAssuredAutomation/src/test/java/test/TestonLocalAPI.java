package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestonLocalAPI {
	
//	@Test
	public void get() {
		
		baseURI="http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();
						
	}
	//@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName","Thomas");
		request.put("lastName","Edison");
		request.put("subjectID","1");
		
		baseURI="http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);
		
		
		
	}

//	@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName","Albert");
		request.put("lastName","Einstein");
		request.put("subjectID","1");
		
		baseURI="http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/10")
		.then()
		.statusCode(200);
	}
	
		
	//	@Test
		public void patch() {
			
			JSONObject request = new JSONObject();
			
			request.put("lastName","Doe");
			
			
			baseURI="http://localhost:3000";
			
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.patch("/users/10")
			.then()
			.statusCode(200);
			
				
	}
		
		@Test
		public void delete() {
			
			JSONObject request = new JSONObject();
			
					
			
			baseURI="http://localhost:3000";
			
			when().delete("/users/9").then().statusCode(200);
			
			
		
				
	}

	
}
