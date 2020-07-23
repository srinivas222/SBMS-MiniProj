package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")

public class ContactEntity {
	@Id
	@Column(name = "CONTACT_ID")
	@SequenceGenerator(name = "CONTACT_SEQ_ID", allocationSize = 1, sequenceName = "CONTACT_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_SEQ_ID")	
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", insertable=true, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE", insertable=false, updatable=true)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
