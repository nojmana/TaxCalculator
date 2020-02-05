package com.bartoszwalter.students.taxes;

import java.util.HashMap;

public class Output {

	public Output () {}

	public void printValuesWithLabels(HashMap<String, Object> valuesToPrint){
		for (String key : valuesToPrint.keySet()) {
			System.out.println(key + ": " + valuesToPrint.get(key));
		}
	}


}
