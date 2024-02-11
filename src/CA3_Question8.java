import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Stack<Integer> numbers = new Stack<>();
//        Stack<Character> operator = new Stack<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();

        for(char ch : equation.toCharArray()){
            if(Character.isDigit(ch)){
                numbers.push(Character.getNumericValue(ch));
            } else
                if(ch == '+'){
                    int arg = numbers.pop();
                    numbers.push(numbers.pop() + arg);
                }
        }
        System.out.println(numbers);
    }
}