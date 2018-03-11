import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MultipleWindows extends Application{

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        window = primaryStage;
        window.setTitle("primaryStage");

        button = new Button("Kattincssá!");

        button.setOnAction(e -> AlertBox.display("Ablakom Címe", "Ez itt egy csodálatos Alertbox Modal."));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 380, 280);
        window.setScene(scene);
        window.show();
    }

}
