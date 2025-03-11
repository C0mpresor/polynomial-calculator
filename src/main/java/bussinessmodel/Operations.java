package bussinessmodel;

import datamodels.*;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Operations {
    private static Polinom polinomP;
    private static Polinom polinomQ;

    public Operations(Polinom polinomP, Polinom polinomQ) {
        this.polinomP = polinomP;
        this.polinomQ = polinomQ;
    }

    public static Polinom add() {
        //creating map for the result
        HashMap<Integer, Monom> resultMonoms = new HashMap<>();
        double newCoeficient = 0;
        //iterating trough first polynomial
        for (int gradeP : polinomP.getPolinomMap().keySet()) {
            Monom monomP = polinomP.getPolinomMap().get(gradeP);
            //checking if a grade exists in the second polynomial
            if (polinomQ.getPolinomMap().containsKey(gradeP)) {
                Monom monomQ = polinomQ.getPolinomMap().get(gradeP);
                newCoeficient = monomP.getCoeficient() + monomQ.getCoeficient();
                resultMonoms.put(gradeP, new Monom(gradeP, newCoeficient));
            } else {
                resultMonoms.put(gradeP, monomP);
            }
        }
        //iterating trough second polynomial
        for (int gradeQ : polinomQ.getPolinomMap().keySet()) {
            //check if the grade was already dealt with or not
            if (!(polinomP.getPolinomMap().containsKey(gradeQ))) {
                Monom monomQ = polinomQ.getPolinomMap().get(gradeQ);
                resultMonoms.put(gradeQ, monomQ);
            }
        }
        return new Polinom(resultMonoms);
    }

    public static Polinom subtract() {
        //creating map for the result
        HashMap<Integer, Monom> resultMonoms = new HashMap<>();
        double newCoeficient = 0;
        //itegratinig trough first polynomial
        for (int gradeP : polinomP.getPolinomMap().keySet()) {
            Monom monomP = polinomP.getPolinomMap().get(gradeP);
            //checking if a grade exists in the second polynomial
            if (polinomQ.getPolinomMap().containsKey(gradeP)) {
                Monom monomQ = polinomQ.getPolinomMap().get(gradeP);
                newCoeficient = monomP.getCoeficient() - monomQ.getCoeficient();
                resultMonoms.put(gradeP, new Monom(gradeP, newCoeficient));
            } else {
                resultMonoms.put(gradeP, monomP);
            }
        }
        //iterating trough second polynomial
        for (int gradeQ : polinomQ.getPolinomMap().keySet()) {
            //checking if the grade was already dealt with
            if (!(polinomP.getPolinomMap().containsKey(gradeQ))) {
                Monom monomQ = polinomQ.getPolinomMap().get(gradeQ);
                resultMonoms.put(gradeQ, monomQ);
            }
        }
        return new Polinom(resultMonoms);
    }

    public static Polinom multiply() {
        HashMap<Integer, Monom> resultMonoms = new HashMap<>();
        int newGrade = 0;
        double newCoeficient = 0;
        for (int gradeP : polinomP.getPolinomMap().keySet()) {
            Monom monomP = polinomP.getPolinomMap().get(gradeP);
            for (int gradeQ : polinomQ.getPolinomMap().keySet()) {
                Monom monomQ = polinomQ.getPolinomMap().get(gradeQ);
                newGrade = gradeP + gradeQ;
                newCoeficient = monomP.getCoeficient() * monomQ.getCoeficient();
                //checking if the grade already exists, and if so we add the coeficent values
                if (resultMonoms.containsKey(newGrade)) {
                    Monom newMonom = resultMonoms.get(newGrade);
                    resultMonoms.put(newGrade, newMonom.addMonomial(new Monom(newGrade, newCoeficient)));
                } else {
                    resultMonoms.put(newGrade, new Monom(newGrade, newCoeficient));
                }
            }
        }

        return new Polinom(resultMonoms);
    }

    public static Polinom derivate(Polinom polinomA) {
        HashMap<Integer, Monom> resultMonoms = new HashMap<>();
        int newGrade;
        double newCoeficient;

        for (int grade : polinomA.getPolinomMap().keySet()) {
            Monom monom = polinomA.getPolinomMap().get(grade);
            newCoeficient = monom.getCoeficient() * monom.getGrade();
            newGrade = monom.getGrade() - 1;
            resultMonoms.put(newGrade, new Monom(newGrade, newCoeficient));
        }
        return new Polinom(resultMonoms);
    }

    public static Polinom integrate(Polinom polinomA) {
        HashMap<Integer, Monom> resultMonoms = new HashMap<>();
        int newGrade;
        double newCoeficient;

        for (int grade : polinomA.getPolinomMap().keySet()) {
            Monom monom = polinomA.getPolinomMap().get(grade);
            newGrade = monom.getGrade() + 1;
            newCoeficient = monom.getCoeficient() / newGrade;
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String newCoef2Digits = decimalFormat.format(newCoeficient);
            newCoeficient = Double.parseDouble(newCoef2Digits);
            resultMonoms.put(newGrade, new Monom(newGrade, newCoeficient));
        }
        return new Polinom(resultMonoms);
    }

}
