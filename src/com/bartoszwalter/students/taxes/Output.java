package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Output {

    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Output() {
    }

    public void printValuesWithLabels(LinkedHashMap<String, Object> valuesToPrint) {
        for (Map.Entry<String, Object> keyAndValue : valuesToPrint.entrySet()) {
            if (keyAndValue.getValue().getClass() == Double.class) {
                System.out.println(keyAndValue.getKey() + ": " + decimalFormat.format(keyAndValue.getValue()));
            } else {
                System.out.println(keyAndValue.getKey() + ": " + keyAndValue.getValue());
            }
        }
    }


}
