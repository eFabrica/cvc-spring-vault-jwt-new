package br.com.service.doit.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.service.doit.model.Role;
import br.com.service.doit.model.Users;
import br.com.service.doit.repository.UserRepository;
import br.com.service.doit.model.UserDto;
import br.com.service.doit.service.RoleService;
import br.com.service.doit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		if (user.getPassword().equals("abc123")) {
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(Users user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	public List<Users> findAll() {
		List<Users> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Users findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Users save(UserDto user) {

		Users nUser = user.getUserFromDto();
		nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

		Role role = roleService.findByName("USER");
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);

		if (nUser.getProfile().equals("ADMIN")) {
			role = roleService.findByName("ADMIN");
			roleSet.add(role);
		}

		if (nUser.getProfile().equals("MANAGER")) {
			role = roleService.findByName("MANAGER");
			roleSet.add(role);
		}

		if (nUser.getProfile().equals("SELLER")) {
			role = roleService.findByName("SELLER");
			roleSet.add(role);
		}

		nUser.setRoles(roleSet);
		return userDao.save(nUser);
	}
}
