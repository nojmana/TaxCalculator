package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

    public Contract read() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Double income = null;
        while (income == null) {
            try {
                System.out.print("Provide income: ");
                income = Double.parseDouble(br.readLine());
            } catch (Exception ex) {
                System.out.println("Incorrect value");
                System.err.println(ex.getMessage());
            }
        }
        Contract contract = null;
        while (contract == null) {
            try {
                System.out.print("Contract type: (O)rdinary, (C)ivil: ");
                contract = setupContract(br.readLine().charAt(0), income);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return contract;
    }

    private Contract setupContract(char contractTypeFirstCharacter, double income) throws Exception {
        switch (contractTypeFirstCharacter) {
            case 'C':
                return new CivilContract(income);
            case 'O':
                return new OrdinaryContract(income);
            default:
                throw new Exception("no contract type starting with that character");
        }
    }
}
