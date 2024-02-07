import java.util.*;
/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {
        CA3_Question7SharesClass shares = new CA3_Question7SharesClass();
        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares.buy(company, qty, price);

            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
            else if(command.equals("peek")){
                System.out.println(shares.toString());
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
