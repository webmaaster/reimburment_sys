/**
 * 
 */
package com.reimbursement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * @author Bab 
 *
 */
@Entity
@Table(name = "reimbursements")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String title;

	@Column(name = "reason")
	private String reason;
	
	@Column(name = "amount")
	private int amount ;

	@Column(name = "status")
	private boolean status;
	
	@JsonBackReference(value = "user")
	@ManyToOne
	private User user;

	

	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(Long id, String title, String reason, int amount, boolean status, User user) {
		super();
		this.id = id;
		this.title = title;
		this.reason = reason;
		this.amount = amount;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	

}
