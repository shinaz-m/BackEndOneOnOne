package com.Services;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataRepositories.*;

import com.Interface.For_hr;
import com.nineleaps.OneonOne.ManHr;

@Transactional
@Service
public class HRDataServices implements For_hr {
	
	@Autowired
	private HRRepository hrrepo;
	
//	
//	 public ManHr val(ManHr x) {
//		 return MnthStatus.save(x);
//	 }


	public Iterable<JSONObject> view(String id, String month, String progress) {
		// TODO Auto-generated method stub
		
		System.out.println(id+"     "+month+"    "+progress);
		if(id!=null && month==null && progress==null)return hrrepo.id(id);
		else if(id==null && month!=null && progress==null)return hrrepo.month(month);
		else if(id==null && month==null && progress!=null)return hrrepo.progress(id);
		else if(id!=null && month!=null && progress==null)return hrrepo.id_month(id,month);
		else if(id!=null && month==null && progress!=null)return hrrepo.id_progress(id,progress);
		else if(id==null && month==null && progress!=null)return hrrepo.progress_month(progress,month);
		else if(id!=null && month!=null && progress!=null)return hrrepo.id_progress_month(id,progress,month);
		else return hrrepo.viewall();
	}

	public Iterable<JSONObject> viewall() {
		// TODO Auto-generated method stub
		return hrrepo.viewall();
	}

	public Iterable<JSONObject> viewempid() {
		// TODO Auto-generated method stub
		return hrrepo.viewempid();
	}
}
