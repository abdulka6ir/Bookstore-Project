/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
 *
 * @author samuelhabib
 */
public class Screen extends Application {
    
     public Button b0, b1, b2;
     
    @Override
    public void start(Stage primaryStage) {
      
        b0 = new Button("Customers");
        b0.setOnAction(myHandler);
     
        b1 = new Button("Books");
        b1.setOnAction(myHandler);
        
        b2 = new Button("Logout");
        b2.setOnAction(myHandler);
        
        Pane root = new Pane();
        
        b0.setLayoutX(190);        
        b0.setLayoutY(115);
        
        b1.setLayoutX(130);
        b1.setLayoutY(115);
        b2.setLayoutX(320);
        b2.setLayoutY(260);


        root.getChildren().add(b0);
        root.getChildren().add(b1);
        root.getChildren().add(b2);
        
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
                
    }
       
  final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>(){
    
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource() == b0){
                    System.out.println("button0");
                }
                else if(event.getSource() == b1){
                    System.out.println("button1");
                }
                else if(event.getSource() == b2){
                    System.out.println("button3");
                }
                
            }
      
        };
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
