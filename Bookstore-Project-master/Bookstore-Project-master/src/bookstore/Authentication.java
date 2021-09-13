package bookstore;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Authentication {
    String login;
    
    private static final Authentication user_file = new Authentication("login.txt");
    
    public Authentication(String login){
        this.login = login;
    }
    
    public static Authentication getInstance(){
        return user_file;
    }
    
   
    public String Auth(String user, String pass){
        try {
            File login_file = new File("login.txt");
            
            Scanner login_scan = new Scanner(login_file);
            
            while(login_scan.hasNextLine() == true){
                String temp_login = login_scan.nextLine();
                
                String[] tempStr = temp_login.split("/", 5);
                String username = tempStr[0];
                String password = tempStr[1];
                    
                if(username.equals(user) && password.equals(pass)){  
                    
                    if(username.equals("admin") && password.equals("admin") || username.equals(" ") && password.equals(" ") ){
                        return "Admin";
                    } else{
                        return "Customer";
                    }

                }
                
            }

        } catch (IOException e){
            System.out.println("An error occurred. " + e.getMessage());
        }
        return "Error";
        
    }

    
}
