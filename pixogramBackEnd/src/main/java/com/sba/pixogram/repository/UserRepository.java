package com.sba.pixogram.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sba.pixogram.entity.Login;
import com.sba.pixogram.entity.UploadPic;
import com.sba.pixogram.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value=" select f from User f where f.id !=?1")
	public List<User> getUsers(long id);
	
	@Query(value=" select f from User f where f.id=?1")
	public User userfindById( long fileId);

	
	@Query(value=" select f from User f")
	public List<Login> getUserslist();
	
	@Transactional
	@Modifying
	@Query(value=" update User u set u.password=:pass where u.id=:id")
	public void UpdateUser(@Param(value="id")Long id,@Param(value="pass") String pass);

	@Query(value="select u from User u where u.username=?1")
	public User findByUserName(String userName);
}
