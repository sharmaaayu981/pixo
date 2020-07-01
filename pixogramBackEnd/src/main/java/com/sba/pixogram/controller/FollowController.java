package com.sba.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pixogram.entity.Follow;
import com.sba.pixogram.entity.Login;
import com.sba.pixogram.service.FollowService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FollowController {

	@Autowired
	FollowService followService;
	
	@GetMapping(path = "/follow/{userId}/{friendId}")
	public void Follow(@PathVariable Long userId,@PathVariable Long friendId) {
		Follow f=new Follow(userId,friendId,0);
		followService.follow(f);
	}

	@GetMapping(path = "/followers/{userId}")
	public List<Login> Followers(@PathVariable Long userId) {
		return followService.followers(userId);
	}
	
	@GetMapping(path = "/following/{userId}")
	public List<Login> Following(@PathVariable Long userId) {
		return followService.following(userId);
	}
	
	@DeleteMapping(path = "/follow/unfollow/{userId}/{friendId}")
	public void unfollow(@PathVariable Long userId,@PathVariable Long friendId) {
		followService.unFollow(userId, friendId);
	}
	
	@PutMapping(path="/follow/block/{userId}/{friendId}")
	public void block(@PathVariable Long userId,@PathVariable Long friendId) {
		followService.block(userId,friendId);
	}
	
	@GetMapping(path = "/follow/getblockedusers/{friendId}")
	public List<Login> getBlockedUsers(@PathVariable Long friendId) {
		return followService.getBlockedUsers(friendId);
	}
	
	@PutMapping(path="/follow/unblock/{userId}/{friendId}")
	public void unblock(@PathVariable Long userId,@PathVariable Long friendId) {
		followService.unblock(userId,friendId);
	}
}
