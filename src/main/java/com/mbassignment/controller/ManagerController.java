package com.mbassignment.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbassignment.model.Manager;
import com.mbassignment.service.ManagerService;

@Controller
public class ManagerController {

	private static Logger log = Logger.getLogger(Manager.class.getName());

	@Autowired
	private ManagerService service;

	@GetMapping("/signin")
	public String signIn() {

		return "login";

	}

	@GetMapping("/signup")
	public String managerSignUpPage(Manager managr, Model model) {

		return "manager/add-manager";

	}

	@PostMapping("/storeInformation")
	public String storeRecored(@Valid @ModelAttribute("manager") Manager manager, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		manager.setRole("ROLE_MANAGER");
		Manager checkEmail = service.findByemail(manager.getEmail());
		if (checkEmail != null) {

			model.addAttribute("email", "Email already Exits");
			return "manager/add-manager";
		}
		if (result.hasFieldErrors()) {
			model.addAttribute("manager", manager);
			return "manager/add-manager";

		}
		service.registerInformation(manager, redirectAttributes, model);
		redirectAttributes.addFlashAttribute("message", "Data Suceessfully Submited");
		return "redirect:/signup/";

	}

}
