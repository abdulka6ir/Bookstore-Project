package bookstore;

public class Book {
    
    String name;
    double price;
    
    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setName(String book_name){
        this.name = book_name;
    }
    
    public void setPrice(double book_price){
        this.price = book_price;
    }
    
    
    
}
