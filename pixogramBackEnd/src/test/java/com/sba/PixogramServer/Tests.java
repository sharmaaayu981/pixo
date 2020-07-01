package com.sba.PixogramServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import junit.framework.Assert;


public class Tests extends PixogramServerApplicationTests{

	/*
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testUser() throws Exception,URISyntaxException {
//		mockMvc.perform(get("/user/1")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.firstname").value("dileep")).andExpect(jsonPath("$.lastname").value("garimella"))
//				
//				.andExpect(jsonPath("$.username").value("jagruthigarimella19@gmail.com"))
//				.andExpect(jsonPath("$.password").value("Dileep")).andExpect(jsonPath("$.email").value("dileepgarimella6055@gmail.com"))
//				.andExpect(jsonPath("$.follow").value(null)).andExpect(jsonPath("$.folllowOf").value(null))
//		;

		
		 RestTemplate restTemplate = new RestTemplate();
	     
		    final String baseUrl = "http://localhost:" + 8003 + "/employees";
		    URI uri = new URI(baseUrl);
		 
		    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		     
		    //Verify request succeed
		    Assert.assertEquals(200, result.getStatusCodeValue());
		    Assert.assertEquals(true, result.getBody().contains("employeeList"));
} */
}

