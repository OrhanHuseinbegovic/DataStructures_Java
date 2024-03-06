package week2;

import javax.xml.crypto.Data;


public class TwoStackAlgorithm {
    public static Double calculate(String expression) {
        // your code here (remove next line)
        /*
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] expressionArray = expression.split(" ");
        int i = 0;
        while (i<expressionArray.length){
            if (expressionArray[i].equals(")")){
                String operator = operators.pop();
                double number1 = numbers.pop();
                double number2 = numbers.pop();
                double calculation;
                if (operator.equals("+")){
                    calculation = number1 + number2;
                    numbers.push(calculation);
                }
                else if(operator.equals("-")){
                    calculation = number2 - number1;
                    numbers.push(calculation);
                }
                else if(operator.equals("*")){
                    calculation = number1*number2;
                    numbers.push(calculation);
                }
                else if(operator.equals("/")){
                    calculation = number2/number1;
                    numbers.push(calculation);
                }
                else if(operator.equals("%")){
                    calculation = number2%number1;
                    numbers.push(calculation);
                }
                else if (operator.equals("^")){
                    calculation = 1.0;
                    for(int j=1; j<=number1; j++){
                        calculation = calculation * number2;
                    }
                    numbers.push(calculation);
                }
                else if (operator.equals("√")){
                    calculation = Math.sqrt(number2);
                    numbers.push(calculation);
                }
            }
            else if(expressionArray[i].equals("("));
            else if(expressionArray[i].equals("+") ||
                    expressionArray[i].equals("-") ||
                    expressionArray[i].equals("*") ||
                    expressionArray[i].equals("/") ||
                    expressionArray[i].equals("%") ||
                    expressionArray[i].equals("^") ||
                    expressionArray[i].equals("√")){
                String operator = expressionArray[i];
                operators.push(operator);
            }
            else{
                double number = Double.parseDouble(expressionArray[i]);
                numbers.push(number);
            }
            i++;
        }
        return numbers.peek();

         */
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] expressionArray = expression.split(" ");
        int i = 0;
        while (i < expressionArray.length) {
            if (expressionArray[i].equals(")")) {
                String operator = operators.pop();
                double number1 = numbers.pop();
                double calculation = 0;
                if (operator.equals("+")) {
                    calculation = numbers.pop() + number1;
                } else if (operator.equals("-")) {
                    calculation = numbers.pop() - number1;
                } else if (operator.equals("*")) {
                    calculation = numbers.pop() * number1;
                } else if (operator.equals("/")) {
                    calculation = numbers.pop() / number1;
                } else if (operator.equals("%")) {
                    calculation = numbers.pop() % number1;
                } else if (operator.equals("^")) {
                    calculation = Math.pow(numbers.pop(), number1);
                } else if (operator.equals("'")) {
                    calculation = 1;
                    for (int j = 1; j <= number1; j++) {
                        calculation *= numbers.pop();
                    }
                } else if (operator.equals("√")) {
                    calculation = Math.sqrt(number1);
                }
                numbers.push(calculation);
            } else if (expressionArray[i].equals("("));
             else if (expressionArray[i].equals("+") ||
                    expressionArray[i].equals("-") ||
                    expressionArray[i].equals("*") ||
                    expressionArray[i].equals("/") ||
                    expressionArray[i].equals("%") ||
                    expressionArray[i].equals("^") ||
                    expressionArray[i].equals("'") ||
                    expressionArray[i].equals("√")) {
                String operator = expressionArray[i];
                operators.push(operator);
            } else {
                double number = Double.parseDouble(expressionArray[i]);
                numbers.push(number);
            }
            i++;
        }
        return numbers.peek();
    }
}
