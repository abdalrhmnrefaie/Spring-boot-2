package com.global.book.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.documont.Auther;

@Repository
public interface AutherRepository extends MongoRepository<Auther, String>{
	 
	@Query(value =  "{email :'?0'}",fields = "{'email' :1}")
	Auther findAutherByEmail(String email);
}
