package package1;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.databind.ObjectMapper;



public class RestCall {

	public static void main(String[] args) {

		try {
//			putCallWithJavaObjectCore();
			putCallWithJavaObjectEnhanced();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void putCallWithJavaObjectCore() {
		

		// JSON body as java object using POJO class

		RequestPOJO requestPOJO = new RequestPOJO();
		requestPOJO.setId(1);
		requestPOJO.setFirstName("firstname");
		requestPOJO.setLastName("lname");
		requestPOJO.setEmail("1@gmail.com");
		requestPOJO.setProgramme("prog");
		String courses[] = { "ca", "cb" };
		requestPOJO.setCourses(courses);
		
		 Client client = ClientBuilder.newBuilder()
		          .register(JacksonFeature.class)
		          .build();
		
		Response response = client.target("http://localhost:8080")
				.path("student/1")
				.request()
				.put(Entity.entity(requestPOJO, MediaType.APPLICATION_JSON),Response.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			System.out.println("REST put request is successful");
		}

	}

	public static void putCallWithJavaObjectEnhanced() {

		try {


			// JSON body as java object using POJO class

			RequestPOJO requestPOJO = new RequestPOJO();
			requestPOJO.setId(1);
			requestPOJO.setFirstName("fname");
			requestPOJO.setLastName("lname");
			requestPOJO.setEmail("1111aaaa@gmail.com");
			requestPOJO.setProgramme("prog");
			String courses[] = { "ca", "cb" };
			requestPOJO.setCourses(courses);

			System.out.println("\n###### Request Java Object toString method ####### \n");
			System.out.println(requestPOJO.toString());

			System.out.println("\n#### Covert Java object to JSON to check  whether JSON is created correctly #### \n" );
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(requestPOJO);
			System.out.println(jsonInString);
		
			System.out.println("\n###### Formatted JSON request ####### \n");
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPOJO));
			
			

			Client client = ClientBuilder.newBuilder()
			          .register(JacksonFeature.class)
			          .build();
			
			Response response = client.target("http://localhost:8080")
					.path("student/1")
					.request()
					.put(Entity.entity(requestPOJO, MediaType.APPLICATION_JSON),Response.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("\n####### Output from Server ....  ####### \n");
			
			System.out.println("\n####### Receive JSON Response and convert into Java Object ####### \n");
			ResponsePOJO responsePOJO = response.readEntity(ResponsePOJO.class);
			System.out.println("\n###### Response Java Object toString method ####### \n");
			System.out.println(responsePOJO.toString());
			
			
			 System.out.println("  ####### Covert Java object to JSON to check whether JSON is created correctly ####### \n");
			ObjectMapper mapper1 = new ObjectMapper();
			String jsonInString2 = mapper1.writeValueAsString(responsePOJO);
			System.out.println(jsonInString2);
			

			System.out.println("\n###### Formatted JSON response ####### \n");
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responsePOJO));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
