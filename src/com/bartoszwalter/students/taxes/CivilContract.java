package com.bartoszwalter.students.taxes;

public class CivilContract extends Contract {

    public CivilContract(double income) {
        super(income);
    }

    @Override
    String getName() {
        return "Civil Contract";
    }

    @Override
    double calculateIncomeCost() {
        return getHealthInsuranceAndTaxBasis() * 0.2;
    }

    @Override
    double getExemptedValue() {
        return 0;
    }
}
