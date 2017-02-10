package com.ktds.lizzy.hr.vo;

import com.ktds.lizzy.hr.dao.support.annotation.Types;

public class CountriesVO {
	
	@Types
	private String countryId;
	@Types
	private String countryName;
	@Types
	private int regionId;
	
	private RegionsVO regionVO;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	public RegionsVO getRegionVO() {
		if (regionVO == null)
			regionVO = new RegionsVO();
		return regionVO;
	}
	
	public void setRegionVO(RegionsVO regionVO) {
		this.regionVO = regionVO;
	}
	
}
