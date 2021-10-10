package br.com.service.doit.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Role {
	ADMIN, MANAGER, SELLER, USER;

	// Forms role hierarchy like ADMIN > MANAGER > SELLER > USER

	public static String getRoleHierarchy() {
		return Arrays.stream(Role.values()).map(Role::getRole).collect(Collectors.joining(" > "));
	}

	public String getRole() {
		return "ROLE_" + name();
	}
}
