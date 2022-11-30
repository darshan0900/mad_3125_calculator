package com.darshan09200.calculator;

enum Operations {
    NUMBER,
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    EQUALS
}

public class ArithmeticOperation {
    Operations operation;
    double number;
    ArithmeticOperation leftNumber;
    ArithmeticOperation rightNumber;

    public ArithmeticOperation(Operations operation, double number) {
        this.operation = operation;
        this.number = number;
    }

    public ArithmeticOperation(Operations operation, ArithmeticOperation leftNumber) {
        this.operation = operation;
        this.leftNumber = leftNumber;
    }

    public ArithmeticOperation(Operations operation, ArithmeticOperation leftNumber, ArithmeticOperation rightNumber) {
        this.operation = operation;
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    public double evaluate() {
        switch (operation) {
            case ADD:
                return leftNumber.evaluate()
                        + rightNumber.evaluate();
            case SUBTRACT:
                return leftNumber.evaluate()
                        - rightNumber.evaluate();
            case DIVIDE:
                return leftNumber.evaluate() / rightNumber.evaluate();
            case MULTIPLY:
                return leftNumber.evaluate() * rightNumber.evaluate();
            case PERCENT:
                return leftNumber.evaluate() / 100;
            case NUMBER:
            default:
                return number;
        }
    }

    @Override
    public String toString() {
        return "ArithmeticOperation{" +
                "operation=" + operation +
                ", number=" + number +
                ", leftNumber=" + leftNumber +
                ", rightNumber=" + rightNumber +
                '}';
    }
    //    public String toString(String operator) {
//        String desc = "";
//        if (!(leftNumber instanceof Number)) {
//            desc += "(";
//        }
//        desc += leftNumber;
//        if (!(leftNumber instanceof Number)) {
//            desc += ")";
//        }
//        desc += " "+operator+" ";
//        if (!(rightNumber instanceof Number)) {
//            desc += "(";
//        }
//        desc += rightNumber;
//        if (!(rightNumber instanceof Number)) {
//            desc += ")";
//        }
//
//        return desc;
//    }
}
