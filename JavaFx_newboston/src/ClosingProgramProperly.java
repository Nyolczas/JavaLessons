import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClosingProgramProperly extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ablak neve");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button = new Button();
        button.setText("Bezárás");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Kérdés:", "Tényleg be akarod zárni \n " +
                "ezt a \n" +
                " fantasztikus programot?!");
        if (answer) {
            System.out.println("File mentése");
            window.close();
        }
    }
}
