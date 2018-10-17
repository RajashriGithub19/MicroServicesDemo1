package com.microservices.endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.microservices.MicroservicesApplication;
import com.microservices.service.StudentService;

//https://www.baeldung.com/integration-testing-in-spring
//https://www.baeldung.com/spring-boot-testing

@WebAppConfiguration
@RunWith(SpringRunner.class)
// @WebMvcTest(StudentEndpoint.class)
// @SpringBootTest
@ContextConfiguration(classes = { MicroservicesApplication.class })
// @AutoConfigureMockMvc
public class StudentEndpointTest {

	@Autowired
	private WebApplicationContext wac;

	// @Autowired
	private MockMvc mvc;

	@Before
	public void setup() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	// @MockBean
	@Autowired
	StudentService studentService;

	@Test
	public void testEmployeedByID() throws Exception {

		String student = "{\"Firstname\":\"Jack\",\"subjects\":[{\"name\":\"Mathematics\"},{\"name\":\"Computer\"}],\"LastName\":\"Peterson\"}";

		mvc.perform(get("/student/{studentId}","11")).andExpect(status().isOk()).andExpect(content().string(student));
	}
}
