public class CA3_Question6BlockClass {
    private int quantity;
    private double price;
    private String company;

    public CA3_Question6BlockClass(int quantity, double price, String company){
         this.quantity = quantity;
         this.price = price;
         this.company = company;
    }

    public int getQuantity(){return quantity;}

    public double getPrice(){return price;}

    public String getCompany(){return company;}

    @Override
    public String toString() {
        return "Stock{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
