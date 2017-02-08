package com.ktds.lizzy.vendingMachine.vo;

import java.util.List;
import java.util.ArrayList;

import com.ktds.lizzy.vendingMachine.cons.DrinksPriceConstant;

public class VendingMachineVo {
	
	private int fund;
	private List<Integer> drinksQuantity;
	
	public VendingMachineVo(int fund) {
		this.fund = fund;
		this.drinksQuantity= new ArrayList<Integer>();
		
		drinksQuantity.add(10);
		drinksQuantity.add(10);
		drinksQuantity.add(10);
	}

	public int getFund() {
		return fund;
	}

	public void setFund(int fund) {
		this.fund = fund;
	}

	public List<Integer> getDrinksQuantity() {
		return drinksQuantity;
	}

	public void setDrinksQuantity(List<Integer> drinksQuantity) {
		this.drinksQuantity = drinksQuantity;
	}
	
	@Override
	public String toString() {
		String msg = String.format("<< Menu >>\n[Coke]\t%dwon\t(%d left)\n[Fanta]\t%dwon\t(%d left)\n"
				+ "[Cider]\t%d\t(%d left)\n", DrinksPriceConstant.COKE, drinksQuantity.get(0), DrinksPriceConstant.FANTA, drinksQuantity.get(1), DrinksPriceConstant.CIDER, drinksQuantity.get(2));
		return msg;
	}
	
}
