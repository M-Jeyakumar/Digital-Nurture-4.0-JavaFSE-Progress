package Week_1.Algorithms_Data_Structures.Exercise_1_Inventory_Management_System.Code;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        inventory.add(new Products(1,"MacBook",50,100000));
        inventory.add(new Products(2,"Asus VivoBook",100,60000));
        inventory.add(new Products(3,"Samsung S20",76,80000));
        System.out.println("Original List");
        inventory.display();

        System.out.println("After Updation");
        inventory.update(2,120,55000);
        inventory.display();

        System.out.println("After Deletion");
        inventory.delete(3);
        inventory.display();
    }
}
