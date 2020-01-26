package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Output {
	DecimalFormat df00 = new DecimalFormat("#.00");
	DecimalFormat df = new DecimalFormat("#");

	public Output(){

	}

	//TODO think about this name
	public void print(HashMap<String, Object> valuesToPrint){
		for (String key :
				valuesToPrint.keySet()) {
			Object value = valuesToPrint.get(key);
			if(value.getClass() == String.class){
				String valueAsString = (String) value;
				System.out.printf("%s: %s", key, valueAsString);
			} else {
				System.out.printf("%s: %d", key, value);
			}
		}
//		System.out.println(contract.getName());
//		System.out.println("Basis for taxes " + income);
	}


}
