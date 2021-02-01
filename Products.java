public class Products {
    private String productName;
    private String productType;
    private String productSize;
    private double productPrice;

    public Products(String productName, String productType, String productSize, double productPrice) {
        super();
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
        return productType.toString();
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

    @Override
    public String toString() {
        return "Products [productName=" + productName + ", productType=" + productType + ", productSize=" + productSize
                + ", productPrice=" + productPrice + "]";
    }

}
