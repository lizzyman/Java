package com.ktds.lizzy.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.lizzy.hr.dao.support.QueryHandler;
import com.ktds.lizzy.hr.dao.support.*;
import com.ktds.lizzy.hr.dao.support.annotation.BindData;
import com.ktds.lizzy.hr.vo.DepartmentsVO;
import com.ktds.lizzy.hr.vo.EmployeesVO;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getEmployeesInfo() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String prepareQuery() {
				String query = "SELECT  E.EMPLOYEE_ID, " +
						"        D.DEPARTMENT_NAME, " +
						"        J.JOB_TITLE, " +
						"        L.CITY " +
						"   FROM    EMPLOYEES E, " +
						"        DEPARTMENTS D, " +
						"        JOBS J, " +
						"        LOCATIONS L " +
						"   WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID " +
						"   AND     D.LOCATION_ID = L.LOCATION_ID " +
						"   AND     E.JOB_ID = J.JOB_ID ";

				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeeVO = new EmployeesVO();
				BindData.bindData(rs, employeeVO);
				BindData.bindData(rs, employeeVO.getDepartmentsVO());
				BindData.bindData(rs, employeeVO.getDepartmentsVO().getLocationVo());
				BindData.bindData(rs, employeeVO.getJobsVO());
				
				return employeeVO;
			}
		});
		
	}

	@Override
	public List getEmployeesInfoInSeattle() {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String prepareQuery() {
				String query = "SELECT  E.EMPLOYEE_ID, " +
						"        D.DEPARTMENT_NAME, " +
						"        J.JOB_TITLE " +
						"   FROM    EMPLOYEES E, " +
						"        DEPARTMENTS D, " +
						"        JOBS J, " +
						"        LOCATIONS L " +
						"   WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID " +
						"   AND     E.JOB_ID = J.JOB_ID " +
						"   AND     L.CITY = 'Seattle' "; 


				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeeVO = new EmployeesVO();
				BindData.bindData(rs, employeeVO);
				BindData.bindData(rs, employeeVO.getDepartmentsVO());
				BindData.bindData(rs, employeeVO.getJobsVO());
				return employeeVO;
			}
		});
		
	}

	@Override
	public List getEmployeesInDepartment(int departmentId) {
		
		return selectList(new QueryHandler() {
			
			@Override
			public String prepareQuery() {
				String query = "SELECT  E.EMPLOYEE_ID, " +
						"        E.FIRST_NAME, " +
						"        E.LAST_NAME, " +
						"        E.EMAIL, " +
						"        E.PHONE_NUMBER, " +
						"        E.HIRE_DATE,   " +
						"        E.JOB_ID, " +
						"        E.SALARY, " +
						"        E.COMMISSION_PCT, " +
						"        E.MANAGER_ID " +
						"   FROM   EMPLOYEES E " +
						"   WHERE  E.DEPARTMENT_ID = ? ";

				return query;
			}
			
			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, departmentId);
			}
			
			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeeVo = new EmployeesVO();
				BindData.bindData(rs, employeeVo);
				return employeeVo;
			}
		});
		
	}


}
