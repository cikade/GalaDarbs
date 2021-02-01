import java.util.ArrayList;
import java.util.List;

public class ProductTable {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        product.setID(products.size());
        products.add(product);
    }

    public boolean productExists(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(product.getProductName()) && products.get(i).getProductSize().equals(product.getProductSize())) {
                return true;
            }
        }
        return false;
    }

    public void updateProduct(Product appendProduct, Product newData) {
        if (productExists(appendProduct)) {
            products.get(appendProduct.getID()).setProductName(newData.getProductName());
            products.get(appendProduct.getID()).setProductPrice(newData.getProductPrice());
            products.get(appendProduct.getID()).setProductSize(newData.getProductSize());
            products.get(appendProduct.getID()).setProductType(newData.getProductType());
        }
    }

    public void deleteProduct(Product product) {
        products.get(product.getID()).setDeleted(true);
    }

    @Override
    public String toString() {
        return "ProductTable{" +
                "products=" + products +
                '}';
    }
}
