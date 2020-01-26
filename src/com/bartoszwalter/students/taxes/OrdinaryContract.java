package com.bartoszwalter.students.taxes;

public class OrdinaryContract extends Contract {

	public OrdinaryContract(double income){
		super(income);
	}

	@Override
	String getName(){
		return "Ordinary Contract";
	}
	
	@Override
	void calculateTax() {
		System.out.println("basis for taxes " + income);
		double cBasis = calculatedBasis(income);
		System.out.println("Pension tax basis "
				+ df00.format(t_pension));
		System.out.println("Disability tax basis "
				+ df00.format(t_disabled));
		System.out.println("Illness insurance basis  "
				+ df00.format(s_illness));
		System.out
				.println("Health insurance basis: "
						+ cBasis);
		calculateInsurance(cBasis);
		System.out.println("Health insutance: 9% = "
				+ df00.format(t_health1) + " 7,75% = " + df00.format(t_health2));
		System.out.println("Constant income tax cost "
				+ incomeCost);
		double taxBasis = cBasis - incomeCost;
		double taxBasis0 = Double
				.parseDouble(df.format(taxBasis));
		System.out.println("Tax basis " + taxBasis
				+ " rounded " + df.format(taxBasis0));
		calculateBasis(taxBasis0);
		System.out.println("Advance for income tax 18 % = "
				+ advanceTax);
		System.out.println("Exempted value = " + exemptedValue);
		double exemtedTax = advanceTax - exemptedValue;
		System.out.println("Exempted tax = "
				+ df00.format(exemtedTax));
		calculateAdvance();
		advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
		System.out.println("Advance for the tax office = "
				+ df00.format(advanceTaxOffice) + " rounded = "
				+ df.format(advanceTaxOffice0));
		double salary = income
				- ((t_pension + t_disabled + s_illness) + t_health1 + advanceTaxOffice0);
		System.out.println();
		System.out
				.println("Net salary = "
						+ df00.format(salary));
		
	}

	@Override
	void calculateSalary() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void calculateAdvanceTax() {
		// TODO Auto-generated method stub
		
	}
}
