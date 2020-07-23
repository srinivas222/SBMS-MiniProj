package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactEntity;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity isSave=contactRepo.save(entity);
		return isSave.getContactId() != 0;
	}

	@Override
	public Contact getContactById(int id) {
		System.out.println("Service method()"+ id);
		Optional<ContactEntity> findById = contactRepo.findById(id);
		System.out.println("**********"+ findById.toString());
		Contact contact = new Contact();
		if(findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
			BeanUtils.copyProperties(contactEntity, contact);
		}
		return contact;
		
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> listContactEntity = contactRepo.findAll();
		List<Contact> listContact = new ArrayList<Contact>();
		for(ContactEntity entity : listContactEntity) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			listContact.add(contact);
		}
		return listContact;
	}


	@Override
	public boolean deleteContact(int id) {
		contactRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findByEmail(String email) {
		ContactEntity entity = contactRepo.findByContactEmail(email);
		if(null!=entity) {
			return "Duplicate";
		}
		return "Unique";
	}

}
