package br.com.service.servicedoit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.service.doit.service.VaultService;

@SpringBootTest(classes = VaultService.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class VaultServiceTest {
	
	@Autowired
	private VaultService vaultServiceImpl;
		
	@Test
	public void testConsultarUser() {
	String login =	vaultServiceImpl.buscaUser().getLogin();
	String password =vaultServiceImpl.buscaUser().getPassword();
		
		assertEquals(login, "cvcuser");
		assertEquals(password, "cvcpwd12");
	}
	
	@Ignore
	public void testBuscarUserPass() {
	   	vaultServiceImpl.consultarUserPass("cvcuser","cvcpwd12");
	   	assertEquals(vaultServiceImpl, true);
	}
	
	@Test
	public void teste() {
		Assert.assertEquals(true, true);
	}
	

}
