package main.operators;

import java.util.ArrayList;
import java.util.List;
import javax.naming.NameNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import main.ComplexNumber;

public class OperatorManager {
    protected static final Logger logger = LogManager.getLogger();

    public static List<Class<? extends Operator>> getAllOperatorClasses() {
        ArrayList<Class<? extends Operator>> operatorsList = new ArrayList<>();
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("main.operators.impl").scan()) {
            ClassInfoList classes = scanResult.getClassesImplementing("main.operators.Operator");
            for (ClassInfo classInfo : classes) {
                @SuppressWarnings("unchecked")
                Class<? extends Operator> class1 = (Class<? extends Operator>) classInfo.loadClass();
                logger.info("Обнаружен оператор " + class1.getCanonicalName());
                operatorsList.add(class1);
            }
        }
        return operatorsList;
    }

    public static List<Operator> getAllOperatorInstances() throws Exception {
        List<Class<? extends Operator>> operatorClasses = getAllOperatorClasses();
        ArrayList<Operator> operatorInstances = new ArrayList<>(); 
        for (Class<? extends Operator> class1 : operatorClasses) {
            try {
                logger.info("Создаём объект класса " + class1.getCanonicalName() + "...");
                operatorInstances.add((Operator) class1.getConstructor().newInstance());   
            } catch (Exception e) {
                logger.error("Не удалось создать объект класса " + class1.getCanonicalName());
                throw e;
            }
        }
        return operatorInstances;
    }

    public static List<String> getAllOperators() throws Exception {
        List<Operator> operatorInstances = getAllOperatorInstances();
        ArrayList<String> operators = new ArrayList<>();
        for (Operator operator : operatorInstances) {
            operators.add(operator.getCharacter());
        }
        return operators;
    }

    public static ComplexNumber performOperator(Operator operator, ComplexNumber in1, ComplexNumber in2) {
        return operator.perform(in1, in2);
    }

    public static ComplexNumber performOperator(String operator, ComplexNumber in1, ComplexNumber in2) throws Exception {
        List<Operator> operators = getAllOperatorInstances();
        logger.info("Ищем оператор с символом '" + operator + "'...");
        for (Operator operator2 : operators) {
            if (operator2.getCharacter().equals(operator)) {
                logger.info("... найден.");
                return performOperator(operator2, in1, in2);
            }
            logger.debug("'" + operator2.getCharacter() + "' != '" + operator + "'");
        }
        logger.error("Не найден оператор '" + operator + "'");
        throw new NameNotFoundException();
    }
}
