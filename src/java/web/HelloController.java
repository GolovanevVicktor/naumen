package web; 
import domain.Product;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.BindException;
import service.ProductManager;
public class HelloController extends SimpleFormController { 
    private ProductManager productManager;
    public HelloController() {
        //Initialize controller properties here or 
        //in the Web Application Context

    setCommandClass(Product.class);
    setCommandName("product");
    setSuccessView("hello");
    setFormView("hello");
}
    /* @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("products", this.productManager.getProducts()); 
        return new ModelAndView("hello", "model", myModel);
    } */
      @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        Product prod = (Product) command;
        Map<String, Object> myModel = new HashMap<String, Object>();
        switch(prod.getCommand()){
            case "search":
        myModel.put("products", this.productManager.searchProducts(prod.getName())); 
        break;
            case "delete":
        productManager.deleteProduct(prod);
        myModel.put("products", this.productManager.getProducts()); 
        break;
            case "add":
        this.productManager.saveProduct(prod);
        myModel.put("products", this.productManager.getProducts()); 
        break;
            case "show":
        myModel.put("products", this.productManager.getProducts());}
        return new ModelAndView("hello", "model", myModel);
        //Do something...
    }
        public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    } 
}
 