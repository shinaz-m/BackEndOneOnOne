package com.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataRepositories.*;

import com.Interface.For_hr;
import com.nineleaps.OneonOne.ManHr;

@Transactional
@Service
public class MonthValueService implements For_hr {
	
	@Autowired
	private MnthStatus MnthStatus;
	
	
	 public ManHr val(ManHr x) {
		 return MnthStatus.save(x);
	 }
}
