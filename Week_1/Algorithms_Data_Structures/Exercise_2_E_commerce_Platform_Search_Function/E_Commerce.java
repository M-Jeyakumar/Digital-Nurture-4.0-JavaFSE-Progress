package Week_1.Algorithms_Data_Structures.Exercise_2_E_commerce_Platform_Search_Function;

class Product {
    int productId;
    String productname;
    String category;
    public Product(int productId, String productName, String category){
        this.productId = productId;
        this.productname = productName;
        this.category = category;
    }
    public String toString(){
        return "ProductId: "+productId+"\nProduct Name: "+productname+"\nCategory: "+category;
    }
}

public class E_Commerce{

    public static Product linearSearch(Product[] products, int targetId){
        for(Product p:products){
            if(p.productId==targetId){
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products,int targetId){
        int left=0,right = products.length-1;
        while(left<=right){
            int mid = (left+right) / 2;
            if(products[mid].productId == targetId){
                return products[mid];
            }else if(products[mid].productId < targetId){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(1,"Iphone","mobiles"),
                new Product(2,"Samsung","mobiles"),
                new Product(3,"Dell","Laptop"),
                new Product(4,"ASUS","Laptop")
        };
        int targetId = 3;
        Product resultLinearSearch = linearSearch(products,targetId);
        System.out.println("Linear Search Result: ");
        System.out.println(resultLinearSearch);


        Product resultBinarySearch = binarySearch(products,targetId);
        System.out.println("\nBinary Search Result: ");
        System.out.println(resultBinarySearch);

    }
}
