package com.DataRepositories;

import javax.transaction.Transactional;


import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.month_values;
@Transactional
@Repository
public interface HRRepository extends CrudRepository<month_values,Integer>{

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon    from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" 
		,nativeQuery=true)
	public Iterable<JSONObject> viewall();

	@Query(value="select id from month_values",nativeQuery=true)
	public Iterable<JSONObject> viewempid();

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.id=?1 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> id(String id);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.mon=?1 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> month(String month);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.val=?1 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> progress(String id);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.id=?1 and t.mon=?2 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> id_month(String id, String month);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.id=?1 and t.val=?2 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> id_progress(String id, String progress);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.val=?1 and t.mon=?2 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> progress_month(String progress, String month);

	@Query(value="select t.mon,t.id as id,val as progress,a.empname from (select id, apr as val, 'apr' as mon from month_values    union all    select id, jan, 'jan'    from month_values    union all    select id, feb, 'feb'    from month_values    union all    select id, mar, 'mar'    from month_values    union all    select id, oct, 'oct'    from month_values    union all    select id, may, 'may'    from month_values    union all    select id, june, 'june'    from month_values    union all    select id, july, 'july'    from month_values    union all    select id, aug, 'aug'    from month_values    union all    select id, sep, 'sep'    from month_values    union all    select id, nov, 'nov'    from month_values    union all     select id, december, 'december'    from month_values ) t, employee_data a where a.id=t.id and t.id=?1 and t.val=?2 and t.mon=?3 order by id,FIELD(mon,'jan','feb','mar','apr','may','june','july','aug','sep','oct','nov','december')" ,nativeQuery=true)
	public Iterable<JSONObject> id_progress_month(String id, String progress, String month);

	@Query(value = "select now()>(Time + INTERVAL '36' HOUR) as time from feedback where id=?1 and month=?2 and qno=1",nativeQuery=true)
	public JSONObject employeetimestamp(String id, String month);

	
}
