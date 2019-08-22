package com.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataRepositories.*;

import com.Interface.For_hr;
import com.nineleaps.OneonOne.Hr__view;

@Transactional
@Service
public class MonthValueService implements For_hr {
	
	@Autowired
	private MnthStatus MnthStatus;
	
	
	 public Hr__view val(Hr__view x) {
		 return MnthStatus.save(x);
	 }
}
