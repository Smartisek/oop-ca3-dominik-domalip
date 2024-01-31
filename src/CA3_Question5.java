
import java.util.Scanner;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */

// References: https://stackoverflow.com/questions/19950713/scanner-input-validation-in-while-loop for continuous user input

public class CA3_Question5
{
    public static void main(String[] args)
    {
        commandLine();
    }

    public static void commandLine(){
//        initialize the class for being able to access its functions and the queues
        CA3_Question5AirportClass airport = new CA3_Question5AirportClass();

//      creating a new scanner for input
        Scanner scanner = new Scanner(System.in);

//        handling the users input while true make a new scanner line, goes false when requested quit
        while(true){
            String userInput = scanner.nextLine(); //creating new scanner line each time
            if(userInput.startsWith("takeoff")){
//                checking if the input starts with a word takeoff and if yes make a string variable that has that input split with space
//                and adding second word, first index to that variable meaning the flight number
                String flightNum = userInput.split(" ")[1];
                airport.takeoff(flightNum);
            } else if(userInput.startsWith("land")){
                String flightNum = userInput.split(" ")[1];
                airport.land(flightNum);
//                calling the function handling when requested next
            } else if(userInput.startsWith("next")){
                airport.flightOrganizator();
            } else if(userInput.startsWith("quit")){
                airport.quitSimulation();
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }
    }

}



// takeoff( “Flight-100”); // is queued
//takeoff(“Flight-220”); // is queued
//land(“Flight-320”); // is queued
//next(); // will complete the takeoff/landing of the
//// current flight and initiate landing of
//// the next prioritized fligh’ i.e. Flight-320