package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")
@SequenceGenerator(name = "CONTACT_SEQ_ID", allocationSize = 1, sequenceName = "CONTACT_ID_SEQ")
public class ContactEntity {
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_SEQ_ID")
	private int contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	

}
