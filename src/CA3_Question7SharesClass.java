import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

    class Pie{
        private int quantity;
        private double price;

        //    Block constructor
        public Pie(int quantity, double price){
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
                    '}' + '\n';
        }
    }

public class CA3_Question7SharesClass{
        Map<String, Queue<Pie>> stock;
        public CA3_Question7SharesClass() {
            this.stock = new HashMap<>();
        }

        public void buy(String company, int quantity, double price){
            Pie pie = new Pie(quantity, price);
            if(!stock.containsKey(company)){
                stock.put(company, new LinkedList<>());
            }
            stock.get(company).add(pie);
        }

    @Override
    public String toString() {
        return "{" +
                 stock +
                '}';
    }
}
