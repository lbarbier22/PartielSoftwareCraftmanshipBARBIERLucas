import java.util.List;
import java.util.Map;

public class OrderPrinter {

    OrderSystem orderSystem;

    public void printOrders() {
        for (Map.Entry<Integer, List<String>> entry : orderSystem.orderMap.entrySet()) {
            System.out.println("Customer ID: " + entry.getKey());
            System.out.println("Items: " + String.join(", ", entry.getValue()));
            System.out.println();
        }
    }
}
