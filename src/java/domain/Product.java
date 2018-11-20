package domain; 
import java.io.Serializable; 
public class Product implements Serializable { 
    private String description;
    private String name; 
    private String command;
    private int id;
    public String getDescription() {
        return description;
    }    
    public void setDescription(String description) {
        this.description = description;
    }  
    public String getCommand() {
        return command;
    }    
    public void setCommand(String command) {
        this.command = command;
    } 
    public String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    } 
    public int getId() {
        return id;
    }    
    public void setId(int id) {
        this.id = id;
    } 
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Name: " + name);
        buffer.append("Description: " + description + ";");
        return buffer.toString();
    }
}