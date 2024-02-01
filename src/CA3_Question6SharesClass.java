import java.util.LinkedList;
import java.util.Queue;

class Block{
    private int quantity;
    private double price;

    public Block(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity(){return quantity;}

    public int setQuantity(int quantityNew){return this.quantity = quantityNew;}

    public double getPrice(){return price;}

    @Override
    public String toString() {
        return "{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}' + "\n";
    }
}

public class CA3_Question6SharesClass {
    Queue<Block> queue = new LinkedList<>();

    void buy(int quantity, double price){
        queue.add(new Block(quantity, price));
    }

    void sell(int quantityToSell, double sellPrice){
              double profit = 0.00;
        while(quantityToSell > 0 && !queue.isEmpty()){
            Block peek = queue.peek();

            if(peek.getQuantity() <= quantityToSell){
                quantityToSell -= peek.getQuantity();
                profit += peek.getQuantity() * (sellPrice - peek.getPrice());
                queue.poll();
            } else {
                int currentMinusToSell = peek.getQuantity();
                currentMinusToSell -= quantityToSell;
                peek.setQuantity(currentMinusToSell);

                profit += peek.getQuantity() * (sellPrice - peek.getPrice());
                quantityToSell = 0;
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
