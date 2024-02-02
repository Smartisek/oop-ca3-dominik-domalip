import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Dominik Domalip
 *  Class Group:    GD2b
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        CA3_Question6SharesClass shares = new CA3_Question6SharesClass(); //creating an instance of shares class to access its functions and create the queue
        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
               shares.buy(qty, price);
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double sellPrice = in.nextDouble();
                shares.sell(qty, sellPrice);

            } else if(command.equals("peek")){
                System.out.println(shares.toString());

            }
        }while(!command.equalsIgnoreCase("quit"));
    }

}