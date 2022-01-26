package cn.superstallion.ClassicalAlgorithm;

import cn.superstallion.DataStructure.Stack;
import java.util.EnumMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private enum Operator{
        ADD{
            @Override
            Double action(Double operandA, Double operandB) {
                return operandB+operandA;
            }
        },
        SUB{
            @Override
            Double action(Double operandA, Double operandB) {
                return operandB-operandA;
            }
        },
        MUL{
            @Override
            Double action(Double operandA, Double operandB) {
                return operandB*operandA;
            }
        },
        DIV{
            @Override
            Double action(Double operandA, Double operandB) {
                return operandB/operandA;
            }
        };

        abstract Double action(Double operandA,Double operandB);
        public static Operator operatorMapping(String operator){
            switch (operator){
                case "+":
                    return ADD;
                case "-":
                    return SUB;
                case "*":
                    return MUL;
                case "/":
                    return DIV;
                default:
                    return null;
            }
        }

    }

    static final private EnumMap<Operator,Integer> priority;
    static final private String regx = "\\d+|\\D";
    static final private Stack<Double> operandStack;
    static final private Stack<Operator> operatorStack;
    private final String expression;

    static {
        priority = new EnumMap<>(Operator.class);
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
        priority.put(Operator.ADD, 0);
        priority.put(Operator.SUB, 0);
        priority.put(Operator.MUL, 1);
        priority.put(Operator.DIV, 1);
    }

    public Calculator(String expression) {
        this.expression = expression;
    }

    public Double calculate() {
        Pattern compile = Pattern.compile(regx);
        Matcher matcher = compile.matcher(expression);
        while (matcher.find()) {
            if (matcher.group().matches("\\d+")) {
                operandStack.push(Double.valueOf(matcher.group()));
            } else if (operatorStack.size() == 0) {
                operatorStack.push(Operator.operatorMapping(matcher.group()));
            } else {
                Operator top = operatorStack.pop();
                if (priority.get(Operator.operatorMapping(matcher.group())) >= priority.get(top)) {
                    operatorStack.push(top);
                } else {
                    Double operandA = operandStack.pop();
                    Double operandB = operandStack.pop();
                    operandStack.push(top.action(operandA,operandB));
                }
                operatorStack.push(Operator.operatorMapping(matcher.group()));
            }
        }
        while (!operatorStack.isEmpty()) {
            Double operandA = operandStack.pop();
            Double operandB = operandStack.pop();
            operandStack.push(operatorStack.pop().action(operandA,operandB));
        }
        return operandStack.pop();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("1+2+3+4");
        System.out.println(calculator.calculate());
    }

}
