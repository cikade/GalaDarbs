import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        MyServer myServer = NewConnection.getInstance();

        //create data to tables
        User user = new User("Roberts","Lange");
        User user2 = new User("Roberts2","Lange2");
        Product product = new Product("Margarita","Pizza","S",4.20);
        Product product2 = new Product("Margarita","Pizza","L",5.90);
        Order order = new Order(user2.getId(), "Margarita","S", 4.20);
        Order order2 = new Order(user2.getId(),"Margarita","L", 5.90);

        //add test data
        myServer.addUser(user);
        myServer.addUser(user2);
        myServer.addProduct(product);
        myServer.addProduct(product2);

        //update data #1 to data #2
        myServer.updateUser(user,user2);
        myServer.updateProduct(product,product2);

        //delete data #2
        myServer.deleteUser(user2);
        myServer.deleteProduct(product2);
    }

    public static void println(Object message) {
        System.out.println(message);
    }
}
