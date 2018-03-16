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

public class FX19_EditableTables extends Application{
    Stage window;
    TableView<FX17b_Stategy> table;
    TextField nameInput, hozamInput, dbTradeInput;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Editable Table Demo");

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

        // Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        // Hozam Input
        hozamInput = new TextField();
        hozamInput.setPromptText("hozam");

        // dbTrade Input
        dbTradeInput = new TextField();
        dbTradeInput.setPromptText("dbTrade");

        // Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, hozamInput, dbTradeInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getFX17b_Strategy());
        table.getColumns().addAll(nameColumn, hozamColumn, dbTradeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    // Add Button clicked
    public void addButtonClicked(){
        FX17b_Stategy strategy = new FX17b_Stategy();
        strategy.setName(nameInput.getText());
        strategy.setHozam(Double.parseDouble(hozamInput.getText()));
        strategy.setDbTrade(Integer.parseInt(dbTradeInput.getText()));
        table.getItems().add(strategy);
        nameInput.clear();
        hozamInput.clear();
        dbTradeInput.clear();
    }

    // Delete Button clicked
    public void deleteButtonClicked(){
        ObservableList<FX17b_Stategy> strategySelected, allStrategies;
        allStrategies = table.getItems();
        strategySelected = table.getSelectionModel().getSelectedItems();

        strategySelected.forEach(allStrategies::remove);
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
