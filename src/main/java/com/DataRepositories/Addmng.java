package com.DataRepositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;

public interface Addmng extends CrudRepository<Mn_create,Integer>{
	
}


