package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Contact;
import com.example.demo.services.ContactService;

@Controller
public class ViewContactController {
	@Autowired
	private ContactService contactService;
	@GetMapping("/viewAllContacts")
	public String viewContact(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContact";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer id, Model model) {
		contactService.deleteContact(id);
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContact";
	}

}
