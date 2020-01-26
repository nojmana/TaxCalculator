package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

	public static void main(String[] args) {
		Contract contract = new Input().read();
		new Output(contract).print();
	}



	public static void calculateBasis(double basis) {

	}

	

	public static void calculateInsurance(double basis) {
		t_health1 = (basis * 9) / 100;
		t_health2 = (basis * 7.75) / 100;
	}
}
