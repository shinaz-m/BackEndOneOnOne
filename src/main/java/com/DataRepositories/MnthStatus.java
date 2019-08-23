package com.DataRepositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.ManHr;
@Transactional
@Repository
public interface MnthStatus extends CrudRepository<ManHr,Integer>{

}
