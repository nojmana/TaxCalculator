package com.bartoszwalter.students.taxes;

public class CivilContract extends Contract {
	
	public CivilContract(double income){
		super(income);
	}
	
	@Override
	String getName(){
		return "Civil Contract";
	}

	@Override
	double calculateIncomeCost() {
		//TODO
		return 0;
	}

	@Override
	double getExemptedValue() {
		//TODO
		return 0;
	}
}
