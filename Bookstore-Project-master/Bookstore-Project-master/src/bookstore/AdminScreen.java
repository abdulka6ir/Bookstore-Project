package bookstore;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class AdminScreen extends Application {
 
    Stage window;
    Scene scene1, scene2;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        window = primaryStage;
        
        Label label1 = new Label("Welcome to first scene");
        Button button1 = new Button("Go to scene2");
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button2
        Button button2 = new Button("Go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);


        window.setScene(scene1);
        window.setTitle("Title here");
        window.show();
    }
    
    
    
       
//    final EventHandler<ActionEvent> Action_Handler = new EventHandler<ActionEvent>(){
//    
//        @Override
//        public void handle(ActionEvent event) {
//
//            String temp_user = Usertxt.getText();
//            String temp_pass = Passtxt.getText(); 
//
//            Authentication full_user = Authentication.getInstance();
//
//            switch (full_user.Auth(temp_user, temp_pass)) {
//
//                case "Admin":
//
//                    System.out.println("Admin Logged");
//                    break;
//
//                case "Customer":
//                    System.out.println("Customer Logged");
//                    break;
//
//                default:
//                    actiontarget.setFill(Color.FIREBRICK);
//                    actiontarget.setText("Wrong Details");
//                    break;
//            }
//
//        }
//    };

  

    
}
