package com.ktds.lizzy.address.book.biz;

import java.util.List;
import java.util.Scanner;

import com.ktds.lizzy.address.book.dao.*;
import com.ktds.lizzy.address.book.vo.AddressVO;

public class AddressBizImpl implements AddressBiz {
	
	private AddressDao addressDao;
	
	private Scanner input = new Scanner(System.in);
	
	public AddressBizImpl() {
		addressDao = new AddressDaoImpl();
	}

	@Override
	public void queryAllList() {
		List<AddressVO> addressList = addressDao.queryAllList();
		for (AddressVO address : addressList) {
			printAddressInfo(address);
		}
	}
	
	private void printAddressInfo(AddressVO address) {
		System.out.printf("이름 : %s, 전화번호 : %s, 주소 : %s\n",
				address.getName(), address.getPhoneNumber(), address.getAddress());
	}

	@Override
	public void findOneAddress() {
		System.out.println("검색할 주소록의 번호를 입력하세요.");
		int addressNumber = inputAddressNumber();
		AddressVO addressVO = addressDao.findOneAddress(addressNumber);
		printAddressInfo(addressVO);
	}

	private int inputAddressNumber() {
		int addressNumber = input.nextInt();
		return addressNumber;
	}

	@Override
	public void removeAddress() {
		System.out.println("삭제할 주소록의 번호를 입력하세요.");
		int addressNumber = inputAddressNumber();
		addressDao.removeAddress(addressNumber);
	}

	@Override
	public void updateAddress() {
		System.out.println("수정할 주소록의 번호를 입력하세요.");
		int addressNumber = inputAddressNumber();
		AddressVO addressVO = addressDao.findOneAddress(addressNumber);
		printAddressInfo(addressVO);
		
		System.out.println("새로운 주소정보를 입력하세요.");
		addressVO = createNewAddress();
		
		addressDao.updateAddress(addressNumber, addressVO);
	}

	private AddressVO createNewAddress() {
		AddressVO addressVO = new AddressVO();
		
		System.out.println("이름을 입력하세요.");
		String nameTemp = input.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phoneNumberTemp = input.nextLine();
		System.out.println("주소를 입력하세요.");
		String addressTemp = input.nextLine();
		
		addressVO.setName(nameTemp);
		addressVO.setPhoneNumber(phoneNumberTemp);
		addressVO.setAddress(addressTemp);
		return addressVO;
	}

	@Override
	public void addAddress() {
		System.out.println("추가할 주소정보를 입력하세요.");
		AddressVO addressVO = createNewAddress();
		
		addressDao.addAddress(addressVO);
	}
	
	
	
}
