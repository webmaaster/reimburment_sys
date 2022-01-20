package com.reimbursement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.exception.ResourceNotFoundException;
import com.reimbursement.models.Reimbursement;
import com.reimbursement.repositories.ReimbursementRepository;
import com.reimbursement.repositories.UserRepository;


@RestController
@RequestMapping(value = "/api")
public class RiembusementController {
	
	

	@Autowired
	private ReimbursementRepository reimbursementRepository;
	@Autowired
	private UserRepository userRepository;
	
	/////Display all Reibursements
	/*@GetMapping("/reimbursements1")
	public Page<Reimbursement> getAllReimbursements1( Pageable pageable) {
		return reimbursementRepository.findAll( pageable);

	}*/
	
	
	//// To display  all Reimbursements  
	@GetMapping("/reimbursements")
	public List<Reimbursement> getAllReimbursements(){
		return reimbursementRepository.findAll();
		
	}
	
/*
	@GetMapping("/users/{reimbursementId}/reimbursements")
	public Page<Reimbursement> getAllReimbursementsByUserId(@PathVariable(value = "userId") Long userId,
			Pageable pageable) {
		return reimbursementRepository.findByUserId(userId, pageable);
	}*/
/*
	@PostMapping("/users/{userId}/reimbursements")
	public Reimbursement createReimbursement(@PathVariable(value = "userId") Long userId,
			@Valid @RequestBody Reimbursement reimbursement) {
		return userRepository.findById(userId).map(user -> {
			reimbursement.setUser(user);

			return reimbursementRepository.save(reimbursement);
		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
	}*/
	
	/////////Create Reimbursement
	@PostMapping("/reimbursements")
	public Reimbursement createReimbursement(@Valid @RequestBody Reimbursement reimbursement) {
		return reimbursementRepository.save(reimbursement);
		
	}

	@PutMapping("/user/{userId}/reimbursements/{reimbursementId}")
	public Reimbursement updateReimbursement(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "reimbursementId") Long reimbursementId,
			@Valid @RequestBody Reimbursement reimbursementRequest) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("userId " + userId + " not found");
		}

		return reimbursementRepository.findById(reimbursementId).map(reimbursement -> {

			reimbursement.setTitle(reimbursement.getTitle());
			reimbursement.setReason(reimbursement.getReason());
			reimbursement.setAmount(reimbursement.getAmount());

			return reimbursementRepository.save(reimbursement);
		}).orElseThrow(() -> new ResourceNotFoundException("reimbursementId " + reimbursementId + "not found"));
	}

	@DeleteMapping("/users/{userId}/reimbursements/{reimbursementId}")
	public ResponseEntity<?> deleteReimbursement(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "reimbursementId") Long reimbursementId) {
		return reimbursementRepository.findByIdAndUserId(reimbursementId, userId).map(comment -> {
			reimbursementRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Reimbursement not found with id " + reimbursementId + " and userId " + userId));
	}
}
