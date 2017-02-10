package com.ktds.lizzy.hr.biz;

import java.util.List;

import com.ktds.lizzy.hr.dao.HRDao;
import com.ktds.lizzy.hr.dao.HRDaoImpl;
import com.ktds.lizzy.hr.vo.CountriesVO;

public class HRBizImpl implements HRBiz {
	
	private HRDao hrDao;
	
	public HRBizImpl() {
		hrDao = new HRDaoImpl();
	}

	@Override
	public void printAllCountriesWithRegions() {
		
		List<CountriesVO> countriesVO =  hrDao.getAllCountriesWithRegions();
		
		for (CountriesVO countryVO : countriesVO) {
			System.out.printf("%20s\t%20s\t%d\t%d\t%20s",
					countryVO.getCountryId(),
					countryVO.getCountryName(),
					countryVO.getRegionId(),
					countryVO.getRegionVO().getRegionId(),
					countryVO.getRegionVO().getRegionName());
			System.out.println();
		}
		
	}

}
