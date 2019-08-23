package com.DataRepositories;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.nineleaps.OneonOne.Employeegoals;

public interface EmployeegoalsRepository extends CrudRepository<Employeegoals,Integer> {
	

}
