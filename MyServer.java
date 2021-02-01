public interface MyServer {
    //user
    void addUser(User user);

    void updateUser(User user, User newData);

    User getUser(User user);

    void deleteUser(User user);

    //product
    void addProduct(Product product);

    void updateProduct(Product product, Product newData);

    Product getProduct(Product product);

    void deleteProduct(Product product);
}
