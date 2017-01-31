package com.ktds.lizzy.buyer;

import com.ktds.lizzy.seller.Seller;

/**
 * 
 * Seller에게 상품을 구매하고금액을 Seller에게 지불한다.
 * 
 * @author Lizzyman
 *
 */

public class Buyer {
	
	/**
	 * 상품 개수 
	 */
	private int productQuantity;
	
	/**
	 * 구매자가 가진 금액 
	 */
	private int money;
	
	public Buyer(int productQuantity, int money) {
		System.out.println("구매자를 생성합니다!");
		
		// 초기값 세팅 
		setProductQuantity(productQuantity);
		setMoney(money);
		
		//현황 출력하기 
		System.out.println(this);
	}
	
	/**
	 * 상품 개수를 초기화 또는 갱신
	 * @param productQuantity
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	/**
	 * 구매자가 가진 금
	 * @return
	 */
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	/**
	 * 구매자의 가진 돈을 초기화 또는 갱신
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 구매자가 가진 돈을 반환함. (출력용)
	 * @return
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * 구매하기
	 * 구매자가 가진 상품의 개수에 1 더
	 */
	public void buy(Seller seller) {
		seller.sell(this);
		
		this.productQuantity++;
	}

	/**
	 * 지불하기
	 * 구매자가 가진 돈에서 지불할 돈을 
	 * @param money : 지불할 금
	 */
	public void pay(int money) {
		this.money -= money;
	}
	/**
	 * 구매자 현황 파악하
	 */
	@Override
	public String toString() {
		String message = String.format("구매한 상품 개수 : %d\n"
				+ "구매자가 가진 금액 : %d", productQuantity, money);
		return message;
	}	
}
