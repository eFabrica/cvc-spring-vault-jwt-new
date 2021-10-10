package br.com.service.doit.service;

import java.util.List;

import br.com.service.doit.model.Users;
import br.com.service.doit.model.UserDto;

public interface UserService {
    Users save(UserDto user);
    List<Users> findAll();
    Users findOne(String username);
}
