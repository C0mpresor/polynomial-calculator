package datamodels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {
    private int grade;
    private double coeficient;

    public Monom(int grade, double coeficient) {
        this.grade = grade;
        this.coeficient = coeficient;
    }

    public static Monom splitMonom(String monomAsString) {
        int grade = 0;
        double coefficient = 0;
        if (monomAsString.replace(" ","").equals("+x") || monomAsString.replace(" ","").equals("-x") || monomAsString.replace(" ","").equals("x")) {
            coefficient = monomAsString.startsWith("-") ? -1 : 1;
            grade = 1;
        } else {
            Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d?)([a-z])\\^(\\d+)");
            Matcher matcher = pattern.matcher(monomAsString);
            boolean success = matcher.find();
            if (success) {
                grade = Integer.valueOf(matcher.group(3));
                coefficient = Double.parseDouble(matcher.group(1));
            } else {
                pattern = Pattern.compile("(-?[a-z])\\^(\\d+)");
                matcher = pattern.matcher(monomAsString);
                boolean succes = matcher.find();
                if (succes) {
                    grade = Integer.valueOf(matcher.group(2));
                    coefficient = matcher.group(1).equals("-x") ? -1 : 1;
                } else {
                    //
                    pattern = Pattern.compile("([+-]?\\d+(\\.\\d+)?)([a-z])");
                    matcher = pattern.matcher(monomAsString);
                    success = matcher.find();
                    if (success) {
                        grade = 1;
                        coefficient = Double.parseDouble(matcher.group(1));
                    } else {
                        pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)");
                        matcher = pattern.matcher(monomAsString);
                        success = matcher.find();
                        if (success) {
                            grade = 0;
                            coefficient = Double.parseDouble(matcher.group(1));
                        }
                    }
                }
            }
        }

        return new Monom(grade, coefficient);
    }

    public double getCoeficient() {
        return coeficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }


    public String toString() {
        StringBuilder result = new StringBuilder();

        if (grade == 0) {
            result.append(String.valueOf(coeficient));
        } else if (grade == 1) {
            if (coeficient == 1 || coeficient == 1.0) {
                result.append("+x");
            } else if (coeficient == -1 || coeficient == -1.0){
                result.append("-x");
            }else {
                result.append(String.valueOf(coeficient)).append("x");
            }
        } else {
            if (coeficient == 1 || coeficient == 1.0) {
                result.append("+x^").append(grade);
            } else if (coeficient == -1 || coeficient == 1.0) {
                result.append("-x^").append(grade);
            } else {
                result.append(String.valueOf(coeficient)).append("x^").append(grade);
            }
        }

        return result.toString();
    }

    public Monom addMonomial(Monom x){
        if(this.grade == x.getGrade()){
            this.coeficient += x.getCoeficient();
        }
        return new Monom(grade,coeficient);
    }

    public Monom substractMonomial(Monom x){
        if(this.grade == x.getGrade()){
            this.coeficient -= x.getCoeficient();
        }
        return new Monom(grade,coeficient);
    }

}

