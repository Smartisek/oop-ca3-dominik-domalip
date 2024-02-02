import java.util.LinkedList;
import java.util.Queue;

// Creating class block for holding quantity and price information
class Block{
    private int quantity;
    private double price;

//    Block constructor
    public Block(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }
//  Creating function for accessing the quantity
    public int getQuantity(){return quantity;}
//  Function for setting quantity
    public int setQuantity(int quantityNew){return this.quantity = quantityNew;}
//  Function for getting price info
    public double getPrice(){return price;}

//    to string function so information is not printed just as hash code
    @Override
    public String toString() {
        return "{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}' + "\n";
    }
}

// Class for queue that will hold the block information
public class CA3_Question6SharesClass {
    Queue<Block> queue = new LinkedList<>(); //initialization of a queue with an object of block

//    Function for buying a stock
    void buy(int quantity, double price){
        queue.add(new Block(quantity, price)); //whenever called create a new block with input values and add it into the queue
    }

    void sell(int quantityToSell, double sellPrice){
              double profit = 0.00; //profit variable set to 0 to keep track of how much profit made
//        when quantity to sell is more than 0 and our queue of stocks is not empty
        while(quantityToSell > 0 && !queue.isEmpty()){
            Block peek = queue.peek(); //variable for checking, peeking what is first in queue
//       If the first thing and its quantity block is less or equal to how much we want to sell
//       we distract from how much we want to sell by how much is in the block
            if(peek.getQuantity() <= quantityToSell){
                quantityToSell -= peek.getQuantity();
//       then just calculate quantity times (how much we want to sell for minus what was buying price
//                and then just remove that from the queue
                profit += peek.getQuantity() * (sellPrice - peek.getPrice());
                queue.poll();
            } else {
//                if there is any reminding shares to be sold
                int currentMinusToSell = peek.getQuantity(); // peek how many is there left
                currentMinusToSell -= quantityToSell; // by how many is left to be sold we minus that from how much we have in the block
                peek.setQuantity(currentMinusToSell); // we update the current quantity of stock to previous variable which is how much is left after sell
//              formula for profit
                profit += peek.getQuantity() * (sellPrice - peek.getPrice());
                quantityToSell = 0; // no more stocks is needed to sell so we set to zero which stops the while loop and exits
            }
        }
        System.out.println("Profit is " + profit);
    }

    @Override
    public String toString() {
        return "shares" +
                  queue;
    }
}
