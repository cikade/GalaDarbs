public class Product {
    private int ID;
    private String productName;
    private String productType;
    private String productSize;
    private double productPrice;
    private boolean Deleted;

    public Product(String productName, String productType, String productSize, double productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productSize = productSize;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productPrice=" + productPrice +
                ", Deleted=" + Deleted +
                '}';
    }
}
