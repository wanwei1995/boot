package com.ww.springboot.boot.sql;

import org.apache.ibatis.jdbc.SQL;

public class StudyPlanSqlProvider {
	private static final String ALL_FIELD =
            "study_name studyName,schedule";

    private static final String TABLE_NAME = "life_study_plan";
	
	public String findBySelective(String way, String sort) {

        SQL sql = new SQL() {
            {
                SELECT(ALL_FIELD);
                FROM(TABLE_NAME);
                if (sort.equals("0")) {
                   ORDER_BY("operating_time"); 
                }else if(sort.equals("1")){
                   ORDER_BY("schedule"); 
                }
            }
        };
        if(way.equals("1")){
        	return sql.toString()+ " DESC";
        }
        return sql.toString();
    }

}
