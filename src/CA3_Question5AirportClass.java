import java.util.LinkedList;
import java.util.Queue;

public class CA3_Question5AirportClass {
    private Queue<String> takeoff;
    private Queue<String> land;

    public CA3_Question5AirportClass(){
        takeoff = new LinkedList<String>();
        land = new LinkedList<String>();
    }

    public void takeoff(String flightNum){
        takeoff.add(flightNum);
        System.out.println("Flight " + flightNum + " was added to the takeoff queue");
    }

    public void land(String flightNum){
        land.add(flightNum);
        System.out.println("Flight " + flightNum + " was added to the land queue");
    }

    public void flightOrganizator(){
        if(!land.isEmpty()){
            System.out.println("Flight " + land.peek() + " has landed.");
            land.poll();
        } else if(!takeoff.isEmpty()){
            System.out.println("Flight " + takeoff.peek() + " has taken off.");
            takeoff.poll();
        }
    }

    public void quitSimulation(){
        System.out.println("The simulation has ended.");
    }
}
