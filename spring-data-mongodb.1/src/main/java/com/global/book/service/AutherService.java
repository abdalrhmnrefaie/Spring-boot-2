package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.documont.Auther;
import com.global.book.repository.AutherRepository;
import com.global.book.repository.CustomAutherRepository;

@Service
public class AutherService {
	
	@Autowired
	private AutherRepository autherRepository;
	@Autowired
	private CustomAutherRepository  customAutherRepository;
	
	public Auther findById(String id) {
		return autherRepository.findById(id).get();
	}
	
	public List<Auther> findAll() {

		return autherRepository.findAll();
	}

	public Auther insert(Auther entity) {
		if (entity.getId() != null) {
			throw new RuntimeException();
		}

		return autherRepository.insert(entity);
	}

	public List<Auther> insertAll(List<Auther> entity) {

		return autherRepository.saveAll(entity);
	}

	public Auther update(Auther entity) {
		
		Auther auther=findById(entity.getId());
		auther.setName(entity.getName());
		auther.setEmail(entity.getEmail());
		auther.setPhone(entity.getPhone());
		
		return autherRepository.save(auther);
	}

	public void deleteById(String id) {

		autherRepository.deleteById(id);
	}
	
	public void updateEmail(String email, String name,String phone) {
		customAutherRepository.updateEmail(email, name, phone);
	}
	
	
	
	
	
	public Auther findAutherByEmail(String email) {
		return autherRepository.findAutherByEmail(email);
	}
	
	
	
	
	
	
	
	
	

}
