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

    void sell(int quantityToSell){
        while(quantityToSell > 0 && !queue.isEmpty()){
            Block currentQuantity = queue.peek();

            if(currentQuantity.getQuantity() <= quantityToSell){
                quantityToSell -= currentQuantity.getQuantity();
                queue.poll();
            } else {
                int currentMinusToSell = currentQuantity.getQuantity();
                currentMinusToSell -= quantityToSell;
                currentQuantity.setQuantity(currentMinusToSell);
                quantityToSell = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "shares" +
                  queue;
    }
}
