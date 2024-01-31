import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */

public class CA3_Question5
{
    public static void main(String[] args)
    {
        commandLine();
    }

    public static void commandLine(){
        CA3_Question5AirportClass airport = new CA3_Question5AirportClass();

//        Queue<String> takeoff = new LinkedList<String>();
//        Queue<String> land = new LinkedList<String>();

        Scanner scanner = new Scanner(System.in);
        while(true){
            String userInput = scanner.nextLine();
            if(userInput.startsWith("takeoff")){
                String flightNum = userInput.split(" ")[1];
                airport.takeoff(flightNum);
            } else if(userInput.startsWith("land")){
                String flightNum = userInput.split(" ")[1];
                airport.land(flightNum);
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