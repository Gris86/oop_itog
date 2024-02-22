package main.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.FilteredObjectInputStream;

import main.ComplexNumber;

public class InputReader {
    protected static final Logger logger = LogManager.getLogger();

    public static ComplexNumber readComplexNumber() {
        Scanner scanner = new Scanner(new java.io.FilterInputStream(System.in) {
            @Override
            public void close() {}
        });
        double real = 0, imaginary = 0;
        try {
            System.out.print("Введите действительную часть комплексного числа: ");
            real = scanner.nextDouble();
            System.out.print("Введите мнимую часть комплексного числа: ");
            imaginary = scanner.nextDouble();
        } catch (Exception e) {
            logger.error("Не удалось считать комплексное число");
            throw e;
        } finally {
            scanner.close();
        }
        ComplexNumber complexNumber = new ComplexNumber(real, imaginary);
        logger.info("Создан объект: " + complexNumber.toString());
        return complexNumber;
    }
}
