package com.jen.springsecurity.demo.dao;

import com.jen.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
