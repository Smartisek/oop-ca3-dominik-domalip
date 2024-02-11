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
        Stack<Character> operator = new Stack<>();
        CA3_Question8Calculator calculator = new CA3_Question8Calculator();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        int result = calculator.calculate(equation);
        System.out.println(result);
//   3*(4+5)
    }
}