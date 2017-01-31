package com.ktds.lizzy;

import com.ktds.lizzy.buyer.Buyer;
import com.ktds.lizzy.seller.Seller;

public class Store {
	
	public void start() {
		
		Buyer lizzy = new Buyer(0, 5000000);
		Buyer easy = new Buyer(0, 4000000);
		
		Seller nym = new Seller(500, 500000);
		
		lizzy.buy(nym);
		
		System.out.println(lizzy);
		System.out.println(easy);
		
		
//		System.out.println("장터에 오신 것을 환영합니다.");
//		Buyer lizzy = new Buyer(0, 500000);
//		Seller easy = new Seller(100, 5000000);
//		
//		System.out.println("바이어 : 상품 좀 살게요. 이 상품 1개 주세요.");
//		easy.sell();
//		lizzy.buy();
//		
//		System.out.println("셀러 : 2500원 입니다.");
//		lizzy.pay(2500);
//		
//		System.out.println(lizzy);
//		System.out.println(easy);

	}
	
	public static void main(String[] args) {
		
		new Store().start();
		
	}

}
