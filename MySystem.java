import java.util.Scanner;

public class MySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyServer myServer = NewConnection.getInstance();

        User user = null;

        println("User: I want to login, here is my data!");
        println("Input your user name");
        String userName = sc.next();
        println("Input password");
        String passWord = sc.next();


        if (myServer.logIn(userName,passWord)) {
            println("System: OK, now you are looged in!");
            user = myServer.getUserData(userName,passWord);
        } else {
            println("System: Sorry, this account is not yet registered!");
            println("System: But we will register you in a second!");
            myServer.register(userName, passWord);
            println("System: OK, now you are registered...");
            user = myServer.getUserData(userName,passWord);
            println("System: ...and logged in!");
        }

        println("User: I want to order something!");
        int orderId = myServer.newOrder(myServer.getOrderId(user.getId()));
        println("System: OK, I created your new shopping basket!");
        println("System: And what you want to order?");
        while (true) {
            println(myServer.allAvailableProductsTypes());
            String toOrder;
            println("User: I want some...!");
            toOrder = sc.next();
            println("User: " + toOrder);
            println("System: Excellent! What kind of " + toOrder + "?");
            println(myServer.getProductsFromType(toOrder));
            String orderItem;
            println("User: I want...");
            orderItem = sc.next();
            println("User: " + orderItem);
            if (myServer.existsProduct(orderItem)) {
                println("System: Excellent");
                println("System: We have available...");
                String itemSize;
                println(myServer.getProductsSizes(orderItem));
                println("User: Lets say...");
                itemSize = sc.next();
                println("User: "+itemSize);
                if (myServer.existsProductsSize(itemSize)) {
                    println("User: " + itemSize);
                    myServer.addToOrder(orderId, user.getId(), orderItem, itemSize);
                    println("System: OK, added to your shopping cart!");
                    println("System: You're shopping cart looks like...");
                    println(myServer.usersOrder(orderId));
                } else {
                    println("That size doesn't exists!");
                }
            } else {
                println("Sorry, i didn't found this item in menu!");
            }
            println("Do you want to add some more items?");
            if(!sc.nextBoolean()) {
                break;
            }
        }

        sc.close();

        println("Can you delete my account?");
        if(myServer.deleteAccount(user)) {
            println("Sadly, but we did as you asked and deleted you!");
        } else {
            println("Sorry, but we could not delete your account!");
            println("You have not been registered at all!");
        }
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
