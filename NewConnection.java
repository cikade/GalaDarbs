import java.util.Arrays;

public class NewConnection implements MyServer, ClientInterface {
    UserTable userTable = new UserTable();
    OrderTable orderTable = new OrderTable();
    ProductTable productTable = new ProductTable();

    private static MyServer instance;

    public static MyServer getInstance() {
        if (instance == null) {
            instance = new NewConnection();
        }
        return instance;
    }

    @Override
    public boolean register(String userName,String passWord) {
        if (isUserRegistered(userName,passWord)) {
            return false;
        } else {
            User newUser = new User(userName,passWord);
            newUser.setId(userTable.getSize());
            userTable.add(newUser);
            return true;
        }
    }

    private boolean isUserRegistered(String userName, String passWord) {
        for (int i = 0; i < userTable.getSize(); i++) {
            if (userTable.getUsers().get(i).getUserName().equals(userName) && userTable.getUsers().get(i).getPassWord().equals(passWord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean logIn(String userName, String passWord) {
        if (isUserRegistered(userName,passWord)) return true;
        return false;
    }

    @Override
    public User getUserData(String userName, String passWord) {
        return new User(userName,passWord);
    }

    @Override
    public boolean deleteAccount(User user) {
        if (user == null) return false;
        if (isUserRegistered(user.getUserName(),user.getPassWord())) {
            userTable.deleteUser(user.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getOrderId(int userId) {
        for (int i = 0; i < orderTable.getOrders().size(); i++) {
            if (orderTable.getOrders().get(i).getUserId() == userId && !orderTable.getOrders().get(i).isPayed()) {
                return orderTable.getOrders().get(i).getOrderId();
            }
        }
        return 0;
    }

    @Override
    public int newOrder(int userId) {
        int lastUsersOrderId = 0;
        for (int i = 0; i < orderTable.getSize(); i++) {
            if (orderTable.getOrders().get(i).getUserId() == userId) {
                lastUsersOrderId = orderTable.getOrders().get(i).getOrderId();
            }
        }
        return lastUsersOrderId + 1;
    }

    @Override
    public String allAvailableProductsTypes() {
        String s = "-----Main Menu-----\n";
        for (int i = 0; i < productTable.size(); i++) {
            s += productTable.get(i).getProductType()+"\n";
        }
        s += "--------------------\n";
        return s;
    }

    @Override
    public String getProductsFromType(String type) {
        String s = "-----"+type+"-----\n";
        for (int i = 0; i < productTable.size(); i++) {
            if (productTable.get(i).getProductType().equals(type)) {
                s += productTable.get(i).getProductName() + "\n";
            }
        }
        s += "--------------------\n";
        return s;
    }

    @Override
    public void addToOrder(int orderId, int userId, String product, String size) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setProductName(product);
        order.setProductPrice(productTable.priceCheck(product,size));
        order.setProductSize(size);
        orderTable.add(order);
    }

    @Override
    public String usersOrder(int orderId) {
        String s = "You're shopping cart\n";
        double sum = 0;
        for (int i = 0; i < orderTable.getSize(); i++) {
            if (orderTable.getOrders().get(i).getOrderId() == orderId && !orderTable.getOrders().get(i).isCompleted() && !orderTable.getOrders().get(i).isPayed()) {
                s += orderTable.getOrders().get(i).getProductName() + " (" + orderTable.getOrders().get(i).getProductSize()+")  --> " + orderTable.getOrders().get(i).getProductPrice()+"\n";
                sum += orderTable.getOrders().get(i).getProductPrice();
            }
        }
        s += "GRAND TOTAL: " + sum;
        return s;
    }

    @Override
    public void updateInOrder(int userId, int orderId, String product, String size) {

    }

    @Override
    public void removeFromOrder(int userId, int orderId) {

    }

    @Override
    public boolean existsProduct(String s) {
        if (productTable.existsProduct(s)) {
            return true;
        }
        return false;
    }

    @Override
    public String getProductsSizes(String item) {
        String s = "-----"+item+"-----\n";
        for (int i = 0; i < productTable.size(); i++) {
            if (productTable.get(i).getProductName().equals(item)) {
                s += productTable.get(i).getProductSize() + " (" + productTable.get(i).getProductPrice() + ")\n";
            }
        }
        s += "--------------------\n";
        return s;
    }

    @Override
    public boolean existsProductsSize(String s) {
        if (productTable.existsSize(s)) {
            return true;
        }
        return false;
    }
}
