package com.mbassignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbassignment.dao.ManagerDao;
import com.mbassignment.model.Manager;
import com.mbassignment.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Manager registerInformation(Manager manager, RedirectAttributes redirectAttributes, Model model) {
		manager.setPassword(encoder.encode(manager.getPassword()));
		return dao.registerInformation(manager);

	}

	@Override
	public Manager findByemail(String email) {
		
		return dao.findByEmail(email);
	}

}
