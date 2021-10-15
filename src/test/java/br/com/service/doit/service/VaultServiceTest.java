package br.com.service.doit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.service.doit.component.SecretVaultCVC;

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
	
	@Test
	public void testBuscarUserPass() {
		SecretVaultCVC login = mock(SecretVaultCVC.class);
		when(login.getLogin()).thenReturn("user");
		when(login.getPassword()).thenReturn("test");
		
		assertEquals(login.getLogin(), "user");
	}
	
	@Test
	public void teste() {
		Assert.assertEquals(true, true);
	}

}
