import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX12_ChoiceBox extends Application{

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiceBox demo");

        button = new Button("kattints rám!");

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        // get items
        choiceBox.getItems().add("Alma");
        choiceBox.getItems().add("Banán");
        choiceBox.getItems().add("Narancs");
        choiceBox.getItems().addAll("Narancs", "Dinnye", "Cseresznye", "Eper");

        choiceBox.setValue("Alma");
        button.setOnAction( e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    // to get the value of the selected items
    private void getChoice( ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue();
        System.out.println(food);
    }

}
