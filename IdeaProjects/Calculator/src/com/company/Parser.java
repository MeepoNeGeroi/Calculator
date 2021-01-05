package com.company;

public class Parser {
    private String[] operations = new String[]{"+", "-", "*", "/"};
    private boolean fl = true;
    private String str;
    private String number1 = "";
    private String number2 = "";
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

    public Parser(String s){
        this.str = s.replaceAll(" ", "");
    }

    private boolean IsEqual(String[] s, String part){
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(part) ){
                return true;
            }
        }

        return false;
    }

    public void ParseString(){
        for(int i = 0; i < str.length(); i++){
            if(fl && !IsEqual(operations, Character.toString(str.charAt(i)) ) ){
                number1 += Character.toString(str.charAt(i));
            }
            if(!fl && !IsEqual(operations, Character.toString(str.charAt(i)) )){
                number2 += Character.toString(str.charAt(i));
            }
            if(IsEqual(operations, Character.toString(str.charAt(i)))){
                operation = Character.toString(str.charAt(i) );
                fl = false;
            }
        }
    }
}
