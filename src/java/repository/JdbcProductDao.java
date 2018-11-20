package repository; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport; 
import domain.Product; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao { 
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass()); 
    public List<Product> getProductList() {
        logger.info("Getting products!");
        List<Product> products = getSimpleJdbcTemplate().query(
                "select id, name, description from products", 
                new ProductMapper());
        return products;
    } 
    public void saveProduct(Product prod) {
        logger.info("Saving note: " + prod.getName());
        /*List<Product> products = getSimpleJdbcTemplate().query(
            "﻿insert into products (name,description) values('"+prod.getName()+"','"+prod.getDescription()+"');",
            new ProductMapper());*/
        try{       Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
        Connection con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost:9001", "sa", ""); 
        Statement stmt = con.createStatement(); 
                 if(!prod.getName().equals("")){
        int result = stmt.executeUpdate("INSERT INTO products (name,description) VALUES ('"+prod.getName()+"','"+prod.getDescription()+"')");}
                 else{
        int result = stmt.executeUpdate("INSERT INTO products (name,description) VALUES ('"+prod.getDescription()+"','"+prod.getDescription()+"')");
                 }
         con.commit(); }
          catch(Exception e){}
                //.addValue("id", prod.getId()));
    }    
    public void deleteProduct(Product prod) {
        logger.info("Deleting note: " + prod.getName());
        try{       Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
        Connection con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost:9001", "sa", ""); 
        Statement stmt = con.createStatement(); 
        int result = stmt.executeUpdate("DELETE FROM products where name='"+prod.getName()+"';");
         con.commit(); }
          catch(Exception e){}
    }    
    private class ProductMapper implements ParameterizedRowMapper<Product> { 
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            //prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setName(rs.getString("name"));
            return prod;
        } 
    } 
    public List<Product> searchProducts(String filter){
        List<Product> products = getSimpleJdbcTemplate().query(
                "select id, name, description from products where name like '%"+filter+"%'", 
                new ProductMapper());
        return products;
    }
}