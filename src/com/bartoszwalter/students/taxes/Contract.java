package com.bartoszwalter.students.taxes;

import java.util.HashMap;

public abstract class Contract {

	protected double income;

	private double incomeCost;
	private double healthInsuranceAndTaxBasis;
	private double healthInsuranceIncomePart;
	private double healthInsuranceTaxOfficePart;
	private double advanceTax;
	private long advanceTaxOffice;

	Contract(double income){
		this.income = income;
	}

	public double getHealthInsuranceAndTaxBasis() {
		return healthInsuranceAndTaxBasis;
	}

	abstract String getName();
	abstract double calculateIncomeCost();
	abstract double getExemptedValue();

	public HashMap<String, Object> calculate(){
		HashMap<String, Object> calculatedValues = new HashMap<>();
		calculatedValues.put("Contract type", getName());
		calculatedValues.put("Basis for taxes", income);

		double socialTaxes = calculateSocialTaxes(calculatedValues);

		healthInsuranceAndTaxBasis = calculateHealthInsuranceBasis(socialTaxes);

		calculateHealthInsurance(calculatedValues, healthInsuranceAndTaxBasis);

		incomeCost = calculateIncomeCost();
		calculatedValues.put("Constant income tax cost", incomeCost);

		calculateAdvanceTaxes(calculatedValues);

		double salary = calculateSalary(socialTaxes);
		calculatedValues.put("Net salary", salary);

		return calculatedValues;
	}

	private double calculateSocialTaxes(HashMap<String, Object> calculatedValues){
		double pensionTax = calculatePensionTax();
		calculatedValues.put("Pension tax", pensionTax);
		double disabilityTax = calculateDisabilityTax();
		calculatedValues.put("Disability tax", disabilityTax);
		double illnessInsurance = calculateIllnessInsurance();
		calculatedValues.put("Illness insurance", illnessInsurance);

		return pensionTax + disabilityTax + illnessInsurance;
	}

	private void calculateHealthInsurance(HashMap<String, Object> calculatedValues, double healthInsuranceAndTaxBasis){
		calculatedValues.put("Health insurance basis", healthInsuranceAndTaxBasis);
		healthInsuranceIncomePart = calculateHealthInsuranceIncomePart(healthInsuranceAndTaxBasis);
		calculatedValues.put("Health insurance 9%", healthInsuranceIncomePart);
		healthInsuranceTaxOfficePart = calculateHealthInsuranceTaxOfficePart(healthInsuranceAndTaxBasis);
		calculatedValues.put("Health insurance 7.75%", healthInsuranceTaxOfficePart);
	}

	private void calculateAdvanceTaxes(HashMap<String, Object> calculatedValues){
		long advanceTaxBasis = calculateAdvanceTaxBasis();
		calculatedValues.put("Advance tax basis", advanceTaxBasis);
		advanceTax = calculateAdvanceTax(advanceTaxBasis);
		calculatedValues.put("Advance for income tax", advanceTax);
		advanceTaxOffice = calculateAdvanceTaxOffice();
		calculatedValues.put("Advance for tax office", advanceTaxOffice);
	}

	private double calculatePensionTax(){
		return income * 0.0976;
	}

	private double calculateDisabilityTax(){
		return income * 0.015;
	}

	private double calculateIllnessInsurance(){
		return income * 0.0245;
	}

	private double calculateHealthInsuranceBasis(double socialTaxes){
		return income - socialTaxes;
	}

	//TODO think of rename
	private double calculateHealthInsuranceIncomePart(double healthInsuranceBasis){
		return healthInsuranceBasis * 0.09;
	}

	//TODO think of rename
	private double calculateHealthInsuranceTaxOfficePart(double healthInsuranceBasis){
		return healthInsuranceBasis * 0.09;
	}

	private long calculateAdvanceTaxBasis(){
		return Math.round(healthInsuranceAndTaxBasis - incomeCost);
	}

	private double calculateAdvanceTax(long advanceTaxBasis){
		return advanceTaxBasis * 0.18;
	}

	public long calculateAdvanceTaxOffice() {
		return Math.round(advanceTax - healthInsuranceTaxOfficePart - getExemptedValue());
	}

	private double calculateSalary(double socialTaxes){
		return income - (socialTaxes + healthInsuranceIncomePart + advanceTaxOffice);
	}
}
