package com.sba.pixogram.service;

import java.util.List;

import com.sba.pixogram.entity.Follow;
import com.sba.pixogram.entity.Login;

public interface FollowService {

	public Follow follow(Follow follow);

	public List<Login> followers(Long userId);

	public List<Login> following(Long userId);

	public void unFollow(Long uid,Long fid);
	
	public void block(Long userId, Long friendId);

	public List<Login> getBlockedUsers(Long friendId);

	public void unblock(Long userId, Long friendId);
}
