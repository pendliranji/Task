package com.tyss.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.model.Employee;
import com.tyss.model.LoginPage;
import com.tyss.service.IEmployeeService;
import com.tyss.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	@Autowired
	private EmployeeValidator validator;

	@RequestMapping("/reg")
	public String register(ModelMap map) {
		Employee e = new Employee();
		map.addAttribute("employee", e);

		return "EmpRegister";
	}

	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee, Errors errors, ModelMap map) {

		validator.validate(employee, errors);
		if (!errors.hasErrors()) {
			
			 String hashtext="";

			 try { 
				  
		            MessageDigest md = MessageDigest.getInstance("MD5");  
		  
		            byte[] messageDigest = md.digest(employee.getEmpPwd().getBytes()); 
		  
		            // Convert byte array into signum representation 
		            BigInteger no = new BigInteger(1, messageDigest); 
		  
		            // Convert message digest into hex value 
		             hashtext = no.toString(16); 
		            while (hashtext.length() < 32) { 
		                hashtext = "0" + hashtext; 
		            } 
		            
		        }  
		  
		        // For specifying wrong message digest algorithms 
		        catch (NoSuchAlgorithmException e) { 
		            throw new RuntimeException(e); 
		        } 
			employee.setEmpPwd(hashtext);
			
			
			
			
			Integer id = service.saveEmp(employee);

			map.addAttribute("message", "Employee created with id :" + id);
			map.addAttribute("employee", new Employee());
		}

		return "EmpRegister";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id, ModelMap map, HttpServletRequest req) {
		String page = "";
		String msg = "";
		
			HttpSession session = req.getSession(false);
			
			if (session != null && session.getAttribute("mail") != null ) {

				service.deleteEmp(id);
				List<Employee> list = service.getAllEmployees();
				map.addAttribute("list", list);
				msg = "Employee deleted with id :" + id;
				map.addAttribute("message", msg);
				page = "EmpData"; 
			} else {
				map.addAttribute("login", new LoginPage());
				msg = "Please login and Delete Your Details ";
				map.addAttribute("deletes", msg);
				page = "Login";
			}

		
		return page;
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id, ModelMap map, HttpServletRequest req) {
		Employee eid = service.getoneemployee(id);
		map.addAttribute("employee", eid);
		String page = "";
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("mail") != null) {

			page = "EmpEdit";
		} else {
			map.addAttribute("login", new LoginPage());
			String msg = "Please login and Edit Your Details ";
			map.addAttribute("edits", msg);
			page = "Login";
		}

		return page;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("employee") Employee employee, Errors errors, ModelMap map,
			HttpServletRequest req) {
		HttpSession ses = req.getSession(false);

		service.updateEmp(employee, req);

		map.addAttribute("message", "Employee updated with id :" + employee.getEmpId());
		List<Employee> list = service.getAllEmployees();

		map.addAttribute("list", list);
		return "EmpData";
	}

	@RequestMapping("/log")
	public String goLogin(ModelMap map) {

		map.addAttribute("login", new LoginPage());

		return "Login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		/*HttpSession session = req.getSession(false);
		session.invalidate();*/

		return "Logout";
	}

	@RequestMapping("/view")
	public String getAll(ModelMap map, HttpServletRequest req) {
		String page = "";

		HttpSession session = req.getSession(false);
		List<Employee> list = service.getAllEmployees();
		map.addAttribute("list", list);
		if (session != null && session.getAttribute("mail") != null) {

			page = "EmpData";
		} else {
			map.addAttribute("login", new LoginPage());
			map.addAttribute("message", "Please Register & login to get into View page");
			page = "Login";
		}

		return page;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkLog(@ModelAttribute("login") LoginPage login, HttpServletRequest req, ModelMap map) {
		String page = "";
		
		

		 String hashtext="";

		 try { 
			  
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	  
	            byte[] messageDigest = md.digest(login.getUserPwd().getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	             hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            
	        }  
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
		
		
		
		boolean result = service.checking(login.getUserName(), hashtext);
	
		if (result == true) {
			Employee l = service.getEmpByEmail(login.getUserName());
			HttpSession session = req.getSession(true);
			session.setAttribute("name", l.getEmpName());
			session.setAttribute("mail", l.getEmpMail());
			session.setAttribute("desg", l.getEmpDesg());
			session.setAttribute("id", l.getEmpId());
			session.setAttribute("pwd", l.getEmpPwd());

			page = "Success";
		} else {
			page = "Failure";
		}
		return page;
	}

	
}
