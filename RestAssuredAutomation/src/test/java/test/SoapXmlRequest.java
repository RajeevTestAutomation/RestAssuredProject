package test;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

import static org.hamcrest.Matchers.equalTo;


public class SoapXmlRequest {
	FileInputStream fileinput_stream;
	String requestbody;
	@Test
	public void validateSoapXML () {
		
		File file = new File("./SoapRequest/body.xml");
		
		if(file.exists())
			
			System.out.println("<<<file exist>>>>");
		
		
		try {
			fileinput_stream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			requestbody = IOUtils.toString(fileinput_stream, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
		}
						
		baseURI = "http://www.dneonline.com/";
		
		given().
		contentType("text/xml").
		body(requestbody).
		when().post("/calculator.asmx").
		then().statusCode(200).log().all().
		and().body("//*:AddResult.text()",equalTo("5"));
					
		
	}

}
