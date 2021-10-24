package com.mbassignment.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbassignment.model.Manager;

public interface ManagerService {

	public Manager registerInformation(Manager manager, RedirectAttributes redirectAttributes,Model model);

	public Manager findByemail(String email);

}
