package com.sba.pixogram.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sba.pixogram.entity.UploadPic;

public interface UploadRepository extends CrudRepository<UploadPic, Long> {

	
	UploadPic save(UploadPic dbFile);

	@Query(value=" select f from UploadPic f where f.userId=?1")
	public ArrayList<UploadPic> findById( long fileId);

}
