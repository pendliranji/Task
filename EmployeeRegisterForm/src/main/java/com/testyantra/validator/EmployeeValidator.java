package com.testyantra.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.testyantra.model.Employee;
import com.testyantra.service.IEmployeeService;
@Component
public class EmployeeValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	@Autowired
	private IEmployeeService service;
	@Override
	public void validate(Object target, Errors errors) {

		Employee e=(Employee)target;

		if(!Pattern.compile("[a-zA-Z]{1,8}").matcher(e.getEmpDesg()).matches())
		{
			errors.rejectValue("empDesg", null, "please enter DESG");

		}

		if(!Pattern.compile("[a-zA-Z]{1,8}").matcher(e.getEmpName()).matches())
		{
			errors.rejectValue("empName", null, "please enter Name");

		}

		if(!Pattern.compile("[a-zA-Z0-9]{1,8}").matcher(e.getEmpPwd()).matches())
		{
			errors.rejectValue("empPwd", null, "please enter pwd");

		}
		
		if(!Pattern.compile("[A-Za-z\\.\\_\\+]+[0-9]*[\\@][a-zA-Z]+[\\.][a-zA-Z]+").matcher(e.getEmpMail()).matches())
		{
			errors.rejectValue("empMail", null, "please enter email");

		}else if(service.isEmailExists(e.getEmpMail()))
		{
			errors.rejectValue("empMail", null, "This Mail alread exist..Please try new One");
		}
		

	}

}
