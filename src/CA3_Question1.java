import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */

public class CA3_Question1 {

    public static void runSimulation(){
//        creating stacks for the logic, one for parking in driveway and one for parking in street
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        for(int i= 1; i <=5; i++){
            driveway.push(i);
        }


        Scanner scanner = new Scanner(System.in);
        int parkIn = scanner.nextInt();

        if(parkIn > 0 && !driveway.contains(parkIn)){
            driveway.push(parkIn);
        } else {
            int out = parkIn * (-1);
            if(driveway.contains(out)){
                while(!driveway.empty()){
                    int toStreet = driveway.pop();
                    if(out != toStreet){
                        street.push(toStreet);
                    }
                }
                while(!street.empty()){
                    driveway.push(street.pop());
                }
            }
        }
        System.out.println(driveway);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
