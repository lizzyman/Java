package com.ktds.lizzy.hr.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.lizzy.hr.vo.*;

public class HRDaoImpl implements HRDao {
	
 @Override
    public List<EmployeesVO> getAllEmployees() {
        // 1. Oracle driver loading
        try {
            // Instances of the class Class represent classes and interfaces in
            // a running Java application.
            // 외우기
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버 로딩 실패. 시스템 종료.");
            return null;
        }
        // 2. "DB에 연결을하고, 쿼리를 던지고(실행), 그 결과를 받아오기"
        // 2-1. JDBC Instance 생성
        /**
         * java +파이프(쿼리,데이터가 Stream형식으로 교환. 메모리를 회수하지 않으면 x)+ oracle 회수를 하기위해
         * 아래와같이 밖에 선언하고 null로 선언해둔것.
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // 2-2. Oracle instance에 연결
        // oracleUrl 외우기: windows는 localhost / 오라클 port: 1521
        // mac os : 자신의 IP주소
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(oracleUrl, "hr", "chzhqhf486");
            // 2-3. Query를 만든다.
            String query =
                    // 따옴표와 글자 사이에서 띄워쓰기 해주기. error 발생.
                    " SELECT  " + " EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  " + "   EMAIL, PHONE_NUMBER, HIRE_DATE,  "
                            + "   JOB_ID, SALARY, COMMISSION_PCT,  " + "   MANAGER_ID, DEPARTMENT_ID "
                            + " FROM HR.EMPLOYEES ";
            // 2-4. Query를 실행한다.
            stmt = conn.prepareStatement(query);
            // 2-5. Query 실행 결과를 얻어온다.
            rs = stmt.executeQuery();
            // 2-5-1. Query 실행 결과를 List객체에 할당한다.
            // next() : 한줄 씩 얻어온다. / 한줄씩 List에 넣어주기.
            EmployeesVO employeesVO = null;
            List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
            while (rs.next()) {
                // 2-5-2 row의 정보를 employeesVO에 세팅한다.
                employeesVO = new EmployeesVO();
                employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
                employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
                /**
                 * java.sql.SQLException: 부적합한 열 이름 오라클 인스턴스에 연결 실패. 시스템 종료. at
                 * oracle.jdbc.driver.OracleStatement.getColumnIndex(OracleStatement.java:3724)
                 * at
                 * oracle.jdbc.driver.OracleResultSetImpl.findColumn(OracleResultSetImpl.java:2799)
                 * at
                 * oracle.jdbc.driver.OracleResultSet.getString(OracleResultSet.java:498)
                 * at
                 * com.ktds.ronanam.hr.dao.HRDaoImpl.getAllEmployees(HRDaoImpl.java:70)
                 * at com.ktds.ronanam.hr.Main.main(Main.java:20) Exception in
                 * thread "main" java.lang.NullPointerException at
                 * com.ktds.ronanam.hr.Main.main(Main.java:21)
                 */
                // 컬럼명을 잘못 적음. 오타
                employeesVO.setEmail(rs.getString("EMAIL"));
                employeesVO.setFirstName(rs.getString("FIRST_NAME"));
                employeesVO.setHireDate(rs.getString("HIRE_DATE"));
                /**
                 * java.sql.SQLException: 내부 표기로 변환할 수 없습니다 오라클 인스턴스에 연결 실패. 시스템
                 * 종료. at
                 * oracle.jdbc.driver.CharCommonAccessor.getInt(CharCommonAccessor.java:147)
                 * at
                 * oracle.jdbc.driver.T4CVarcharAccessor.getInt(T4CVarcharAccessor.java:830)
                 * at
                 * oracle.jdbc.driver.OracleResultSetImpl.getInt(OracleResultSetImpl.java:942)
                 * at
                 * oracle.jdbc.driver.OracleResultSet.getInt(OracleResultSet.java:438)
                 * at
                 * com.ktds.ronanam.hr.dao.HRDaoImpl.getAllEmployees(HRDaoImpl.java:83)
                 * at com.ktds.ronanam.hr.Main.main(Main.java:20) Exception in
                 * thread "main" java.lang.NullPointerException at
                 * com.ktds.ronanam.hr.Main.main(Main.java:21)
                 */
                // Job_id는 String인데 java에서 int로 해줌
                employeesVO.setJobId(rs.getString("JOB_ID"));
                employeesVO.setLastName(rs.getString("LAST_NAME"));
                employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
                employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                employeesVO.setSalary(rs.getInt("SALARY"));
                // 2-5-3 employees에 employeesVO에 add한다.
                employees.add(employeesVO);
            }
            /**
             * return을 만나면, return을하고 종료가 되는데, finally가 있으면 finally를 실행하고 종료한다.
             * while()문으로 다 읽어왔으면, list를 return해줘야하는데, 나는 여기에 리턴문을 적어주지 않아서
             * nullPointerException 발생
             */
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("오라클 인스턴스에 연결 실패. 시스템 종료.");
            return null; // try/catch문 이기 때문에 잘 실행되어도 반환 아니어도 반환한다.
        } finally {
            // 열었던 반대 순서로 닫아줘야한다.
            // 예외처리 각각 걸어줘야한다.
            // rs를 닫다가 에러가나면 무시하고 stmt를 닫아라. 또 닫다가 에러나면 무시하고 conn을 닫아라
            // 그러면 만날 수 있는 error가 nullpointerException
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        /**
         * 맨 처음에 null이 할당되어있는데, conn = class.getName();하다가 오류가 발생하면 catch문으로
         * 이동하게 되는데 이때는 if문에 걸리지 않기 때문에 아무것도 하지 않고 종료. 쿼리문을 수행하고나면 null이 아니기 때문에
         * 자원을 회수 및 close();
         */
    }
	
	@Override
	public List<DepartmentVO> getAllDepartments() {
		//1. Oracle Driver Loading.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ACL : Auto Class Loading = 객체를 불러온다. (메모리에 객체를 올려둠)
		} catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패! 시스템 종료");
			return null;
		}
		
		//2. JDBC Instance 생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//3. Oracle Instance의 연결
		try {
			String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // windows : loacalhost , mac : 자기 ip 주소, oracle port num = 1521
			conn = DriverManager.getConnection(oracleUrl, "hr", "chzhqhf486");
			
			//4. 쿼리를 만든다.
			String query = " SELECT  " +
					"   DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID,  " +
					"   LOCATION_ID " +
					"   FROM HR.DEPARTMENTS" +
					"   ORDER BY DEPARTMENT_ID DESC"; // 쿼리 -> String화 : ctrl + m
		
			//5. 쿼리를 실행한다.
			stmt = conn.prepareStatement(query);
			
			//6. 쿼리의 실행결과를 얻어온다.
			rs = stmt.executeQuery();
			
			//6-1. 쿼리의 실행결과를 List 객체에 할당한다.
			
			DepartmentVO departmentVO = null;
			List<DepartmentVO> departments = new ArrayList<DepartmentVO>();
			
			while (rs.next()) {
				//6-2. ROW의 정보를 employees에 세팅한다.
				
				departmentVO = new DepartmentVO();
				departmentVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentVO.setManagerId(rs.getInt("MANAGER_ID"));
				departmentVO.setLocationId(rs.getInt("LOCATION_ID"));
				
				//6-3. employees에 employeesVO를 add한다.
				departments.add(departmentVO);
			}
			//7. return 한다.
			return departments;
			
		} catch(SQLException e) {
			System.out.println("Oracle 인스턴스에 연결하지 못했습니다. 시스템 종료");
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch(SQLException e) {
				
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				
			}
		}
		
	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDepartments() {
		 // 1. Oracle driver loading
        try {
            // Instances of the class Class represent classes and interfaces in
            // a running Java application.
            // 외우기
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버 로딩 실패. 시스템 종료.");
            return null;
        }
        // 2. "DB에 연결을하고, 쿼리를 던지고(실행), 그 결과를 받아오기"
        // 2-1. JDBC Instance 생성
        /**
         * java +파이프(쿼리,데이터가 Stream형식으로 교환. 메모리를 회수하지 않으면 x)+ oracle 회수를 하기위해
         * 아래와같이 밖에 선언하고 null로 선언해둔것.
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // 2-2. Oracle instance에 연결
        // oracleUrl 외우기: windows는 localhost / 오라클 port: 1521
        // mac os : 자신의 IP주소
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(oracleUrl, "hr", "chzhqhf486");
            // 2-3. Query를 만든다.
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
            // 2-4. Query를 실행한다.
            stmt = conn.prepareStatement(query);
            // 2-5. Query 실행 결과를 얻어온다.
            rs = stmt.executeQuery();
            // 2-5-1. Query 실행 결과를 List객체에 할당한다.
            // next() : 한줄 씩 얻어온다. / 한줄씩 List에 넣어주기.
            EmployeesVO employeesVO = null;
           
            List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
            while (rs.next()) {
                // 2-5-2 row의 정보를 employeesVO에 세팅한다.
                employeesVO = new EmployeesVO();
                
                employeesVO.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                employeesVO.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
                employeesVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
               
                // 컬럼명을 잘못 적음. 오타
                employeesVO.setEmail(rs.getString("EMAIL"));
                employeesVO.setFirstName(rs.getString("FIRST_NAME"));
                employeesVO.setHireDate(rs.getString("HIRE_DATE"));
               
                // Job_id는 String인데 java에서 int로 해줌
                employeesVO.setJobId(rs.getString("JOB_ID"));
                employeesVO.setLastName(rs.getString("LAST_NAME"));
                employeesVO.setManagerId(rs.getInt("MANAGER_ID"));
                employeesVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                employeesVO.setSalary(rs.getInt("SALARY"));
                employeesVO.getDepartments().setDepartmentId(rs.getInt("D_DEPARTMENT_ID"));
                employeesVO.getDepartments().setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                employeesVO.getDepartments().setManagerId(rs.getInt("MANAGER_ID"));
                employeesVO.getDepartments().setLocationId(rs.getInt("LOCATION_ID"));
                
                // 2-5-3 employees에 employeesVO에 add한다.
                employees.add(employeesVO);
            }
            /**
             * return을 만나면, return을하고 종료가 되는데, finally가 있으면 finally를 실행하고 종료한다.
             * while()문으로 다 읽어왔으면, list를 return해줘야하는데, 나는 여기에 리턴문을 적어주지 않아서
             * nullPointerException 발생
             */
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("오라클 인스턴스에 연결 실패. 시스템 종료.");
            return null; // try/catch문 이기 때문에 잘 실행되어도 반환 아니어도 반환한다.
        } finally {
            // 열었던 반대 순서로 닫아줘야한다.
            // 예외처리 각각 걸어줘야한다.
            // rs를 닫다가 에러가나면 무시하고 stmt를 닫아라. 또 닫다가 에러나면 무시하고 conn을 닫아라
            // 그러면 만날 수 있는 error가 nullpointerException
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        /**
         * 맨 처음에 null이 할당되어있는데, conn = class.getName();하다가 오류가 발생하면 catch문으로
         * 이동하게 되는데 이때는 if문에 걸리지 않기 때문에 아무것도 하지 않고 종료. 쿼리문을 수행하고나면 null이 아니기 때문에
         * 자원을 회수 및 close();
         */
	}
}










