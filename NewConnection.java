public class NewConnection implements MyServer {
    //create tables
    UserTable userTable = new UserTable();
    ProductTable productTable = new ProductTable();

    private static MyServer instance;

    public static MyServer getInstance() {
        if (instance == null) {
            instance = new NewConnection();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        userTable.add(user);
    }

    @Override
    public void updateUser(User user, User newData) {
        userTable.updateUser(user,newData);
    }

    @Override
    public User getUser(User user) {
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userTable.deleteUser(user);
    }

    @Override
    public void addProduct(Product product) {
        productTable.add(product);
    }

    @Override
    public void updateProduct(Product product, Product newData) {
        productTable.updateProduct(product,newData);
    }

    @Override
    public Product getProduct(Product product) {
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        productTable.deleteProduct(product);
    }
}
