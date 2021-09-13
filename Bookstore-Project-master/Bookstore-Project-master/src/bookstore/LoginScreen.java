package bookstore;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
        


public class LoginScreen extends Application {
    // Main
    public static void main(String[] args) {
        launch(args);
    }
    
    
    // Buttons
    public Button Login, Logout,books_btn, customers_btn, back_btn, delete_btn, back2_btn;
 
    public TextField Usertxt;
    public PasswordField Passtxt;
    final Text actiontarget = new Text();
    
    // Stages & Scenes
    Stage window;
    Scene login_screen, admin_screen, book_screen, customer_screen;
    
    // Table
    TableView<Book> table;

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        // Window Initializer
        window = primaryStage;
        Usertxt = new TextField();
        Passtxt = new PasswordField();
        Label username = new Label("Username:  ");
        Label password = new Label("Password:  ");
        
        
        // LoginScreen //
        
        
        //Login Button
        Login = new Button("Login");
        Login.setOnAction(Action_Handler_Login);

        GridPane login_scene = new GridPane();
        login_scene.add(actiontarget, 1, 6);
        login_scene.setAlignment(Pos.CENTER);
        
        GridPane.setConstraints(username, 1, 2);
        GridPane.setConstraints(password, 1, 3); 
        GridPane.setConstraints(Usertxt, 2, 2);
        GridPane.setConstraints(Passtxt, 2, 3);
        GridPane.setConstraints(Login, 3, 4);
 
        login_scene.setVgap(10);
       
        login_scene.getChildren().addAll(Usertxt, Passtxt, username, password, Login);
        
        login_screen = new Scene(login_scene, 400, 300);
        // End of LoginScreen //
        
        
        
        // Logout Button
        Logout = new Button("Logout");
        Logout.setOnAction(Action_Handler_Login);
        login_scene.getChildren().add(Logout);
        //
       
        
        // Admin Scene
        books_btn = new Button("Books");
        books_btn.setOnAction(Action_Handler_AdminFunc);
        
        customers_btn = new Button("Customers");
        customers_btn.setOnAction(Action_Handler_AdminFunc);
        
        books_btn.setStyle("-fx-font-size: 2em; ");
        customers_btn.setStyle("-fx-font-size: 2em; ");
        Logout.setStyle("-fx-font-size: 2em; ");
        
        books_btn.setMinWidth(200);
        customers_btn.setMinWidth(200);
        Logout.setMinWidth(200);
        
        GridPane admin_scene = new GridPane();
        admin_scene.setAlignment(Pos.CENTER);
        admin_scene.setVgap(20);
        
        GridPane.setConstraints(books_btn, 1, 1);
        GridPane.setConstraints(customers_btn, 1, 3);
        GridPane.setConstraints(Logout, 1, 5);
        
        admin_scene.getChildren().addAll(books_btn, customers_btn, Logout);
        
        admin_screen = new Scene(admin_scene, 500, 500);
        // End of Admin Scene

        
        
        // Books Scene
        TableColumn<Book, String> bookColumn = new TableColumn<>("Book");
        bookColumn.setMinWidth(300);
        
        bookColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Book, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table = new TableView<>();
        table.setItems(getBook());
        table.getColumns().addAll(bookColumn, priceColumn);
        table.setStyle("-fx-selection-bar: lightblue; -fx-selection-bar-non-focused: lightblue;");
        
        table.setFixedCellSize(25);
        table.prefHeightProperty().bind(Bindings.size(table.getItems()).multiply(table.getFixedCellSize()).add(30));
        
        delete_btn = new Button("Delete");
        delete_btn.setOnAction(Action_Handler_AdminFunc);
        
        back_btn = new Button("Back");
        back_btn.setOnAction(Action_Handler_AdminFunc);
        
     
        GridPane book_scene = new GridPane();
        book_scene.setAlignment(Pos.CENTER);
        book_scene.setVgap(10);
        
        GridPane.setConstraints(table, 5, 1);
        GridPane.setConstraints(delete_btn, 1, 5);
        GridPane.setConstraints(back_btn, 2, 5);
        
        delete_btn.setStyle("-fx-font-size: 1em; ");
        back_btn.setStyle("-fx-font-size: 1em; ");
        delete_btn.setMinWidth(200);
        back_btn.setMinWidth(200);
        
        
        book_scene.getChildren().addAll(table, delete_btn, back_btn);
        
        book_screen = new Scene(book_scene, 500, 500);
        // End of Books Scene
        
        
        
        // Customers Scene
        back2_btn = new Button("Back");
        back2_btn.setOnAction(Action_Handler_AdminFunc);
        
        GridPane customer_scene = new GridPane();
        customer_scene.setAlignment(Pos.CENTER);
        customer_scene.setVgap(20);
        
        GridPane.setConstraints(back2_btn, 1, 1);
        
        
        customer_scene.getChildren().add(back2_btn);
        
        customer_screen = new Scene(customer_scene, 500, 500);
        // End of Customers Scene
        
        
        
        // Scene setter //
        primaryStage.setScene(login_screen);
        primaryStage.show();
        primaryStage.setTitle("Login Screen");
        primaryStage.setAlwaysOnTop(true);
        // End of Scene Setter //
    }
    
    public ObservableList<Book> getBook(){
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Kadir", 123.3));
        books.add(new Book("Bob", 3.3));
        books.add(new Book("James", 9.2));
        books.add(new Book("Tom", 76.0));
        books.add(new Book("Kadir", 123.3));
        return books;
    }
    
    
       
    final EventHandler<ActionEvent> Action_Handler_Login = new EventHandler<ActionEvent>(){
    
        @Override
        public void handle(ActionEvent event) {

            if(event.getSource() == Logout){
                window.setScene(login_screen);
                Usertxt.clear();
                Passtxt.clear();
                window.setTitle("Login Screen");

            } else if(event.getSource() == Login){

                String temp_user = Usertxt.getText();
                String temp_pass = Passtxt.getText(); 

                Authentication full_user = Authentication.getInstance();

                switch (full_user.Auth(temp_user, temp_pass)) {

                    case "Admin":
                        window.setScene(admin_screen);
                        window.setTitle("Owner Start Screen");
                        System.out.println("Admin Screen");
                        break;

                    case "Customer":
                        System.out.println("Customer Logged");
                        break;

                    default:
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("Wrong details");
                        break;
                }

            }

        }
            
    };
  
  
  
    EventHandler<ActionEvent> Action_Handler_AdminFunc = new EventHandler<ActionEvent>(){
        
       @Override
       public void handle(ActionEvent event) {
       
            if(event.getSource() == books_btn){

                window.setScene(book_screen);
                window.setTitle("Book Screen");
                System.out.println("books button");

            }else if(event.getSource() == customers_btn){

                window.setScene(customer_screen);
                window.setTitle("Customer Screen");
                System.out.println("customers btn");

            }else if(event.getSource() == back_btn || event.getSource() == back2_btn){

                window.setScene(admin_screen);
                window.setTitle("Owner Start Screen");
                System.out.println("Back");
            }
               
        }
       
    };
    

  
    
}
