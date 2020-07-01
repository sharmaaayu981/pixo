package com.sba.PixogramServer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import com.sba.pixogram.controller.UserController;
import com.sba.pixogram.entity.User;
import com.sba.pixogram.service.UserService;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class PixogramControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	User mockuser = new User(1,"rahul","d","rahul_d","123456","r@e.c");

	//String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				userService.getUserById(Mockito.anyLong())).thenReturn(mockuser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/user/1").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentLength());
	
		String expected = "{\"id\":1,\"firstname\":\"Rahul\",\"lastname\":\"d\",\"username\":\"rahul_d\",\"password\":\"123456\",\"email\":\"r@e.c\"}";


	}
}
