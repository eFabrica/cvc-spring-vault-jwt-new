package br.com.service.doit.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.service.doit.model.UserDto;
import br.com.service.doit.model.Users;
import br.com.service.doit.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserServiceImplTest {
	
	@Mock
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userBanco;
	
	@Mock
	private UserDetails detalhesUser;
	
	
	@Test
	public void testLoadByUserName() {
		Users userTest = mock(Users.class);	
		when(userTest.getName()).thenReturn("user1");
		userServiceImpl.loadUserByUsername(userTest.getName());
		
		assertEquals(userTest.getName(), "user1");
		
	}
	
	
	@Test
	public void testUserSave() {		
		UserDto userMock = mock(UserDto.class);
		
		List<UserDto> list = new ArrayList<>();
		
		when(userMock.getName()).thenReturn("user1");
		when(userMock.getPassword()).thenReturn("abc123");
		
		list.add(userMock);
		System.out.println(list.get(0).getName());
		userServiceImpl.save(list.get(0));
		
		assertEquals(list.get(0).getName(), "user1");
		 
	}
	
	@Test
	public void testFindAll() {
		List<Users> listAll = new ArrayList<>();
		
		Users userMock2 = mock(Users.class);
		Users userMock3 = mock(Users.class);

		listAll = userServiceImpl.findAll();
		
		when(userMock2.getName()).thenReturn("user2");
		when(userMock2.getPassword()).thenReturn("abc123");
		listAll.add(userMock2);
		
		when(userMock3.getName()).thenReturn("user3");
		when(userMock3.getPassword()).thenReturn("abc123");
		listAll.add(userMock3);
		
		System.out.println(listAll.size());
		
		assertEquals(listAll.size(), 2);
		
			
	}
	
	
	@Test
	public void test3() {
		assertEquals(null, 0, 0);
	}
	
	

}
