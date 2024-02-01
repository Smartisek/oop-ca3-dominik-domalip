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

        Queue<CA3_Question6BlockClass> shares = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                String stockName = in.next();
                CA3_Question6BlockClass stock = new CA3_Question6BlockClass(qty, price, stockName);
                shares.add(stock);
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
            } else if(command.equals("peek")){
                System.out.println(shares);
                shares.peek();
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}