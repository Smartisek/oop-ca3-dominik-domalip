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
//       populating stack with a few cars
        for(int i= 1; i <=5; i++){
            driveway.push(i);
        }

        System.out.println("These are the cars currently parked in the driveway: ");
        System.out.println(driveway);
        System.out.println("Enter your request: ");

//      creating an option for user's input with scanner
        Scanner scanner = new Scanner(System.in);
        int parkIn = scanner.nextInt();
//      when entering a positive number, meaning parking in car with that plate and it is not already in,
//      push into the stack (park into the driveway)
        if(parkIn > 0 && !driveway.contains(parkIn)){
            driveway.push(parkIn);
            System.out.println("Your car: " + parkIn + " " + "has been parked in the driveway");
//      when user enters a negative number, meaning this car plate needs to be removed
        } else {
//          change this input into a positive number so it can be used to search through the stack
            int out = parkIn * (-1);
//          if this cars plate is in the stack and driveway is not empty
            if(driveway.contains(out)){
                while(!driveway.empty()){
//          variable for removing cars from the driveway
                    int toStreet = driveway.pop();
//          if the users request doesn't equal the cars plate that is being removed then push that car into the street
//          meaning if the car that is being removed is not the user's, we just move it onto the street
//          if the car equals user's request, it is just removed completely from the stack (driveway)
                    if(out != toStreet){
                        street.push(toStreet);
                    }
                }
//          then just while street is not empty, we put all the cars back in the same order
                while(!street.empty()){
                    driveway.push(street.pop());
                }
            }
            System.out.println("Your car: " + out + " " + "has been removed from the driveway.");
        }
        System.out.println("Currently parked cars in the driveway are: ");
        System.out.println(driveway);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
