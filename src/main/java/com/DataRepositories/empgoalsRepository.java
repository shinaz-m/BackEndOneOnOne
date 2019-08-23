package com.DataRepositories;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.nineleaps.OneonOne.egoal;

public interface empgoalsRepository extends CrudRepository<egoal,Integer> {
	

}
