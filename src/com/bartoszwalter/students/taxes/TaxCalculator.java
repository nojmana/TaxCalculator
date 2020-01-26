package com.bartoszwalter.students.taxes;

public class TaxCalculator {

	public static void main(String[] args) {
		Contract contract = new Input().read();
		new Output(contract).print();
	}
}
