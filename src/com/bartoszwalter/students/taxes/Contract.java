package com.bartoszwalter.students.taxes;

import java.util.LinkedHashMap;

public abstract class Contract {

    protected double income;

    private double incomeCost;
    private double healthInsuranceAndTaxBasis;
    private double healthInsuranceTax9Percent;
    private double healthInsuranceTax7Percent;
    private double advanceTax;
    private long advanceTaxOffice;

    Contract(double income) {
        this.income = income;
    }

    public double getHealthInsuranceAndTaxBasis() {
        return healthInsuranceAndTaxBasis;
    }

    abstract String getName();

    abstract double calculateIncomeCost();

    abstract double getExemptedValue();

    public LinkedHashMap<String, Object> calculate() {
        LinkedHashMap<String, Object> calculatedValues = new LinkedHashMap<>();
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

    private double calculateSocialTaxes(LinkedHashMap<String, Object> calculatedValues) {
        double pensionTax = calculatePensionTax();
        calculatedValues.put("Pension tax", pensionTax);
        double disabilityTax = calculateDisabilityTax();
        calculatedValues.put("Disability tax", disabilityTax);
        double illnessInsurance = calculateIllnessInsurance();
        calculatedValues.put("Illness insurance", illnessInsurance);

        return pensionTax + disabilityTax + illnessInsurance;
    }

    private void calculateHealthInsurance(LinkedHashMap<String, Object> calculatedValues, double healthInsuranceAndTaxBasis) {
        calculatedValues.put("Health insurance basis", healthInsuranceAndTaxBasis);
        healthInsuranceTax9Percent = calculateHealthInsuranceTax9Percent(healthInsuranceAndTaxBasis);
        calculatedValues.put("Health insurance 9%", healthInsuranceTax9Percent);
        healthInsuranceTax7Percent = calculateHealthInsuranceTax7Percent(healthInsuranceAndTaxBasis);
        calculatedValues.put("Health insurance 7.75%", healthInsuranceTax7Percent);
    }

    private void calculateAdvanceTaxes(LinkedHashMap<String, Object> calculatedValues) {
        long advanceTaxBasis = calculateAdvanceTaxBasis();
        calculatedValues.put("Advance tax basis", advanceTaxBasis);
        advanceTax = calculateAdvanceTax(advanceTaxBasis);
        calculatedValues.put("Advance for income tax", advanceTax);
        advanceTaxOffice = calculateAdvanceTaxOffice();
        calculatedValues.put("Advance for tax office", advanceTaxOffice);
    }

    private double calculatePensionTax() {
        return income * 0.0976;
    }

    private double calculateDisabilityTax() {
        return income * 0.015;
    }

    private double calculateIllnessInsurance() {
        return income * 0.0245;
    }

    private double calculateHealthInsuranceBasis(double socialTaxes) {
        return income - socialTaxes;
    }

    private double calculateHealthInsuranceTax9Percent(double healthInsuranceBasis) {
        return healthInsuranceBasis * 0.09;
    }

    private double calculateHealthInsuranceTax7Percent(double healthInsuranceBasis) {
        return healthInsuranceBasis * 0.0775;
    }

    private long calculateAdvanceTaxBasis() {
        return Math.round(healthInsuranceAndTaxBasis - incomeCost);
    }

    private double calculateAdvanceTax(long advanceTaxBasis) {
        return advanceTaxBasis * 0.18;
    }

    public long calculateAdvanceTaxOffice() {
        return Math.round(advanceTax - healthInsuranceTax7Percent - getExemptedValue());
    }

    private double calculateSalary(double socialTaxes) {
        return income - (socialTaxes + healthInsuranceTax9Percent + advanceTaxOffice);
    }
}
