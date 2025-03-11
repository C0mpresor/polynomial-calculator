package graficuserinterface;

import bussinessmodel.Operations;
import datamodels.Polinom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class polinomGUI extends JFrame{

    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivButtonP;
    private JPanel calculator;
    private JButton integrateP;
    private JTextField inputP;
    private JTextField inputQ;
    private JTextField resultField;
    private JButton derivButtonQ;
    private JButton integrateQ;
    //private JButton computeButton;


    public polinomGUI() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.add().toString());
            }
        });

        substractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.subtract().toString());
            }
        });
        derivButtonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.derivate(polinomP).toString());
            }
        });
        derivButtonQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.derivate(polinomQ).toString());
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.multiply().toString());
            }
        });
        integrateP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.integrate(polinomP).toString());
            }
        });
        integrateQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polinomP = Polinom.splitPolynomial(inputP.getText());
                Polinom polinomQ = Polinom.splitPolynomial(inputQ.getText());
                Operations operations = new Operations(polinomP,polinomQ);
                resultField.setText(operations.integrate(polinomQ).toString());
            }
        });
    }



    public static void main(String[] args) {
        polinomGUI p = new polinomGUI();
        p.setContentPane(p.calculator);
        p.setVisible(true);
        p.setTitle("Polynomial Calculator");
        p.setSize(600,700);
        p.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


}
