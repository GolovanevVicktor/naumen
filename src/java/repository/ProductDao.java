package repository; 
import java.util.List; 
import domain.Product; 
public interface ProductDao { 
    public List<Product> getProductList(); 
    public void saveProduct(Product prod); 
    public List<Product> searchProducts(String filter);
    public void deleteProduct(Product prod); 
}