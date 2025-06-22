package Week_1.Algorithms_Data_Structures.Exercise_3_Sorting_Customer_Orders.Code;

public class CustomerOrders {
    public static void bubblesort(Orders[] orders){
        for(int i=0;i<orders.length-1;i++){
            for(int j=0;j<orders.length-i-1;j++){
                if(orders[j].totalPrice > orders[j+1].totalPrice){
                    Orders temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Orders[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Orders[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Orders temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Orders temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Orders[] orders = new Orders[]{
                new Orders(1,"Jeyakumar",1700),
                new Orders(4,"Ashwath",4000),
                new Orders(2,"Kathir",3000),
                new Orders(7,"Muthukumar",3500),
                new Orders(5,"Shriram",7100)
        };

        bubblesort(orders);
        System.out.println("After bubble sort");
        for (Orders order:orders){
            System.out.println(order);
        }

        orders = new Orders[]{
                new Orders(1,"Jeyakumar",1700),
                new Orders(2,"Ashwath",4000),
                new Orders(3,"Kathir",3000),
                new Orders(4,"Muthukumar",3500),
                new Orders(5,"Shriram",7100)
        };
        quickSort(orders,0,orders.length-1);
        System.out.println("\nAfter Quick sort");
        for (Orders order:orders){
            System.out.println(order);
        }

    }
}
