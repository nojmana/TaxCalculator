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
	void calculateTax() {
		
		double oBasis = calculatedBasis(income);
		System.out.println("Pension tax "
				+ df00.format(t_pension));
		System.out.println("Disability tax "
				+ df00.format(t_disabled));
		System.out.println("Illness insurance tax  "
				+ df00.format(s_illness));
		System.out
				.println("Basis for the health tax: "
						+ oBasis);
		calculateInsurance(oBasis);
		System.out.println("Healt tax: 9% = "
				+ df00.format(t_health1) + " 7,75% = " + df00.format(t_health2));
		exemptedValue = 0;
		incomeCost = (oBasis * 20) / 100;
		System.out.println("Income tax cost (constant) "
				+ incomeCost);
		double basisTax = oBasis - incomeCost;
		double basisTax0 = Double.parseDouble(df.format(basisTax));
		System.out.println("Basis tax " + basisTax
				+ " rouded " + df.format(basisTax0));
		calculateBasis(basisTax0);
		System.out.println("Advance for income tax 18 % = "
				+ advanceTax);
		double taxTaken = advanceTax;
		System.out.println("Tax taken = "
				+ df00.format(taxTaken));
		calculateAdvance();
		advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
		System.out.println("Advance for tax office = "
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
