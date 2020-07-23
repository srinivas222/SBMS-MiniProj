package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable>{
	public ContactEntity findByContactEmail(String email);
}
