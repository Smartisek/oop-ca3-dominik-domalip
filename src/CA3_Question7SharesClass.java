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
            stock.get(company).add(pie); // if already in add new pie to the company
        }

        public void sell(String company, int quantityToSell, double sellPrice){
        Queue <Pie> pies = stock.get(company);
        double totalGain = 0;
            while(quantityToSell > 0 && !stock.isEmpty()){
                if(pies.peek().getQuantity() <= quantityToSell){
                    quantityToSell -= pies.peek().getQuantity();
                    totalGain += pies.peek().getQuantity() * (sellPrice - pies.peek().getPrice());
                    Pie pieSell = pies.poll();
                } else {
                    int currentMinusToSell = pies.peek().getQuantity();
                    currentMinusToSell -= quantityToSell;
                    pies.peek().setQuantity(currentMinusToSell);
                    totalGain += pies.peek().getQuantity() * (sellPrice - pies.peek().getPrice());
                    quantityToSell = 0;
                }
            }
            System.out.println("Profit for selling " + stock.get(company) + " at price " + sellPrice + " is " + totalGain);
        }

    @Override
    public String toString() {
        return "{" +
                 stock +
                '}';
    }
}
