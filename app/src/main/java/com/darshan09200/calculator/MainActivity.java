package com.darshan09200.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView clearAll, percent, divide, number9, number8, number7, number6, number5, number4, number3, number2, number1, number0, decimal, equals;
    ImageButton multiply, subtract, add, clear;

    TextView textView;

    ArithmeticOperation calculationOperation;
    Operations currentOperation;
    Operations lastOperation;
    String currentNumber = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        clearAll = findViewById(R.id.clearAll);
        percent = findViewById(R.id.percent);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        multiply = findViewById(R.id.multiply);
        subtract = findViewById(R.id.subtract);
        add = findViewById(R.id.add);
        number9 = findViewById(R.id.number9);
        number8 = findViewById(R.id.number8);
        number7 = findViewById(R.id.number7);
        number6 = findViewById(R.id.number6);
        number5 = findViewById(R.id.number5);
        number4 = findViewById(R.id.number4);
        number3 = findViewById(R.id.number3);
        number2 = findViewById(R.id.number2);
        number1 = findViewById(R.id.number1);
        number0 = findViewById(R.id.number0);
        decimal = findViewById(R.id.decimal);
        equals = findViewById(R.id.equals);

        textView.setText("");

        registerAsButton(clearAll);
        registerAsButton(percent);
        registerAsButton(divide);
        registerAsButton(clear);
        registerAsButton(multiply);
        registerAsButton(subtract);
        registerAsButton(add);
        registerAsButton(number9);
        registerAsButton(number8);
        registerAsButton(number7);
        registerAsButton(number6);
        registerAsButton(number5);
        registerAsButton(number4);
        registerAsButton(number3);
        registerAsButton(number2);
        registerAsButton(number1);
        registerAsButton(number0);
        registerAsButton(decimal);
        registerAsButton(equals);

    }

    public void registerAsButton(View view) {
        SimulateButton.apply(view);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Operations pressedOperation = null;
        switch (view.getId()) {
            case R.id.clearAll:
                calculationOperation = null;
                currentOperation = null;
                lastOperation = null;
                currentNumber = "";

                System.out.println("clearAll");
                break;
            case R.id.percent:
                pressedOperation = Operations.PERCENT;
                System.out.println("percent");
                break;
            case R.id.divide:
                pressedOperation = Operations.DIVIDE;
                System.out.println("divide");
                break;
            case R.id.clear:
                if (lastOperation == Operations.NUMBER && currentNumber.length() > 0) {
                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                }
                System.out.println("clear");
                break;
            case R.id.multiply:
                pressedOperation = Operations.MULTIPLY;
                System.out.println("multiply");
                break;
            case R.id.subtract:
                pressedOperation = Operations.SUBTRACT;
                System.out.println("subtract");
                break;
            case R.id.add:
                pressedOperation = Operations.ADD;
                break;
            case R.id.number9:
                currentNumber += "9";
                System.out.println("number9");
                break;
            case R.id.number8:
                currentNumber += "8";
                System.out.println("number8");
                break;
            case R.id.number7:
                currentNumber += "7";
                System.out.println("number7");
                break;
            case R.id.number6:
                currentNumber += "6";
                System.out.println("number6");
                break;
            case R.id.number5:
                currentNumber += "5";
                System.out.println("number5");
                break;
            case R.id.number4:
                currentNumber += "4";
                System.out.println("number4");
                break;
            case R.id.number3:
                currentNumber += "3";
                System.out.println("number3");
                break;
            case R.id.number2:
                currentNumber += "2";
                System.out.println("number2");
                break;
            case R.id.number1:
                currentNumber += "1";
                System.out.println("number1");
                break;
            case R.id.number0:
                currentNumber += "0";
                System.out.println("number0");
                break;
            case R.id.decimal:
                currentNumber += ".";
                System.out.println("decimal");
                break;
            case R.id.equals:
                pressedOperation = Operations.EQUALS;
                break;
        }
        if (pressedOperation != null) {
            if (lastOperation != Operations.NUMBER) {
                currentOperation = pressedOperation;
            } else {
                System.out.println(currentNumber + " " + pressedOperation + " " + currentOperation);
                ArithmeticOperation number = new ArithmeticOperation(Operations.NUMBER, Double.parseDouble(currentNumber));
                currentNumber = "";
                if (calculationOperation != null && calculationOperation != null)
                    calculationOperation = new ArithmeticOperation(
                            currentOperation,
                            calculationOperation,
                            number
                    );
                else calculationOperation = number;
                System.out.println(calculationOperation);
//            textView.setText(textView.getText() + pressedOperation.toString());
                if (pressedOperation == Operations.EQUALS) {
                    double ans = calculationOperation.evaluate();
                    String convertedNumber = String.valueOf(ans);
                    currentNumber = convertedNumber.contains(".") ? convertedNumber.replaceAll("0*$", "").replaceAll("\\.$", "") : convertedNumber;
                    calculationOperation = null;
                    System.out.println(currentNumber + " " + convertedNumber + " " + currentNumber);
                    textView.setText(currentNumber);
                    currentOperation = null;
                    pressedOperation = Operations.NUMBER;
                } else {
                    currentOperation = pressedOperation;
                }
                System.out.println(calculationOperation);
            }
            lastOperation = pressedOperation;
        } else {
            textView.setText(currentNumber);
            lastOperation = Operations.NUMBER;
        }
    }

}