package psu.se411.computerassets;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Computer Asset Manager");
    primaryStage.setScene(new Scene(new StackPane(new Label("Computer Asset Manager")), 400, 250));
    primaryStage.show();
  }
}
