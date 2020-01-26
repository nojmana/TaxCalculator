package com.bartoszwalter.students.taxes;

public class OrdinaryContract extends Contract {

	public OrdinaryContract(double income){
		super(income);
	}

	@Override
	double calculateIncomeCost() {
		return 111.25;
	}

	@Override
	String getName(){
		return "Ordinary Contract";
	}

	@Override
	double getExemptedValue() {
		return 46.33;
	}
}
