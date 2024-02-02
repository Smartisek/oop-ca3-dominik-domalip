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
        Map<String, CA3_Question6SharesClass> shares = new HashMap<>();
        CA3_Question6SharesClass value = new CA3_Question6SharesClass();
        value.buy(55, 3.2);
        shares.put("Apple", value);
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
                // Code to buy shares here
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
            else if(command.equals("peek")){
                System.out.println(shares);
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
