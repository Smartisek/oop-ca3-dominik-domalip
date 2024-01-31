import java.util.LinkedList;
import java.util.Queue;

public class CA3_Question5AirportClass {
//    Creating initial queues
    private Queue<String> takeoff;
    private Queue<String> land;

//    making my queues to be a linked in like in regular initialization of a queue
    public CA3_Question5AirportClass(){
        takeoff = new LinkedList<String>();
        land = new LinkedList<String>();
    }

//    function for when takeoff is requested and adding that flight into the takeoff queue
    public void takeoff(String flightNum){
        takeoff.add(flightNum);
        System.out.println("Flight " + flightNum + " was added to the takeoff queue");
    }

//    function for requesting landing and adding that flight into the land queue
    public void land(String flightNum){
        land.add(flightNum);
        System.out.println("Flight " + flightNum + " was added to the land queue");
    }

//    function for polling from the queues
    public void flightOrganizator(){
//        with priority to landing, we check if landing queue is not empty first and if it is true then we poll that flight from the queue
        if(!land.isEmpty()){
            System.out.println("Flight " + land.peek() + " has landed.");
            land.poll();
//            if all requested landings were finished then we check if there are any takeoffs and poll each flight when requesting next in command line
        } else if(!takeoff.isEmpty()){
            System.out.println("Flight " + takeoff.peek() + " has taken off.");
            takeoff.poll();
//            if in the command line is a request for next but there are not any flights then print out a message
        } else if(land.isEmpty() && takeoff.isEmpty()){
            System.out.println("There are no departing or landing flights right now.");
        }
    }

//    function with message for when requested quit
    public void quitSimulation(){
        System.out.println("The simulation has ended.");
    }
}
