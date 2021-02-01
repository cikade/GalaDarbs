public interface MyServer {
    boolean register(String userName,String passWord);

    boolean logIn(String userName, String passWord);

    User getUserData(String userName, String passWord);

    boolean deleteAccount(User me);



    int getOrderId(int orderUserId);

    int newOrder(int userId);

    String allAvailableProductsTypes();

    String getProductsFromType(String type);

    boolean existsProduct(String s);

    String getProductsSizes(String type);

    boolean existsProductsSize(String s);

    void addToOrder(int orderId, int userId, String product, String size);

    String usersOrder(int orderId);
}
