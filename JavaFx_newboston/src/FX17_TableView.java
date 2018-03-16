import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX17_TableView extends Application{

    Stage window;
    TableView<FX17b_Stategy> table;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Table View Demo");

        // Name column
        TableColumn<FX17b_Stategy, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // hozam column
        TableColumn<FX17b_Stategy, Double> hozamColumn = new TableColumn<>("Hozam");
        hozamColumn.setMinWidth(100);
        hozamColumn.setCellValueFactory(new PropertyValueFactory<>("hozam"));

        // dbTrade column
        TableColumn<FX17b_Stategy, Integer> dbTradeColumn = new TableColumn<>("DbTrade");
        dbTradeColumn.setMinWidth(100);
        dbTradeColumn.setCellValueFactory(new PropertyValueFactory<>("dbTrade"));

        table = new TableView<>();
        table.setItems(getFX17b_Strategy());
        table.getColumns().addAll(nameColumn, hozamColumn, dbTradeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    // Get all of the Strategies -- ebbe kell beolvasni a CSV-t!
    public ObservableList<FX17b_Stategy> getFX17b_Strategy(){
        ObservableList<FX17b_Stategy> strategies = FXCollections.observableArrayList();
        strategies.add(new FX17b_Stategy("M5_ADX", 858.94, 20));
        strategies.add(new FX17b_Stategy("M15_ADX", 1250.87, 45));
        strategies.add(new FX17b_Stategy("M15_TSQ", 40.52, 34));
        strategies.add(new FX17b_Stategy("H_Classic", 250.42, 94));
        strategies.add(new FX17b_Stategy("H_T200", -10.85, 15));
        return strategies;
     }
}
