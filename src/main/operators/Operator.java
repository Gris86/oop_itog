package main.operators;

import main.ComplexNumber;

public interface Operator {
    ComplexNumber perform(ComplexNumber input, ComplexNumber input2);
    String getCharacter();
}
