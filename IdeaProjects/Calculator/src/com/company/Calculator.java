package com.company;

import java.util.List;

public class Calculator {
    private static Calculator instance;

    private String[] numbersA = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] numbersR = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX", "X"};
    private String s;
    private Number num;

    private Calculator(String s){
        this.s = s;

        SetNum();
    }

    public static Calculator getInstance(String s){
        if(instance == null){
            instance = new Calculator(s);
        }

        return instance;
    }

    private void SetNum(){
        num = new Number(s);
    }

    private boolean IsEqual(String[] s,String part){
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(part) ){
                return true;
            }
        }

        return false;
    }

    private int Pos(String[] a, String part){
        for(int i = 0; i < a.length; i++){
            if(a[i].equals(part)){
                return ++i;
            }
        }

        return -1;
    }

    public String Result(){
        if(IsEqual(numbersA, num.GetNumber1()) && IsEqual(numbersA, num.GetNumber2())){
            if(num.GetOperation().equals("+")) {
                return Integer.toString(Integer.parseInt(num.GetNumber1()) + Integer.parseInt(num.GetNumber2()));
            }
            if(num.GetOperation().equals("-")) {
                return Integer.toString(Integer.parseInt(num.GetNumber1()) - Integer.parseInt(num.GetNumber2()));
            }
            if(num.GetOperation().equals("/")) {
                return Integer.toString(Integer.parseInt(num.GetNumber1()) / Integer.parseInt(num.GetNumber2()));
            }
            if(num.GetOperation().equals("*")) {
                return Integer.toString(Integer.parseInt(num.GetNumber1()) * Integer.parseInt(num.GetNumber2()));
            }
        }
        if(IsEqual(numbersR, num.GetNumber1()) && IsEqual(numbersR, num.GetNumber2())){
            if(num.GetOperation().equals("+")) {
                int number = Pos(numbersR, num.GetNumber1()) + Pos(numbersR, num.GetNumber2());
                return convert(number);
            }
            if(num.GetOperation().equals("-")) {
                int number = Pos(numbersR, num.GetNumber1()) - Pos(numbersR, num.GetNumber2());
                return convert(number);
            }
            if(num.GetOperation().equals("/")) {
                int number = Pos(numbersR, num.GetNumber1()) / Pos(numbersR, num.GetNumber2());
                return convert(number);
            }
            if(num.GetOperation().equals("*")) {
                int number = Pos(numbersR, num.GetNumber1()) * Pos(numbersR, num.GetNumber2());
                return convert(number);
            }
        }

        return "упс что то пошло не так";
    }

    public static String convert(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}