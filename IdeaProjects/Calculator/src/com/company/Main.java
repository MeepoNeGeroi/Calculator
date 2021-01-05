package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Calculator cal = Calculator.getInstance(s);
        System.out.println(cal.Result());
    }
}
