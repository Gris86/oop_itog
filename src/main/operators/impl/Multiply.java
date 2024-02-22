package main.operators.impl;

import main.ComplexNumber;
import main.operators.Operator;

public class Multiply implements Operator {

    @Override
    public ComplexNumber perform(ComplexNumber input, ComplexNumber input2) {
        return new ComplexNumber(input.real * input2.real - input.imaginary * input2.imaginary, input.real * input2.imaginary + input2.real * input.imaginary);
    }

    @Override
    public String getCharacter() {
        return "*";
    }
    
}
