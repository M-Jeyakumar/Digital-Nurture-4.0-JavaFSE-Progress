package Week_1.Algorithms_Data_Structures.Exercise_1_Inventory_Management_System.Code;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Products> productList = new HashMap<>();

    public void add(Products product){
        productList.put(product.productId,product);
    }

    public void update(int productId, int quantity,int price){
        Products p = productList.get(productId);
        if(p!=null){
            p.quantity = quantity;
            p.price = price;
        }else{
            System.out.println("Product not Found!");
        }
    }

    public void delete(int productId){
        if(productList.containsKey(productId)){
            productList.remove(productId);
        }else{
            System.out.println("Product not Found!");
        }
    }

    public void display(){
        System.out.println("Inventory List");
        for(Products product:productList.values()){
            System.out.println(product);
        }
        System.out.println();
    }
}
