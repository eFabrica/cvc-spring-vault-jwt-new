package br.com.service.servicedoit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.service.doit.model.Users;
import br.com.service.doit.service.VaultService;

@SpringBootTest(classes = VaultService.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class VaultServiceTest {
	
	@Autowired
	private VaultService vaultServiceImpl;
	
	@Test
	public void testConsultarUser() {
		vaultServiceImpl.buscaUser().getLogin();
		vaultServiceImpl.buscaUser().getPassword();
	}
	
//	@Test
//	public void testBuscarUserPass() {
//		vaultServiceImpl.consultarUserPass("user1","abc123");
//	}
	
	@Test
	public void teste() {
		Assert.assertEquals(true, true);
	}
	

}
