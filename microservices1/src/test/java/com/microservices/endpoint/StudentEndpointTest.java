package com.microservices.endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.microservices.MicroservicesApplication;
import com.microservices.service.StudentService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
//@WebMvcTest(StudentEndpoint.class)
@SpringBootTest
@ContextConfiguration(classes= {MicroservicesApplication.class})
@AutoConfigureMockMvc
public class StudentEndpointTest {

	@Autowired
	private MockMvc mvc;
	
	//@MockBean
	@Autowired
	StudentService studentService;

	@Test
	public void testEmployeedByID() throws Exception {

		String student = "{\"Firstname\":\"Jack\",\"subjects\":[{\"name\":\"Mathematics\"},{\"name\":\"Computer\"}],\"LastName\":\"Peterson\"}";		
		
		mvc.perform(get("/student/11")).andExpect(status().isOk()).andExpect(content().string(student));
	}
}
