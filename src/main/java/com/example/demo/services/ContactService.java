package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	
	public Contact getContactById(int id);
	
	public List<Contact> getAllContacts();
	
	public boolean updateContact(Contact c);
	
	public boolean deleteContact(int id);

}
