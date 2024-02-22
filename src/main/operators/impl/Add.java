package main.operators.impl;

import main.ComplexNumber;
import main.operators.Operator;

public class Add implements Operator {

    @Override
    public ComplexNumber perform(ComplexNumber input1, ComplexNumber input2) {
        return new ComplexNumber(input1.real + input2.real, input1.imaginary + input2.imaginary);
    }

    @Override
    public String getCharacter() {
        return "+";
    }
    
}
