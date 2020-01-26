package com.bartoszwalter.students.taxes;

public abstract class Contract {
	protected double income;

	// social taxes
	protected double pensionTax = 0; // 9,76% of the income
	protected double disabledTax = 0; // 1,5% of the income
	protected double illnessTax = 0; // 2,45% of the income
	
	// health taxes
	public static double incomeCost = 111.25; 
	public static double t_health1 = 0; // 9% of the incomeCost
	public static double t_health2 = 0; // 7,75 % of the incomeCost
	public static double advanceTax = 0; // income tax (18%) advance
	public static double exemptedValue = 46.33; // reduced value 46,33 PLN
	public static double advanceTaxOffice = 0;
	public static double advanceTaxOffice0 = 0;
	
	Contract(double income){
		this.income = income;
	}
	
	abstract String getName();
	
	abstract void calculateTax();
	
	abstract void calculateSalary();
	
	abstract void calculateAdvanceTax();
	
	protected double calculateBasis(double basis) {
		pensionTax = (basis * 9.76) / 100;
		disabledTax = (basis * 1.5) / 100;
		illnessTax = (basis * 2.45) / 100;
		return (basis - pensionTax - disabledTax - illnessTax);
	}
}
