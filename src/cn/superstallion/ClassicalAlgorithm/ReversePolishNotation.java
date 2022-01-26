package cn.superstallion.ClassicalAlgorithm;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {

    private Stack<String> operatorStack;
    private Stack<Object> intermediateResultStack;
    private String expression;
    static final private String regx = "\\d+|\\D";

    {
        intermediateResultStack = new Stack<>();
        operatorStack = new Stack<>();
    }

     public ReversePolishNotation(String expression) {
        this.expression = expression;
    }

    private Integer getOperatorPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                return null;
        }
    }

    private boolean ComparisonPriority(String operator1, String operator2) {
        return getOperatorPriority(operator1) >= getOperatorPriority(operator2);
    }

    public String transform() {
        Matcher matcher = Pattern.compile(regx).matcher(expression);
        String top;

        while (matcher.find()) {

            if (matcher.group().matches("\\d+")) {
                intermediateResultStack.push(matcher.group());
            } else if (operatorStack.isEmpty()) {
                operatorStack.push(matcher.group());
            } else {
                top = operatorStack.pop();
                if (matcher.group().equals(")")||matcher.group().equals("(")||ComparisonPriority(matcher.group(), top) || top.equals("(")) {
                    operatorStack.push(top);
                    operatorStack.push(matcher.group());
                } else if (top.equals(")")) {
                    while (true) {
                        top = operatorStack.pop();
                        if (top.equals("(")) {
                            break;
                        }
                        intermediateResultStack.push(top);
                    }
                } else {
                    intermediateResultStack.push(top);
                    matcher.find(matcher.start());
                    continue;
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            intermediateResultStack.push(operatorStack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!intermediateResultStack.isEmpty()) {
            stringBuilder.append(intermediateResultStack.pop());
            stringBuilder.append(" ");
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
//        ReversePolishNotation reversePolishNotation = new ReversePolishNotation("1*2+(2-1)");
//        System.out.println(reversePolishNotation.transform());
        Matcher matcher = Pattern.compile("\\d").matcher("12345678");
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.find(matcher.start()));
            System.out.println(matcher.group());
        }
    }

}