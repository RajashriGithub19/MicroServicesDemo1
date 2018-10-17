package com.microservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//integration testing
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes= {MicroservicesApplication.class})
public class MicroservicesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
