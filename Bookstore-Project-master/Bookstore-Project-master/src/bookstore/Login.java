/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author samuelhabib
 */
public class Login {
    String username,password;
    User user =  new User();
    
    public String getUsername(){
    return username;
    }
    
    public String getPassword(){
    return username;
    }
    
    public void setPassword(String password){
    this.password = password;
    }
    
    public void setUsername(String username){
    this.username = username;
    }
    
    public User getUser(){
    return user;
    }
    
    public void setUser(User user){
    this.user = user;
    }
    
    
}
