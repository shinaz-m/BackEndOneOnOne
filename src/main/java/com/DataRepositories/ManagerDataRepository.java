package com.DataRepositories;

import java.security.Timestamp;
import javax.transaction.Transactional;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.nineleaps.OneonOne.month_values;

@Transactional()
public interface ManagerDataRepository extends CrudRepository<month_values, Integer> {

	
	@Query(value="Select a.jan, a.feb, a.mar, a.apr, a.may, a.june, a.july, a.aug, a.sep, a.oct, a. nov, a.december, a.id from month_values a where a.id=?1",nativeQuery=true)
	public Iterable<JSONObject> emp_prog(int id);

	@Modifying
	@Query(value="UPDATE month_values  SET ?1 = 1 where id = ?2 ",nativeQuery=true)
	public void updatemonth(String month, int id);
	
	@Query(value="Select COUNT(id) from feedback WHERE id=?1 and month =?2",nativeQuery=true)
	public int idcount(int id,String month);

	
	@Query(value="SELECT g.goal, g.goaltime, g.goalno FROM employee_goals g WHERE id=?1 and month=?2",nativeQuery=true)
	 public Iterable<JSONObject> goallist(int g, String month);

	@Modifying
	@Query(value="UPDATE month_values set jan=1 where id=?1",nativeQuery=true)
	public void jan(int id);
	@Modifying
	@Query(value="UPDATE month_values set feb=1 where id=?1",nativeQuery=true)
	public void feb(int id);
	@Modifying
	@Query(value="UPDATE month_values set mar=1 where id=?1",nativeQuery=true)
	public void mar(int id);
	@Modifying
	@Query(value="UPDATE  month_values set apr=1 where id=?1",nativeQuery=true)
	public void apr(int id);
	@Modifying
	@Query(value="UPDATE  month_values set may=1 where id=?1",nativeQuery=true)
	public void may(int id);
	@Modifying
	@Query(value="UPDATE  month_values set june=1 where id=?1",nativeQuery=true)
	public void june(int id);
	@Modifying
	@Query(value="UPDATE  month_values set july=1 where id=?1",nativeQuery=true)
	public void july(int id);
	@Modifying
	@Query(value="UPDATE  month_values set aug=1 where id=?1",nativeQuery=true)
	public void aug(int id);
	@Modifying
	@Query(value="UPDATE  month_values set sep=1 where id=?1",nativeQuery=true)
	public void sept(int id);
	@Modifying
	@Query(value="UPDATE  month_values set oct=1 where id=?1",nativeQuery=true)
	public void oct(int id);
	@Modifying
	@Query(value="UPDATE month_values set  nov=1 where id=?1",nativeQuery=true)
	public void nov(int id);
	@Modifying
	@Query(value="UPDATE  month_values set december=1 where id=?1",nativeQuery=true)
	public void dec(int id);
	

	@Query(value="Select qid from feedback where id=?1 and qno=?2 and month=?3",nativeQuery=true)
	public int findqid(int id,int qno,String month); 

	@Query(value="Select count(qno) from feedback where id=?1 and month=?2 and qno=?3",nativeQuery=true)
	public int exist(int id, String month, int qno);

	
	@Modifying
	@Query(value="INSERT INTO feedback (id,question,answer,remark,month,qno,time,type) VALUES (?1,?2,?3,?4,?5,?6,current_timestamp,'d')",nativeQuery=true)
	public void createdynamic(int id, String question, String answer, String remark, String month, int qno);

	@Modifying
	@Query(value="Update feedback set question=?2, answer=?3, remark=?4  where id=?1 and month=?5 and qno=?6",nativeQuery=true)
	public void updatedynamic(int id, String question, String answer, String remark, String month, int qno);

	@Query(value="Select count(goalno) from employee_goals where id=?1 and month=?2 and goalno=?3",nativeQuery=true)
	public int existgoal(int id, String month, int gno);

	
	@Modifying
	@Query(value="update employee_goals set goal=?2, goaltime=?3 where id=?1 and month =?4 and goalno=?5",nativeQuery = true)
	public void updategoal(int id, String goal, String gtime, String month, int gno);

	
	@Query(value="Select time from feedback where id=?1 and qno=?2 and month=?3",nativeQuery=true)
	public java.sql.Timestamp getTime(int id, int i, String month);


}
