import java.util.Stack;

public class CA3_Question8Calculator {
    private Stack<Integer> numbers = new Stack<>();
    private Stack<Character> operators = new Stack<>();

    private int power(char operator){
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private void evaluate(){
        int num2 = numbers.pop();
        int num1 = numbers.pop();
        char operator = operators.pop();

        switch(operator){
            case '+':
                numbers.push(num1+num2);
                break;
            case '-':
                numbers.push(num1 - num2);
                break;
            case '*':
                numbers.push(num1*num2);
                break;
            case '/':
                if(num2 != 0){
                    numbers.push(num1/num2);
                } else {
                    throw new UnsupportedOperationException("Cannot divide by 0");
                }
                break;
        }
    }

    public int calculate (String expression){
        for(char ch : expression.toCharArray()){
            if(Character.isDigit(ch)){
                numbers.push(Character.getNumericValue(ch));
            } else if(ch == '('){
                operators.push(ch);
            } else if(ch == ')'){
                while(operators.peek() != '('){
                    evaluate();
                }
                operators.pop();
            } else {
                while(!operators.isEmpty() && power(operators.peek()) >= power(ch)){
                    evaluate();
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()){
            evaluate();
        }
        return numbers.pop();
    }
}
