public class Item {

    private String ProductName;
    private int Quantity;
    private int Price;

    Item (String pn, int q, int p)
    {
        ProductName = pn;
        Quantity = q;
        Price = p;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString()
    {
        return "Name: "+ProductName+" Quantity: "+Quantity+" Price: "+Price+"\n";
    }
}
