package com.reimbursement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reimbursement.models.ERole;
import com.reimbursement.models.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);

}
