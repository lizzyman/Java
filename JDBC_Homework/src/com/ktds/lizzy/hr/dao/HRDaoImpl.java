package com.ktds.lizzy.hr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.lizzy.hr.vo.CountriesVO;
import com.ktds.lizzy.hr.dao.support.*;
import com.ktds.lizzy.hr.dao.support.annotation.BindData;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

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
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
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

}
