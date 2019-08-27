package com.DataRepositories;

import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.Employeegoals;
//import com.nineleaps.SignUpApi.UserData;
@Transactional
@Repository
public interface EmployeeDataRepository  extends CrudRepository<EmployeeData,Integer>{

	@Query("SELECT u.password FROM EmployeeData u where u.email = ?1")
    public String findByEmail(String email);

	
	@Query(value="SELECT x.id, x.empname, y.month, y.value FROM emp_data x left join man_hr y on x.id = y.id WHERE x.id=y.id",nativeQuery=true)
	public Iterable<JSONObject> emps_list();
	
	@Query(value="SELECT a.id, a.empname FROM emp_data a WHERE mid=?1",nativeQuery=true)
	public Iterable<JSONObject> mng_list(int l);
	
	@Query(value="SELECT  b.empname FROM EmployeeData b WHERE mid=0")
	public Iterable<EmployeeData> drplist();
	
	@Modifying
	@Query("UPDATE EmployeeData m SET m.mid=?2 where m.email = ?1")
    public void AddMem(String m,int id);
	
	@Modifying
	@Query("UPDATE EmployeeData k SET k.mid=0 where k.email = ?1")
    public void dropMem(String d);
	
	
	@Query(value="SELECT p.empname, p.email, p.phone, p.designation, p.id FROM emp_data p where p.email = ?1",nativeQuery=true)
	public JSONObject profile(String email);

	@Query(value="select id from emp_data where email=?1",nativeQuery=true)
	public int getid(String email);

	@Query(value="Insert into month_values (id) values(?1)",nativeQuery=true)
	public void month_valueupdate(int id);

    @Query (value="Select id,qno,ques,ans from q_and_a where id=?1 and month=?2",nativeQuery=true)
	public Iterable<JSONObject> allqanda(int id,String month);

    @Query(value="SELECT  b.empname FROM EmployeeData b WHERE mid=0")
	public Iterable<Employeegoals> goallist();

	}
