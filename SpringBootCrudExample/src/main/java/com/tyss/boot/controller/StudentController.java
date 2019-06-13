package com.tyss.boot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.boot.model.Student;
import com.tyss.boot.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService ser;

	@RequestMapping("/register")
	public String register(Map<String, Object> map) {
		map.put("student", new Student());
		return "Register";
	}

	@RequestMapping(value = "/insert")
	public String insert_stu(@ModelAttribute("student") Student student, Map<String, Object> map) {
		ser.save(student);
		map.put("ins", "inserted :");
		return "Login";
	}

	@RequestMapping(value = "/delete")
	public String delete_stu(@RequestParam("id") int id, Map<String, Object> map, HttpServletRequest req) {
		String msg = "";
		HttpSession ses = req.getSession(false);
		String page = "";
		try {
			if (ses.getAttribute("name") == null || ses == null) {
				map.put("student", new Student());
				page = "Login";
			} else {
				ser.delete(id);
				msg = "deleted with id:" + id;
				map.put("del", msg);
				List<Student> list = ser.getAllStudents();

				map.put("list", list);
				page = "Data";
			}
		} catch (Exception e) {
			msg = "Already deleted of id :" + id;
		}

		return page;
	}

	@RequestMapping("/view")
	public String getAll(Map<String, Object> map, HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		String page = "";
		if (ses.getAttribute("name") == null || ses == null) {
			map.put("student", new Student());
			page = "Login";
		} else {
			List<Student> list = ser.getAllStudents();

			map.put("list", list);
			page = "Data";
		}
		return page;
	}

	@RequestMapping("/edit")
	public String edit_stu(@RequestParam("id") Integer id, Map<String, Object> map) {
		Student student = ser.getOneStudent(id);
		map.put("student", student);

		return "Edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update_stu(@ModelAttribute("student") Student student, Map<String, Object> map,
			HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		String page = "";
		if (ses.getAttribute("name") == null || ses == null) {
			map.put("student", new Student());
			page = "Login";
		} else {

			ser.update(student);
			List<Student> list = ser.getAllStudents();
			map.put("upd", "student record updated with id :" + student.getStu_Id());
			map.put("list", list);
			page = "Data";
		}
		return page;
	}

	@RequestMapping("/login")
	public String login_stu(Map<String, Object> map) {
		map.put("student", new Student());

		return "Login";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check_login(@ModelAttribute("student") Student student, Map<String, Object> map,
			HttpServletRequest req) {
		String page="";
			int count= ser.count(student.getStu_Id(),student.getStu_Pass());
			HttpSession ses = req.getSession();
			if (count==1) {
				ses.setAttribute("name", student.getStu_Id());
				page = "Success";
			} else {
				map.put("again", "please login again your credentials are incorrect");
				page = "Login";
			
		}
		return page;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession(false).invalidate();
		return "Logout";
	}

}
