public class Order {
    private int orderId;
    private int userId;
    private String productName;
    private String productSize;
    private double productPrice;
    private boolean payed;
    private boolean isCompleted;



    public Order() {
        super();
    }

    public Order(int orderId, int userId, String productName, boolean payed, String productSize) {
        this(orderId,userId,productName,productSize,0,false,false);
    }

    public Order(int orderId, int userId, String productName, String productSize, boolean payed, double productPrice) {
        this(orderId,userId,productName,productSize,productPrice,false,false);
    }

    public Order(int orderId, int userId, String productName, String productSize, double productPrice, boolean payed, boolean isCompleted) {
        this.orderId = orderId;
        this.userId = userId;
        this.productName = productName;
        this.productSize = productSize;
        this.productPrice = productPrice;
        this.payed = payed;
        this.isCompleted = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", productName=" + productName + ", productSize="
                + productSize + ", productPrice=" + productPrice + ", isCompleted=" + isCompleted + "]";
    }



}
