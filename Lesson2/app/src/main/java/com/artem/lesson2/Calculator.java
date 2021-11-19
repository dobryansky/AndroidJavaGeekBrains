package com.artem.lesson2;

public class Calculator {
    String input1;
    String input2;
    String operation;

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Calculator(String input1, String input2, String operation) {
        this.input1 = input1;
        this.input2 = input2;
        this.operation = operation;
    }

     double sum(){
        return Double.parseDouble(input1)+Double.parseDouble(input2);

    }

     double sub(){
        return Double.parseDouble(input1)-Double.parseDouble(input2);
    }


     double div(){
            return Double.parseDouble(input1) / Double.parseDouble(input2);

    }

    double mult(){
        return Double.parseDouble(input1) / Double.parseDouble(input2);

    }
    private double percent(){
        return Double.parseDouble(input1) / Double.parseDouble(input2);

    }
}
