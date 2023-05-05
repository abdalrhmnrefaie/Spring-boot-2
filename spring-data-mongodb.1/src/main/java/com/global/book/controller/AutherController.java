package com.global.book.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.documont.Auther;
import com.global.book.service.AutherService;
@Validated
@RestController
@RequestMapping("/auther")
public class AutherController {
	
	@Autowired
	private AutherService autherService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		
		return ResponseEntity.ok( autherService.findById(id));
	}
	
	
	@GetMapping("/")
	public  ResponseEntity<?>  findAll() {
		
		return ResponseEntity.ok( autherService.findAll());
	}
	
	

	@PostMapping("/")
	public  ResponseEntity<?>  insert(@RequestBody @Valid Auther entity) {
	
		return ResponseEntity.ok( autherService.insert(entity));
	}
	

	@PutMapping("/")
	public  ResponseEntity<?>  update(@RequestBody @Valid Auther entity) {
		return ResponseEntity.ok( autherService.update(entity));
	}
	
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<?>  deleteById(@PathVariable String id) {
		autherService.deleteById(id);
		return ResponseEntity.ok(null);
		
	}
	
	
	@PutMapping("/custom")
	public  ResponseEntity<?> updateEmail(@RequestParam @Email String email,@RequestParam String name,@RequestParam String phone) {
		autherService.updateEmail(email, name, phone);
		return  ResponseEntity.ok(null);
	}
	
	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<?>findAutherByEmail(@PathVariable @Email String email) {
		return ResponseEntity.ok( autherService.findAutherByEmail(email));
	}
	
	
	
	
	
	
	
	
	
	
	

}
