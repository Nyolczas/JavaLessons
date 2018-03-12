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

public class FX13_ListeningForSelectionChanges extends Application{

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

        // Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue)); // visszaadja a kiválasztott értéket.
        //choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(oldValue)); // az előző értéket adja vissza
        //choiceBox.getSelectionModel().selectedIndexProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue)); // a sorszámát adja vissza

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


}
