package com.bartoszwalter.students.taxes;

import java.util.LinkedHashMap;

public class TaxCalculator {

    public static void main(String[] args) {
        Contract contract = new Input().read();
        LinkedHashMap<String, Object> calculatedValuesWithLabels = contract.calculate();
        new Output().printValuesWithLabels(calculatedValuesWithLabels);
    }
}
