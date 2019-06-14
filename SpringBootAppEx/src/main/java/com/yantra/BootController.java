package com.yantra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BootController {
	
	@RequestMapping("/login")
	public String doDataExist()
	{
		return "User :Hi ranji to new Boot";
	}
	

}
