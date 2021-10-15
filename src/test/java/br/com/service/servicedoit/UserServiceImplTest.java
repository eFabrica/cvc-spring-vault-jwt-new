package br.com.service.servicedoit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.service.doit.service.impl.UserServiceImpl;

@SpringBootTest(classes = UserServiceImpl.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserServiceImplTest {

	
	@Autowired
	UserServiceImpl userServiceImpl;
	
//	@Test
//	public void TestLoadUserByUsername() {
//		userServiceImpl.findAll();
//	}
	
	@Test
	public void teste() {
		Assert.assertEquals("teste", "teste");
	}
	
	

}
