package com.sba.pixogram.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sba.pixogram.entity.Follow;

public interface FollowRepository extends CrudRepository<Follow, Long>{
	
	@Transactional
	@Modifying
	@Query(value=" delete Follow f  where f.user_id=:uid and f.friend_id=:fid")
	void deleteUnfollowById(@Param(value="uid")Long uid, @Param(value="fid")Long fid);

	@Transactional
	@Modifying
	@Query(value="update Follow  f set f.block=1 where f.friend_id=:uid and f.user_id=:fid")
	void Block(@Param(value="uid")Long uid, @Param(value="fid")Long fid);

	@Transactional
	@Modifying
	@Query(value="update Follow  f set f.block=0 where f.friend_id=:uid and f.user_id=:fid")
	void unBlock(@Param(value="uid")Long uid, @Param(value="fid")Long fid);

}
