package org.example;

import java.util.*;

import bussinessmodel.*;
import datamodels.*;
public class Main {
    public static void main(String[] args) {

        ///                 TESTING / DEBUGGING

        String pString = "  3x^2 -x";
        String qString = "4";
        Polinom P = Polinom.splitPolynomial(pString);
        Polinom Q = Polinom.splitPolynomial(qString);
        Operations operations = new Operations(P,Q);

        //System.out.println("addition: "  + operations.add().toString());

        System.out.println(P.toString());
//        System.out.println("multiplication: " + operations.multiply().toString());
//        System.out.println("derivative: " + operations.derivate(P).toString());
       // System.out.println("integrate: " + operations.integrate(P).toString());

        String monomAsString = "-x";
       //Monom monom = Monom.splitMonom(monomAsString);

       // System.out.println(monom.toString());
        //System.out.println(operations.add().toString());
    }
}
