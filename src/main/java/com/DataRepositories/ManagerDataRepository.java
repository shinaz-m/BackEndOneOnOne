package com.DataRepositories;

import javax.transaction.Transactional;

import javax.transaction.TransactionalException;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nineleaps.OneonOne.month_values;

//@Transactional(rollbackOn  = Exception.class )
//@EnableTransactionManagement
//@TransactionConfiguration(defaultRollback = true)
@Transactional()
public interface ManagerDataRepository extends CrudRepository<month_values, Integer> {

	
	@Query(value="Select a.jan, a.feb, a.mar, a.apr, a.may, a.june, a.july, a.aug, a.sep, a.oct, a. nov, a.december, a.id from month_values a where a.id=?1",nativeQuery=true)
	public Iterable<JSONObject> emp_prog(int id);

	@Modifying
	@Query(value="UPDATE month_values  SET ?1 = 1 where id = ?2 ",nativeQuery=true)
	public void updatemonth(String month, int id);
	
	@Query(value="Select COUNT(id) from q_and_a WHERE id=?1 and month =?2",nativeQuery=true)
	public int idcount(int id,String month);

	
	@Query(value="SELECT g.goal, g.gtime, g.gno FROM egoal g WHERE id=?1 and month=?2",nativeQuery=true)
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
	

	@Query(value="Select qid from q_and_a where id=?1 and qno=?2 and month=?3",nativeQuery=true)
	public int findqid(int id,int qno,String month); 

	@Query(value="Select count(qno) from q_and_a where id=?1 and month=?2 and qno=?3",nativeQuery=true)
	public int exist(int id, String month, int qno);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO q_and_a (id,ques,ans,remark,month,qno,qtime,type) VALUES (?1,?2,?3,?4,?5,?6,current_timestamp,'d')",nativeQuery=true)
	public void createdynamic(int id, String ques, String ans, String remark, String month, int qno);

	@Modifying
	@Query(value="Update q_and_a set ques=?2, ans=?3, remark=?4  where id=?1 and month=?5 and qno=?6",nativeQuery=true)
	public void updatedynamic(int id, String ques, String ans, String remark, String month, int qno);

	@Query(value="Select count(gno) from egoal where id=?1 and month=?2 and gno=?3",nativeQuery=true)
	public int existgoal(int id, String month, int gno);

	
	@Modifying
	@Query(value="update egoal set goal=?2, gtime=?3 where id=?1 and month =?4 and gno=?5",nativeQuery = true)
	public void updategoal(int id, String goal, String gtime, String month, int gno);


}
