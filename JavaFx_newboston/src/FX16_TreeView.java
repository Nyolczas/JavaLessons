import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX16_TreeView extends Application{

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tree View Demo");

        TreeItem<String> root, Instrumentumok, Stratégiák;

        // Root
        root= new TreeItem<>();
        root.setExpanded(true);

        // Instrumentumok
        Instrumentumok = makeBranch("Instrumentumok", root);
        makeBranch("EURUSD", Instrumentumok);
        makeBranch("GBPUSD", Instrumentumok);
        makeBranch("USDJPY", Instrumentumok);
        makeBranch("GBPJPY", Instrumentumok);

        // Stratégiák
        Stratégiák = makeBranch("Stratégiák", root);
        makeBranch("Zoom",Stratégiák);
        makeBranch("TSQ",Stratégiák);
        makeBranch("ADX",Stratégiák);
        makeBranch("T200",Stratégiák);
        makeBranch("Classic",Stratégiák);

        // Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null)
                System.out.println(newValue.getValue());
        });

        // Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    // Create Branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        //item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
