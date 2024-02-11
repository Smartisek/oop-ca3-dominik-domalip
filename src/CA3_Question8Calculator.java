import java.util.Stack;

//////// *********** FOR THIS QUESTION I WAS NOT ABLE TO COME UP WITH ANSWER MYSELF AND I COLLABORATED WITH CHATGPT ******************
public class CA3_Question8Calculator {
//    two stacks used for this algorithm, one for numbers and other for operators
    private Stack<Integer> numbers = new Stack<>();
    private Stack<Character> operators = new Stack<>();

//    this method handles the precedence meaning that we need to calculate first parts with the higher precedence
//    therefore when we enter * or / these have a priority before plus and minus
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

//    this method just pops two numbers from number stack and one from operator
//    then evaluates based on the operator
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
//                    if dividing by 0 give an exception, not possible
                    throw new UnsupportedOperationException("Cannot divide by 0");
                }
                break;
        }
    }

    public int calculate (String expression){
//        go through each character of the input
        for(char ch : expression.toCharArray()){
//            if character is a digit meaning its a number push it onto numbers stack
            if(Character.isDigit(ch)){
                numbers.push(Character.getNumericValue(ch));
//                if it is opening bracket push it onto operators
            } else if(ch == '('){
                operators.push(ch);
//                When it is closing bracket and while inside of operators stack is not opening bracket
//                then evaluate and then remove the opening bracket with pop
            } else if(ch == ')'){
                while(operators.peek() != '('){
                    evaluate();
                }
                operators.pop();
//                else if input is operator push in onto operator stack
            } else {
//                while there is a operator on top of the stack that has a precedence power more or equal to the one in input
//                then evaluate
                while(!operators.isEmpty() && power(operators.peek()) >= power(ch)){
                    evaluate();
                }
                operators.push(ch);
            }
        }
//        after all characters were evaluated call the evaluate function until operator stack is empty
        while (!operators.isEmpty()){
            evaluate();
        }
//        the result is the last number in numbers stack so we pop it and then can display it as a result
        return numbers.pop();
    }
}
