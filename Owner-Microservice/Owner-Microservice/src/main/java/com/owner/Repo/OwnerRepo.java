package com.owner.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owner.Models.OwnerInfo;

public interface OwnerRepo extends MongoRepository<OwnerInfo, String> {

	OwnerInfo findByEmail(String email);
		
	
	
}
