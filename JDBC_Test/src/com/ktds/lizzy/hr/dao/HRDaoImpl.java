package com.ktds.lizzy.hr.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.lizzy.dao.support.JDBCDaoSupport;
import com.ktds.lizzy.dao.support.QueryHandler;
import com.ktds.lizzy.dao.support.annotation.BindData;
import com.ktds.lizzy.hr.vo.*;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {
	
 @Override
    public List<EmployeesVO> getAllEmployees() {
	 	
	    return selectList(new QueryHandler() { // Anonymous Class (익명 클래스) : 인터페이스를 객체화 시키는 방법 (원래 인터페이스는 객체화 x)

			@Override
			public String preparedQuery() {
				String query =
	                    // 따옴표와 글자 사이에서 띄워쓰기 해주기. error 발생.
	                    " SELECT  " + " EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  " + "   EMAIL, PHONE_NUMBER, HIRE_DATE,  "
	                            + "   JOB_ID, SALARY, COMMISSION_PCT,  " + "   MANAGER_ID, DEPARTMENT_ID "
	                            + " FROM HR.EMPLOYEES ";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}
	    	
	    });
        
    }
	
	@Override
	public List<DepartmentVO> getAllDepartments() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				String query = " SELECT  " +
						"   DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID,  " +
						"   LOCATION_ID " +
						"   FROM HR.DEPARTMENTS" +
						"   ORDER BY DEPARTMENT_ID DESC";
				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				DepartmentVO departmentVO = new DepartmentVO();
				BindData.bindData(rs, departmentVO);
				return departmentVO;
			}
		});
		
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {
		
		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query =
						// 따옴표와 글자 사이에서 띄워쓰기 해주기. error 발생.
						" SELECT  E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  " 
								+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,  "
								+ "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  " 
								+ "   E.MANAGER_ID, E.DEPARTMENT_ID,  "
						 		+ "   D.DEPARTMENT_ID D_DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID, D.LOCATION_ID"
						 		+ " FROM EMPLOYEES E, "
						 		+ " DEPARTMENTS D "
						 		+ " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				BindData.bindData(rs, employeesVO.getDepartments());
				return employeesVO;
			}
			
		});
		
	}

	@Override
	public List<DepartmentVO> getAllDepartmentsWithLocations() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				String query = "SELECT  " +
						"   D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID, D.LOCATION_ID D_LOCATION_ID, " +
						"   L.LOCATION_ID L_LOCATION_ID, L.STREET_ADDRESS, L.POSTAL_CODE,  " +
						"   L.CITY, L.STATE_PROVINCE, L.COUNTRY_ID " +
						"   FROM DEPARTMENTS D, LOCATIONS L " +
						"   WHERE D.LOCATION_ID = L.LOCATION_ID ";
				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				DepartmentVO departmentVO = new DepartmentVO();
				BindData.bindData(rs, departmentVO);
				BindData.bindData(rs, departmentVO.getLocationVo());
				return departmentVO;
			}
		});
		
	}

	@Override
	public List<CountriesVO> getAllCountriesWithRegions() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				String query = "SELECT  " +
						"C.COUNTRY_ID, C.COUNTRY_NAME, C.REGION_ID C_REGION_ID, R.REGION_ID R_REGION_ID, R.REGION_NAME " +
						"FROM    COUNTRIES C, REGIONS R " +
						"WHERE   C.REGION_ID = R.REGION_ID ";
				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				CountriesVO countryVO = new CountriesVO();
				BindData.bindData(rs, countryVO);
				BindData.bindData(rs, countryVO.getRegionVO());
				return countryVO;
			}
		});
		
	}

	@Override
	public EmployeesVO findOneEmployee(int employeeId) {
		
		return (EmployeesVO) selectOne(new QueryHandler() {
			
			@Override
			public String preparedQuery() {
				StringBuffer query = new StringBuffer(); // String = 불면, StringBuffer = 가변
				query.append(" SELECT	EMPLOYEE_ID ");
				query.append(" 			, FIRST_NAME ");
				query.append(" 			, LAST_NAME ");
				query.append(" 			, EMAIL ");
				query.append(" 			, PHONE_NUMBER ");
				query.append(" 			, JOB_ID ");
				query.append(" 			, HIRE_DATE ");
				query.append(" 			, SALARY ");
				query.append(" 			, COMMISSION_PCT ");
				query.append(" 			, MANAGER_ID ");
				query.append(" 			, DEPARTMENT_ID ");
				query.append(" FROM		EMPLOYEES ");
				query.append(" WHERE	EMPLOYEE_ID = ? ");
				return query.toString();
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, employeeId); // 1번째 index에게로 값 전달 (index가 0이 시작인 것 : 배열, 리스트 뿐!)	
			}
			
			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeeVO = new EmployeesVO();
				BindData.bindData(rs, employeeVO);
				return employeeVO;
			}
		});
		
	}
}











