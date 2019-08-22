package com.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.Services.EmployeeDataServices;
import com.Services.MonthValueService;
import com.nineleaps.OneonOne.Hr__view;
@Transactional
@RestController
@CrossOrigin
public class Hr_controller {
	
	@Autowired
	private MonthValueService mvs ;
	@RequestMapping(path="/add_val",method=RequestMethod.POST) 
	public Hr__view AddMthVal(@RequestBody Hr__view x)
	{
		return mvs.val(x);
	}
}
