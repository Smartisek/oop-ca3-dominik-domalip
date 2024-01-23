import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */

public class CA3_Question1 {

    public static void runSimulation(){
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        Scanner scanner = new Scanner(System.in);
        int parkIn = scanner.nextInt();

        if(parkIn > 0){
            driveway.push(parkIn);
        }
        System.out.println(driveway);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
