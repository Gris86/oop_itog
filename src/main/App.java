package main;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.operators.OperatorManager;
import main.utils.InputReader;

public class App {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        logger.info("Калькулятор комплексных чисел запущен.");
        System.out.println("Первое число:");
        ComplexNumber firstNumber = InputReader.readComplexNumber();
        System.out.println("Второе число:");
        ComplexNumber secondNumber = InputReader.readComplexNumber();
        List<String> allOperators = OperatorManager.getAllOperators();
        System.out.print("Доступные операторы: ");
        for (String string : allOperators) {
            System.out.print(string + " ");
        }
        System.out.println();
        System.out.print("Введите оператор: ");
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.nextLine();
        ComplexNumber result = new ComplexNumber();
        try {
            result = OperatorManager.performOperator(operator, firstNumber, secondNumber);
            System.out.println("Результат: " + result.getMathRepresentation());
            logger.debug("(" + result.toString() + ")");
        } catch (ArithmeticException e) {
            logger.error(e.getMessage());
            scanner.close();
            throw e;
        }
        scanner.close();
    }
}
