package com.sba.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.pixogram.entity.Follow;
import com.sba.pixogram.entity.Login;
import com.sba.pixogram.repository.FollowRepository;
import com.sba.pixogram.repository.LoginRepository;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepository followRepository;
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public Follow follow(Follow follow) {
		return followRepository.save(follow);
	}

	@Override
	public void unFollow(Long uid,Long Fid) {
		followRepository.deleteUnfollowById(uid,Fid);
		return;
	}

	@Override
	public List<Login>followers(Long userId) {
		return loginRepository.Followers(userId);
	}
	
	@Override
	public List<Login>following(Long userId) {
		return loginRepository.Following(userId);
	}
	
	@Override
	public void block(Long userId, Long friendId) {
		followRepository.Block(userId,friendId);
	}

	@Override
	public List<Login> getBlockedUsers(Long fid) {	
		return loginRepository.GetblockedUser( fid);
	}
	
	@Override
	public void unblock(Long userId, Long friendId) {
		followRepository.unBlock(userId,friendId);
	}

}
