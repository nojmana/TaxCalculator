package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class Output {
	DecimalFormat df00 = new DecimalFormat("#.00");
	DecimalFormat df = new DecimalFormat("#");

	private Contract contract;
	
	public Output(Contract contract){
		this.contract = contract;
	}

	public void print(){
		System.out.println(contract.getName());
		System.out.println("Basis for taxes " + income);
	}
}
