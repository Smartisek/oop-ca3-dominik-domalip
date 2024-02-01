public class CA3_Question6BlockClass {
    private int quantity;
    private double price;

    public CA3_Question6BlockClass(int quantity, double price){
         this.quantity = quantity;
         this.price = price;
    }

    public int getQuantity(){return quantity;}

    public double getPrice(){return price;}

    @Override
    public String toString() {
        return "CA3_Question6BlockClass{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}' + "\n";
    }
}
