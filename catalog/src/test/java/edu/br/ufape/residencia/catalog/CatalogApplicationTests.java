package edu.br.ufape.residencia.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = CatalogApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
class CatalogApplicationTests {
	@LocalServerPort
    int randomServerPort;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getCategoryById() {
	    // RestTemplate restTemplate = new RestTemplate();  
	    // final String baseUrl = "http://localhost:" + randomServerPort + "/categoria/" + 1;
	    // ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);
	    // assertEquals(result.getStatusCodeValue(), 200);
	    // assertEquals(true, result.getBody().contains("name"));
	}
	
	@Test
	void getCategoryNotFound() {
		
	    // RestTemplate restTemplate = new RestTemplate();  
	    // final String baseUrl = "http://localhost:" + randomServerPort + "/categoria/" + 1000;
	    // try {
	    // 	ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);
	    // } catch (HttpClientErrorException err) {
	    // 	assertEquals(err.getRawStatusCode(), 404);
	    // }
	}

}
