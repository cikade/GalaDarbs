public interface ClientInterface {
    int newOrder(int userId);

    void addToOrder(int orderId, int userId, String product, String size);

    void updateInOrder(int userId, int orderId, String product, String size);

    void removeFromOrder(int userId, int orderId);
}
