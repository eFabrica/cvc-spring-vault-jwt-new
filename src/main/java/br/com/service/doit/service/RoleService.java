package br.com.service.doit.service;

import br.com.service.doit.model.Role;

public interface RoleService {
    Role findByName(String name);
}
