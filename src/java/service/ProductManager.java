package service; 
import java.io.Serializable;
import java.util.List; 
import domain.Product;
public interface ProductManager extends Serializable{    
    public List<Product> getProducts(); 
    public List<Product> searchProducts(String filter);
    public void saveProduct(Product prod); 
    public void deleteProduct(Product prod);
}