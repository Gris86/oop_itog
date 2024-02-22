package main;
public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public String getMathRepresentation() {
        if (real == 0 && imaginary == 0) return "0.0";
        return (real == 0 ? "" : real + " ") + (imaginary < 0 ? "-" : "+") + " " + (Math.abs(imaginary) == 1 ? "" : Math.abs(imaginary)) + "i";
    }

    @Override
    public String toString() {
        return "ComplexNumber{real=" + real + ", imaginary=" + imaginary + ", mathRepresentation='" + getMathRepresentation() + "'}";
    }
}
