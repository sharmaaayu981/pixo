package com.sba.pixogram.service;

import java.util.List;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.User;

public interface UserService {

	public List<Login> getUsers(Long id);
	
	public User createUser(User user);
	
	public User getUserById(Long userId);

	public List<Login> getUsersList(); 
	
	public Login createlogin(Login log);

	public void UpdateUser(Long id,String pass);
	public void deleteUser(Long userId);
	public User findByUserName(String userName);


}
