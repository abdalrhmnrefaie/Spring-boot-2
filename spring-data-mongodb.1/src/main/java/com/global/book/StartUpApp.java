package com.global.book;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.global.book.documont.Auther;
import com.global.book.repository.AutherRepository;

@Component
@EnableMongoRepositories
public class StartUpApp implements CommandLineRunner{

	@Autowired
	private AutherRepository autherRepository;
	@Override
	public void run(String... args) throws Exception {
		
		if (autherRepository.findAll().isEmpty()) {
		Auther  auther=new Auther();
		auther.setName("Abdalrhmn");
		auther.setEmail("abdalrhmn@gmail.com");
		auther.setPhone("01111111111111");
		
		Auther  auther1=new Auther();
		auther1.setName("Mohamed");
		auther1.setEmail("Mohamed@gmail.com");
		auther1.setPhone("022222222222");
		
		Auther  auther2=new Auther();
		auther2.setName("Hossam");
		auther2.setEmail("Hossam@gmail.com");
		auther2.setPhone("0333333333333");
		autherRepository.insert(Arrays.asList(auther,auther1,auther2));
		
	}
	}
	
}
