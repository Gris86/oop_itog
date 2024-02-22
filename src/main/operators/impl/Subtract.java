package main.operators.impl;

import main.ComplexNumber;
import main.operators.Operator;

public class Subtract implements Operator {

    @Override
    public ComplexNumber perform(ComplexNumber input, ComplexNumber input2) {
        return new ComplexNumber(input.real - input2.real, input.imaginary - input2.imaginary);
    }

    @Override
    public String getCharacter() {
        return "-";
    }
    
}
