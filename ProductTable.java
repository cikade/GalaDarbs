import java.util.ArrayList;
import java.util.List;

public class ProductTable {
    private List<Products> products = new ArrayList<>();

    public ProductTable() {

        Products product1 = new Products("Margarita","Pizza","L",5.95);
        Products product2 = new Products("Cola","Drink","S",2.13);
        Products product3 = new Products("Nuggets","Other","M",5.31);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public Products get(int id) {
        return products.get(id);
    }

    public double priceCheck(String product,String size) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(product) && products.get(i).getProductSize().equals(size)) {
                return products.get(i).getProductPrice();
            }
        }
        return 0.00;
    }

    public String getProductByType(String type) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductType() == type) return products.get(i).getProductName();
        }
        return null;
    }

    public int size() {
        return products.size();
    }

    public boolean existsProduct(String s) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(s)) return true;
        }
        return false;
    }

    public boolean existsSize(String s) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductSize().equals(s)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProductTable [products=" + products + "]";
    }


}
