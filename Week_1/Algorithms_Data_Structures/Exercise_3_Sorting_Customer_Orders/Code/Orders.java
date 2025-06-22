package Week_1.Algorithms_Data_Structures.Exercise_3_Sorting_Customer_Orders.Code;

public class Orders {
    int orderId;
    String customerName;
    int totalPrice;
    public Orders(int orderId,String customerName,int totalPrice){
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public String toString(){
        return orderId+" "+customerName+" "+totalPrice;
    }
}
