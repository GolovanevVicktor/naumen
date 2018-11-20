package service; 
import java.util.ArrayList;
import java.util.List; 
import domain.Product; 
import repository.ProductDao;
public class SimpleProductManager implements ProductManager { 
   // private List<Product> products;
    private ProductDao productDao; 
    public List<Product> getProducts() {
        // return products;
        return productDao.getProductList();
    } 
    public void deleteProduct(Product prod){
    productDao.deleteProduct(prod);}
    public void saveProduct(Product prod){
    productDao.saveProduct(prod);}; 
    public List<Product> searchProducts(String filter){
    return productDao.searchProducts(filter);
    }
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    } 
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    } 

}