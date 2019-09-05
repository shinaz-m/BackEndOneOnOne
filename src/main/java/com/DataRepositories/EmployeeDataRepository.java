package com.DataRepositories;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Employeegoals;
@Transactional()
@Repository
public interface EmployeeDataRepository  extends CrudRepository<EmployeeData,Integer>{

	@Query("SELECT u.password FROM EmployeeData u where u.email = ?1")
    public String findByEmail(String email);
	
	@Query(value="SELECT x.id, x.empname, y.month, y.value FROM employee_data x left join man_hr y on x.id = y.id WHERE x.id=y.id",nativeQuery=true)
	public Iterable<JSONObject> emps_list();
	
	@Query(value="SELECT a.id, a.empname FROM employee_data a WHERE mid=?1",nativeQuery=true)
	public Iterable<JSONObject> mng_list(int l);
	
	@Query(value="SELECT  b.id, b.empname FROM employee_data b WHERE mid=0 and designation!='manager' and designation!='hr'",nativeQuery=true)
	public Iterable<JSONObject> drplist();
	
	@Modifying
	@Query("UPDATE EmployeeData m SET m.mid=?1 where m.id = ?2")
    public void AddMem(int mid,int id);
	
	@Modifying
	@Query("UPDATE EmployeeData k SET k.mid=0 where k.id = ?1")
    public void dropMem(int id);
		
	@Query(value="SELECT p.empname, p.email, p.phone, p.designation, p.id FROM employee_data p where p.email = ?1",nativeQuery=true)
	public JSONObject profile(String email);

	@Query(value="select id from employee_data where email=?1",nativeQuery=true)
	public int getid(String email);

	@Query(value="Insert into month_values (id) values(?1)",nativeQuery=true)
	public void month_valueupdate(int id);

    @Query (value="Select id,qno,question,answer,remark,type,month from feedback where id=?1 and month=?2",nativeQuery=true)
	public Iterable<JSONObject> allqanda(int id,String month);

    @Query(value="SELECT  b.empname FROM EmployeeData b WHERE mid=0")
	public Iterable<Employeegoals> goallist();

    @Query(value="Select empname,email from employee_data where id=?1",nativeQuery=true)
	public JSONObject empprofile(int id);

	}
