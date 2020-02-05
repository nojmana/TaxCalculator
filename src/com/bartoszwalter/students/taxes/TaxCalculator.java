package com.bartoszwalter.students.taxes;

import java.util.HashMap;

public class TaxCalculator {

	public static void main(String[] args) {
		Contract contract = new Input().read();
		HashMap<String, Object> calculatedValuesWithLabels = contract.calculate();
		new Output().printValuesWithLabels(calculatedValuesWithLabels);
	}
}
