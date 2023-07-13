package com.faith.demo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;
import com.faith.demo.service.ILoginService;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ILoginService loginServiceImplementation;
	
	@GetMapping("/user")
	public String loginPage(Model _model) {
		System.out.println("im here");
		User user = new User();
		_model.addAttribute("user", user);
		
		return "login";
	}
	
	@PostMapping("/login/mapUser")
	public String mapUser(@RequestParam("userName") String username,@RequestParam("passWord") String password, HttpSession session,Model _model,RedirectAttributes redirectAttributes) {

		User user = loginServiceImplementation.getRoleFromLogin(username, password);

		if(user==null) {	
			String errorMessage = "Invalid username or password"; // Customize the error message as needed
	        redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
	        return "redirect:/login/user";
		}
		else if(user.getRole().getRoleId() == 3) {
			int userId=user.getUserId();
			Doctor staffName=loginServiceImplementation.getStaffName(userId);
			session.setAttribute("username", username);
			session.setAttribute("roleId", user.getRole().getRoleId());
			_model.addAttribute("staffName",staffName.getDoctorName());
			_model.addAttribute("userId",userId);
			return "NewFile";
		}else if(user.getRole().getRoleId() ==2) {
			int userId=user.getUserId();
			Staff staff=loginServiceImplementation.getStaffNameStaff(userId);
			session.setAttribute("username", username);
			_model.addAttribute("staffName",staff.getStaffName());
			_model.addAttribute("userId",userId);
			return "welcoomeindex";
			
		}else if(user.getRole().getRoleId() ==1) {
			int userId=user.getUserId();
			Staff staff=loginServiceImplementation.getStaffNameStaff(userId);
			session.setAttribute("username", username);
			_model.addAttribute("staffName",staff.getStaffName());
			_model.addAttribute("userId",userId);
			return "welcomeadmin";
			
		}else if(user.getRole().getRoleId() ==4) {
			int userId=user.getUserId();
			Staff staff=loginServiceImplementation.getStaffNameStaff(userId);
			session.setAttribute("username", username);
			_model.addAttribute("staffName",staff.getStaffName());
			_model.addAttribute("userId",userId);
			return "checklog";
			
		}else if(user.getRole().getRoleId() ==5) {
			int userId=user.getUserId();
			Staff staff=loginServiceImplementation.getStaffNameStaff(userId);
			session.setAttribute("username", username);
			_model.addAttribute("staffName",staff.getStaffName());
			_model.addAttribute("userId",userId);
			return "welcometesting";
			
		}

		return "page-not-found";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.removeAttribute("username");
		session.removeAttribute("roleId");

		return "redirect:/login/user";
	}

}