import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
// RESOURCES: https://stackoverflow.com/questions/11107433/is-it-possible-to-create-a-queue-for-hashmap-set
//  https://www.youtube.com/watch?v=3RSXHVyzdmg
    class Pie{
        private int quantity;
        private double price;

        //    Block constructor for storing quantity and price
        public Pie(int quantity, double price){
            this.quantity = quantity;
            this.price = price;
        }

        public int getQuantity(){return quantity;} // getter for quantity
        public int setQuantity(int quantityNew){return this.quantity = quantityNew;} // setter for quantity, important for sell function

        public double getPrice(){return price;} //getter for price

//    toString function otherwise we'd only get a hashcode when printing
        @Override
        public String toString() {
            return "{" +
                    "quantity=" + quantity +
                    ", price=" + price +
                    '}' + '\n';
        }
    }
// The stock class
public class CA3_Question7SharesClass{
//        Initialize a map where it's key is name of the company stock and it's value is a queue of a type pie, which holds info
//        about quantity and price bought
        Map<String, Queue<Pie>> stock;
        public CA3_Question7SharesClass() { //constructor, can also just do equals new hashmap above ^^
            this.stock = new HashMap<>();
        }

    @Override
    public String toString() {
        return "{" +
                stock +
                '}';
    }

//  The buy function that takes in name of the company stock, how much to buy and at what price
        public void buy(String company, int quantity, double price){
            Pie pie = new Pie(quantity, price);  //when function called create a new Pie that will hold quantity and price
//            if our map stock initialized above doesn't contain key company, then add this company into the stock map and create
//            a new linked list for the queue of a type pie
            if(!stock.containsKey(company)){
                stock.put(company, new LinkedList<>());
            }
            stock.get(company).add(pie); // then to the existing company key add the pie data(quantity and price)
        }

        public void sell(String company, int quantityToSell, double sellPrice){
        Queue <Pie> pies = stock.get(company); //initialize a new pie that works for accessing the queue of purchases to be able to follow FIFO
        double totalGain = 0; //create a variable to add and hold gain
//            while the quantity required to sell is more than 0 and stock map is not empty
            while(quantityToSell > 0 && !stock.isEmpty()){
//                same logic as in the question 6
//                if the required company's first added queue (pie) has a quantity less or equal to required selling quantity
//                then take away from quantity required to sell by how much the first pie has quantity inside, to know how much is left to sell
//                then add to variable total gain with formula for calculating profit from question 6
//                lastly remove this pie, queue (the name stays in with another pie, queue, if any still in stock map
                if(pies.peek().getQuantity() <= quantityToSell){
                    quantityToSell -= pies.peek().getQuantity();
                    totalGain += pies.peek().getQuantity() * (sellPrice - pies.peek().getPrice());
                     pies.poll();
//                if we sell more than is in the first added pie, then we still need to sell the rest of wanted quantity
                } else {
//                creating a variable that searches for a quantity in next pie, queue
//                then subtract from this quantity by the remaining selling quantity
                    int currentMinusToSell = pies.peek().getQuantity();
                    currentMinusToSell -= quantityToSell;
//                access this pie again and set the quantity left by using our setter in pie ^
                    pies.peek().setQuantity(currentMinusToSell);
//                    again formula for profit from questing 6
                    totalGain += pies.peek().getQuantity() * (sellPrice - pies.peek().getPrice());
                    quantityToSell = 0; // set quantity to sell to zero because we sold all required, so we can stop the while loop
                }
            }
            System.out.println("Profit for selling " + company + " at price " + sellPrice + " is " + totalGain);
        }
}
