package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Contact;
import com.example.demo.services.ContactService;

@Controller
public class ContactController { 
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = {"/", "addNewContact"})
	public String loadForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute(contact);
		return "Registration";
	}
	
	@PostMapping("registration")
	public String handleFormSubmit(@ModelAttribute("contact")Contact c,  RedirectAttributes redirectAttr) {
		boolean isSave = contactService.saveContact(c);
		if(isSave) {
			redirectAttr.addFlashAttribute("sucMsg", "Contact Saved");
		}else {
			redirectAttr.addFlashAttribute("errmsg", "Contact Save Failed");
		}
		return "redirect:/contactCreateSuccess";
	}
	
	@GetMapping(value="contactCreateSuccess")
	public String contactCreateSuccess(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact",contact);
		return "Registration";
	}
	
	@GetMapping("/editContact")
	public String handleEdit(@RequestParam("cid") Integer id,  Model model) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(model, contact);
		Contact contactById = contactService.getContactById(id);
		System.out.println("Controller method()"+ contactById.toString());
		model.addAttribute(contactById);
		return "Registration";
	}
	@GetMapping(value="/validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("email") String email) {
		String emailStatus = contactService.findByEmail(email);
		return emailStatus;
	}
	
	
	

}
