package datamodels;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static datamodels.Monom.splitMonom;

public class Polinom {
    private HashMap<Integer, Monom> polinomMap;
    public Polinom(HashMap <Integer, Monom> map){
        this.polinomMap =map;
    }

    public static Polinom splitPolynomial(String polynomialAsString) {
        HashMap<Integer, Monom> monoms = new HashMap<>();

        String[] monomialStrings = polynomialAsString.split("(?=[+-])");

        for (String currentString : monomialStrings) {
            if (currentString.isEmpty()) {
                continue;
            }

            Monom monom = splitMonom(currentString);
            int degree = monom.getGrade();
            double coeficient = monom.getCoeficient();

            Monom newMonom = new Monom(degree, coeficient);
            monoms.put(degree, newMonom);
        }

        return new Polinom(monoms);
    }

    public HashMap<Integer, Monom> getPolinomMap() {
        return polinomMap;
    }



    public String toString() {

        List<Integer> sortedGrades = new ArrayList<>(polinomMap.keySet());
        Collections.sort(sortedGrades,Collections.reverseOrder());

        StringBuilder result = new StringBuilder();

        for (int grade : sortedGrades) {
            Monom monom = polinomMap.get(grade);
            if (monom == null) {
                continue;
            }
            double coefficient = monom.getCoeficient();
            if (coefficient == 0) {
                continue;
            } else if (coefficient < 0) {
                result.append("-");
            } else {
                result.append("+");
            }

            if (grade == 1) {
                if (coefficient == 1.0 || coefficient == -1.0) {
                    result.append("x");
                }else{
                    result.append(Math.abs(coefficient)).append("x");
                }
            } else if (grade == 0) {
                result.append(Math.abs(coefficient));
            } else {
                if (coefficient == 1.0 || coefficient == -1.0) {
                    result.append("x^").append(grade);
                } else {
                    result.append(Math.abs(coefficient)).append("x^").append(grade);
                }
            }
        }

        if (result.length() == 0) {
            result.append(0);
        }

        if (result.charAt(0) == '+') {
            result.deleteCharAt(0);
        }

        return String.valueOf(result);
    }


}
