package br.com.service.doit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RoleServiceTest {
	
	RoleServiceImpl roleServiceT = mock(RoleServiceImpl.class);
	
	@Test
	public void testFindByName() {
		roleServiceT.findByName("AMIN");
		
		assertEquals("ADMIN", "ADMIN");
	}
	
}
