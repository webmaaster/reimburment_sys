package com.reimbursement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.models.Request;
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}
