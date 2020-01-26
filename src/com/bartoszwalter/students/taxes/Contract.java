package com.bartoszwalter.students.taxes;

import java.util.HashMap;

public abstract class Contract {
	protected double income;

	// social taxes
	protected double pensionTax;
	protected double disabilityTax;
	protected double illnessInsurance;
	
	// health taxes
	public double incomeCost;
	public double healthInsuranceIncomePart;
	public double healthInsuranceTaxOfficePart;
	public double advanceTax;
	public double exemptedValue;
	public double advanceTaxOffice;
	public double advanceTaxOffice0;
	
	Contract(double income){
		this.income = income;
	}
	
	public HashMap<String, Object> calculate(){
		HashMap<String, Object> calculatedValues = new HashMap<>();
		calculatedValues.put("Contract type", getName());

		calculatedValues.put("Basis for taxes", income);

		pensionTax = calculatePensionTax();
		calculatedValues.put("Pension tax", pensionTax);
		disabilityTax = calculateDisabilityTax();
		calculatedValues.put("Disability tax", disabilityTax);
		illnessInsurance = calculateIllnessInsurance();
		calculatedValues.put("Illness insurance", illnessInsurance);

		double healthInsuranceBasis = calculateHealthInsuranceBasis();
		calculatedValues.put("Health insurance basis", healthInsuranceBasis);
		healthInsuranceIncomePart = calculateHealthInsuranceIncomePart(healthInsuranceBasis);
		healthInsuranceTaxOfficePart = calculateHealthInsuranceTaxOfficePart(healthInsuranceBasis);
		calculatedValues.put("Health insurance 9%", healthInsuranceIncomePart);
		calculatedValues.put("Health insurance 7.75%", healthInsuranceTaxOfficePart);

		incomeCost = calculateIncomeCost();
		calculatedValues.put("Constant income tax cost", incomeCost);

		return calculatedValues;
	}

	abstract String getName();

	abstract void calculateTax();
	abstract double calculateIncomeCost();

	abstract void calculateSalary();


	double calculatePensionTax(){
		return income * 0.0976;
	}

	double calculateDisabilityTax(){
		return income * 0.015;
	}

	double calculateIllnessInsurance(){
		return income * 0.0245;
	}

	double calculateHealthInsuranceBasis(){
		return income - pensionTax - disabilityTax - illnessInsurance;
	}

	//TODO think of rename
	double calculateHealthInsuranceIncomePart(double healthInsuranceBasis){
		return healthInsuranceBasis * 0.09;
	}

	//TODO think of rename
	double calculateHealthInsuranceTaxOfficePart(double healthInsuranceBasis){
		return healthInsuranceBasis * 0.09;
	}
	
	private double calculateAdvanceTax(double basis){
		return basis * 0.18;
	}

	public double calculateAdvance() {
		advanceTaxOffice = advanceTax - health2 - exemptedValue;
	}
}
