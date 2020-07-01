package com.sba.pixogram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "follow")

public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "userId")
	private long user_id;
	@Column(name = "friendId")
	private long friend_id;
	
	@Column(name="block")
	private long block;
	
	
	public long getBlock() {
		return block;
	}
	public void setBlock(long block) {


		this.block = block;
	}
	public long getId() {

		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(long friend_id) {
		this.friend_id = friend_id;
	}
	public Follow(long user_id, long friend_id, long block) {
		super();
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.block=block;
	}
	public Follow() {
		super();
		
	}

	
}
