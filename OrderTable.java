import java.util.ArrayList;
import java.util.List;

public class OrderTable {
    private List<Order> orders = new ArrayList<>();

    public OrderTable() {
    }

    public void add(Order order) {
        int orderID = 1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserId() == order.getUserId() && orders.get(i).isCompleted() && orders.get(i).isPayed()) {
                orderID++;
            }
        }
        order.setOrderId(orderID);
        orders.add(order);
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "orders=" + orders +
                '}';
    }
}
