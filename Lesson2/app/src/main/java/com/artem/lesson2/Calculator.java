package com.artem.lesson2;

public class Calculator {
    String input1;
    String input2;
    String operation;

    public Calculator(String input1, String input2, String operation) {
        this.input1 = input1;
        this.input2 = input2;
        this.operation = operation;
    }

    private double sum(){
        return Double.parseDouble(input1)+Double.parseDouble(input2);

    }

    private double sub(){
        return Double.parseDouble(input1)-Double.parseDouble(input2);
    }


    private double div(){
            return Double.parseDouble(input1) / Double.parseDouble(input2);

    }
}
