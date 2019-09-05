package com.Services;

import javax.transaction.Transactional;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataRepositories.*;


@Transactional
@Service
public class HRDataServices {
	
	@Autowired
	private HRRepository hrrepo;


	public Iterable<JSONObject> view(String id, String month, String progress) {
		System.out.println(id+"     "+month+"    "+progress);
		if((id==null||id.equals("null")) && (month==null||month.equals("null")) && (progress==null||progress.equals("null")))
			return hrrepo.viewall();
		else if(id!=null && (month==null||month.equals("null")) && (progress==null||progress.equals("null")))
			return hrrepo.id(id);		
		else if((id==null||id.equals("null")) && month!=null && (progress==null||progress.equals("null")))
			return hrrepo.month(month);
		else if((id==null||id.equals("null")) &&(month==null||month.equals("null")) && progress!=null)
			return hrrepo.progress(progress);
		else if(id!=null && month!=null && (progress==null||progress.equals("null")))
			return hrrepo.id_month(id,month);
		else if(id!=null && (month==null||month.equals("null")) && progress!=null)
			return hrrepo.id_progress(id,progress);
		else if((id==null||id.equals("null")) && month!=null && progress!=null)
			return hrrepo.progress_month(progress,month);
		else if(id!=null && month!=null && progress!=null)
			return hrrepo.id_progress_month(id,progress,month);
		else if((id==null||id.equals("null")) && (month==null||month.equals("null")) && (progress==null||progress.equals("null")))
						return hrrepo.viewall();
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

	public JSONObject employetimestamp(String id, String month) {
		// TODO Auto-generated method stub
		return hrrepo.employeetimestamp(id,month);
	}
}
