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
        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                CA3_Question6SharesClass value = new CA3_Question6SharesClass();
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
            else if(command.equals("peek")){
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
