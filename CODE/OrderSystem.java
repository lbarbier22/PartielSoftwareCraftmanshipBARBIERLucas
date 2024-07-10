import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderSystem {

    public Map<Integer, List<String>> orderMap; // une Map des commandes

    public void addNewOrder(Integer customerID, List<String> newItems) {
        List<String> itemsFromCustomer = orderMap.getOrDefault(customerID, new ArrayList<>());
        itemsFromCustomer.addAll(newItems);
        orderMap.put(customerID, newItems);
    }

    public void modifyOrder(Integer customerID, Integer itemIndex, String newItemName) {
        List<String> items = orderMap.get(customerID);
        if (items != null && itemIndex < items.size()) {
            items.set(itemIndex, newItemName);
        }
    }

    public void removeOrder(Integer customerID, Integer itemIndex) {
        List<String> items = orderMap.get(customerID);
        if (items != null && itemIndex < items.size()) {
            items.remove(itemIndex);
        }
    }

}
