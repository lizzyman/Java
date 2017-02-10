package com.ktds.lizzy.hr.dao;

import java.util.List;

import com.ktds.lizzy.hr.vo.CountriesVO;

public interface HRDao {
	
	public List<CountriesVO> getAllCountriesWithRegions();

}
