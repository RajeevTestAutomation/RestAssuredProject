package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUT_PATCH_DELETE {
	
	@Test
	public void Put_Method() {
				
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
		put("/users2").
		then().
		statusCode(200).log().all();
					
	}
	
	
	public class PUT_DELETE {
		
		@Test
		public void delete_Method() {
					
									
			
			baseURI = "https://reqres.in/api";
			given().			
			when().
			delete("/users/2").
			then().
			statusCode(204).log().all();
						
		}
	}
	
	}
