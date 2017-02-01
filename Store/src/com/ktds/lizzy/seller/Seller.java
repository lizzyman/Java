package com.ktds.lizzy.seller;

import com.ktds.lizzy.buyer.Buyer;
import com.ktds.lizzy.vo.BasketVO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Seller {
	
	/**
	 * 상품 가격
	 */
	private final int PRICE = 2500; // 상수이기 때문에 final 선언 (상수는 getter, setter 만들지 않음)
	
	/**
	 * 판매자가 가진 상품의 개수 
	 */
	private int productQuantity;
	
	/**
	 * 판매자가 가진 금액
	 */
	private int money;
	
	private BasketVO basketVO;
	
	public Seller(int productQuantity, int money) {
		System.out.println("판매자를 생성합니다!");
		
		basketVO = new BasketVO();
		basketVO.setProductQuantity(productQuantity);
		basketVO.setMoney(money);
		
		System.out.println(this);
	}
	
	/**
	 * 판매하기
	 */
	public void sell(Buyer buyer) {
		// 판매자가 가진 상품의 개수에서 하나를 뺸다. 
		//this.productQuantity--;
		basketVO.minusProductQuantity();
		
		// 구매자는 돈을 지불한다.
		buyer.pay(PRICE);
		
		// 판매자가 가진 금액에서 상품의 가격만큼 더한다.
		this.money += PRICE;
	}
	
	/**
	 * 재고 파악하기
	 * @return : boolean 재고가 있으면 false, 없으면 true. 
	 */
	public boolean isSoldOut() {
		boolean isSoldOut = basketVO.getProductQuantity() == 0;
		return isSoldOut;
	}
	
	@Override
	public String toString() {
		String message = String.format("판매자의 상품 개수 : %d, "
				+ "판매자가 가진 금액 : %d", basketVO.getProductQuantity(), this.money);
		return message;
	}

}
