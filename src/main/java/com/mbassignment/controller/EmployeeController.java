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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbassignment.constant.ConstantsURL;
import com.mbassignment.model.Employee;
import com.mbassignment.model.Manager;
import com.mbassignment.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static Logger log = Logger.getLogger(Manager.class.getName());

	@Autowired
	private EmployeeService service;

	int currentPage = 1;

	@PostMapping("/addEmployeeRecored")
	public String recoredEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasFieldErrors()) {
			model.addAttribute("employee", employee);
			service.common(currentPage, service, model);
			return ConstantsURL.common;

		}
		service.saveRecored(employee);
		redirectAttributes.addFlashAttribute("message", "Data Suceessfully Submited");
		return ConstantsURL.redirectEmployeeHome + currentPage;

	}

	@GetMapping("/home")
	public String fetchEmployees(@RequestParam("id") int startPage, Model model, Employee employee) {

		service.common(startPage, service, model);
		currentPage = startPage;
		return ConstantsURL.allEmployeeRecored;

	}

	@GetMapping("/delete")
	public String deleteEmploye(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
		service.deleteEmploye(id);
		redirectAttributes.addFlashAttribute("message", "Delete SuceessFully");
		return ConstantsURL.redirectEmployeeHome + currentPage;

	}

	@GetMapping("/update")
	public String getEmployeeById(@RequestParam("id") int id, Model model) {

		Employee employee = service.findEmployeeById(id);
		log.info("Employeee :  " + employee);
		model.addAttribute("employee", employee);
		return ConstantsURL.updateEmployee;

	}

	@PostMapping("/updateInformation")
	public String updateInformation(@Valid Employee employee, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttribute) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("employee", employee);
			return ConstantsURL.updateEmployee;
		}
		service.updateEmployeeForm(employee);
		redirectAttribute.addFlashAttribute("message", "SuceessFully Updated");
		return ConstantsURL.redirectEmployeeHome + currentPage;

	}

}
