package com.programmer.gate.service;

import java.util.List;

import com.programmer.gate.domain.Users;
import com.programmer.gate.domain.Role;

public interface UsersService {
	 Users getUserById (Integer id);
	 void seveUser(Users user);
	 void updateUser(Integer id, String login,String password, String email, Role role);
	 void deleteUser(Integer id);
	 List<Users> findAll();	 
	 Users findByLogin(String login);
	 Users findByEmail (String email);
}
