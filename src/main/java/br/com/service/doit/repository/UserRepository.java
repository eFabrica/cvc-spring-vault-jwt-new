package br.com.service.doit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.service.doit.model.Users;
import br.com.service.doit.model.UserDto;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
	void save(UserDto user);
}