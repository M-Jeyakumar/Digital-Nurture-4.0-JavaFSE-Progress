package Week_1.Algorithms_Data_Structures.Exercise_1_Inventory_Management_System.Code;

public class Products {
    int productId,price,quantity;
    String productName;
    public Products(int productId,String productName,int quantity,int price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId+" "+productName+" "+quantity+" "+price;
    }
}
