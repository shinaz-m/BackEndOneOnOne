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

	@Query(value="Select COUNT(id) from q_and_a WHERE id=?1 and month =?2",nativeQuery=true)
	public int idcount(int id,String month);

	
	@Query(value="SELECT g.goal, g.gtime FROM egoal g WHERE id=?1",nativeQuery=true)
	 public Iterable<JSONObject> goallist(int g);

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
}
