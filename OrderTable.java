import java.util.ArrayList;
import java.util.List;

public class OrderTable {
    private List<Order> orders = new ArrayList<>();

    public OrderTable() {
    }

    public OrderTable(List<Order> orders) {
        this.orders = orders;
    }

    public final List<Order> getOrders() {
        return orders;
    }

    public final void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

    public int getSize() {
        return orders.size();
    }

    public int getOrderId(int orderUserId) {
        int ordID = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserId() == orderUserId && !orders.get(i).isCompleted()) {
                ordID = orders.get(i).getOrderId();
            } else if (orders.get(i).getUserId() == orderUserId && orders.get(i).isCompleted()) {
                ordID = orders.get(i).getOrderId() + 1;
            }
        }
        return ordID;
    }

    public void removeFromOrder(int userId, int itemIdToRemove) {
        List<Order> tempOrder = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserId() == userId && !orders.get(i).isCompleted()) {
                tempOrder.add(orders.get(i));
            }
        }
        orders.remove(tempOrder.get(itemIdToRemove-1));
    }

    public void checkPlease(int userId) {
        ProductTable price = new ProductTable();
        double total = 0.00;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserId() == userId && !orders.get(i).isCompleted()) {
                System.out.println(orders.get(i).getProductName()+" ("+orders.get(i).getProductSize()+") --> "+price.priceCheck(orders.get(i).getProductName(), orders.get(i).getProductSize()));
                total += price.priceCheck(orders.get(i).getProductName(), orders.get(i).getProductSize());
            }
        }
        System.out.println("GRAND TOTAL: "+total);
    }

    @Override
    public String toString() {
        String s = "OrderTable\n";
        for (int i = 0; i < orders.size(); i++) {
            s += orders.get(i) + "\n";
        }
        return s;
    }

}
