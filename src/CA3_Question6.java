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
        
        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            CA3_Question6SharesClass sharesFunctions = new CA3_Question6SharesClass();
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
               sharesFunctions.buy(qty, price);
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
//                double sellPrice = in.nextDouble();
                sharesFunctions.sell(qty);
                System.out.println(sharesFunctions);

            } else if(command.equals("peek")){
                System.out.println(sharesFunctions);

            }
        }while(!command.equalsIgnoreCase("quit"));
    }

}