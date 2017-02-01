package com.ktds.lizzy.address.book.biz;

import java.util.List;

import com.ktds.lizzy.address.book.vo.AddressVO;

public interface AddressBiz {
	
	/**
	 * 주소록 조회
	 * @return 모든 주소를 반환
	 */
	public List<AddressVO> queryAllList();
	
	/**
	 * 주소 검색
	 * @param index 번호 
	 * @return 하나의 주소를 반환
	 */
	public AddressVO findOneAddress(int index);

	/**
	 * 주소 삭제
	 * @param 삭제할 index 번호
	 */
	public void removeAddress(int index);
	
	/**
	 * 주소 수정
	 * @param 수정할 index 번호
	 * @param newAddress 신규 주소 정보
	 */
	public void updateAddress(int index, AddressVO newAddress);
	
	/**
	 * 주소 추가
	 * @param newAddress 신규 주소 정보
	 */
	public void addAddress(AddressVO newAddress);
	
}
