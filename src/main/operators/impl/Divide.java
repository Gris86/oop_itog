package main.operators.impl;

import main.ComplexNumber;
import main.operators.Operator;

public class Divide implements Operator {

    @Override
    public ComplexNumber perform(ComplexNumber input, ComplexNumber input2) {
        if (input2.real == 0 && input2.imaginary == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        System.out.println(
            (
                input2.real * input2.real + input2.imaginary * input2.imaginary
            )
        );
        return new ComplexNumber(
            (
                input.real * input2.real + input.imaginary * input2.imaginary
            ) / (
                input2.real * input2.real + input2.imaginary * input2.imaginary
            ),
            (
                input2.real * input.imaginary - input.real * input2.imaginary
            ) / (
                input2.real * input2.real + input2.imaginary * input2.imaginary
            )
        );
    }

    @Override
    public String getCharacter() {
        return "/";
    }
    
}
