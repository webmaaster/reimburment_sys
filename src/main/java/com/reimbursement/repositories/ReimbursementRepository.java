package com.reimbursement.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.models.Reimbursement;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Long> {

	Page<Reimbursement> findByUserId(Long userId, Pageable pageable);

	//Page<Reimbursement> findByIdAndUserId(Long reimbursementId, Long userId);
	Optional<Reimbursement> findByIdAndUserId(Long id, Long userId);

	
	
}
