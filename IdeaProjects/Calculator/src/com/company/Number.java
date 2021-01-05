package com.company;

public class Number {
    private String[] operations = new String[]{"+", "-", "*", "/"};
    private String[] numbersA = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] numbersR = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX", "X"};
    private String number1;
    private String number2;
    private String operation;

    public String GetNumber1(){
        return number1;
    }
    public String GetNumber2(){
        return number2;
    }
    public String GetOperation(){
        return operation;
    }

    private boolean IsEqual(String[] s, String part){
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(part) ){
                return true;
            }
        }

        return false;
    }

    private boolean IsEqual(String[] s, String[] s2,String part){
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(part) || s2[i].equals(part) ){
                return true;
            }
        }

        return false;
    }

    public Number(String s){
        Parser pars = new Parser(s);
        pars.ParseString();
        Check(pars);
    }

    private void Check(Parser pars){
        if(IsEqual(numbersA, numbersR, pars.GetNumber1()) && IsEqual(numbersA, numbersR, pars.GetNumber2()) &&
                    IsEqual(operations, pars.GetOperation())){
            number1 = pars.GetNumber1();
            number2 = pars.GetNumber2();
            operation = pars.GetOperation();
        }



    }
}
