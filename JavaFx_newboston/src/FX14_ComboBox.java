import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX14_ComboBox extends Application{

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBoxSym, comboBoxStrat;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("comboBoxStrat demo");
        button = new Button("Betöltés");

        comboBoxSym = new ComboBox<>();
        comboBoxSym.getItems().addAll(
                "EURUSD",
                "GBPUSD",
                "USDJPY",
                "GBPJPY",
                "EURJPY"
        );
        comboBoxSym.setEditable(true);
        comboBoxSym.setPromptText("Instrumentum");
        comboBoxSym.setOnAction(e -> System.out.println("Az "+ comboBoxSym.getValue() +" instrumentum kiválasztva"));

        comboBoxStrat = new ComboBox<>();
        comboBoxStrat.getItems().addAll(
                "M5_ADX",
                "M5_Zoom",
                "M15_ADX",
                "M15_Zoom",
                "H1_ADX"
        );
        comboBoxStrat.setEditable(true);
        comboBoxStrat.setPromptText("Stratégia");
        comboBoxStrat.setOnAction(e -> System.out.println("Az "+ comboBoxStrat.getValue() +" stratégia kiválasztva"));
        button.setOnAction(e -> printStrategy());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBoxSym, comboBoxStrat, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printStrategy(){
        System.out.println(comboBoxSym.getValue()+"_"+comboBoxStrat.getValue());
    }
}
