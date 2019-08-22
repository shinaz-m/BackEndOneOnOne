package com.DataRepositories;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.month_values;
@Transactional
public interface ManagerDataRepository extends CrudRepository<month_values, Integer> {

	
	@Query(value="Select a.jan, a.feb, a.mar, a.apr, a.may, a.june, a.july, a.aug, a.sep, a.oct, a. nov, a.december, a.id from month_values a where a.id=?1",nativeQuery=true)
	public Iterable<JSONObject> emp_prog(int id);

	@Modifying
	@Query(value="UPDATE month_values  SET ?1 = 1 where id = ?2 ",nativeQuery=true)
	public void updatemonth(String month, int id);

	//@Text varchar(200)=month;
	
//	
//	@Modifying
//	@Query("update EARAttachment ear set ear.status = :status where ear.id = :id")
//	int setStatusForEARAttachment(@Param("status") Integer status, @Param("id") Long id);
	}

