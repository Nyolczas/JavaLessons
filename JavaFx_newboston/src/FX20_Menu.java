import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FX20_Menu extends Application{

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu demo");

        // ===============================================================================================
        // File menu
        Menu fileMenu = new Menu("_File");

        // File Menü elemek
        MenuItem mentes = new MenuItem("Mentés...");
        mentes.setOnAction(e -> System.out.println("Elmentette a változtatásokat"));
        fileMenu.getItems().add(mentes);

        fileMenu.getItems().add(new MenuItem("Frissítés"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Új stratégia..."));
        fileMenu.getItems().add(new MenuItem("Beállítások..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Kilépés..."));

        // ===============================================================================================
        // Instrumentumok menü
        Menu instrumentMenu = new Menu("_Instrumentumok");
        instrumentMenu.getItems().add(new MenuItem("Összes"));
        instrumentMenu.getItems().add(new SeparatorMenuItem());
        instrumentMenu.getItems().add(new MenuItem("AUDUSD"));
        instrumentMenu.getItems().add(new MenuItem("AUDJPY"));
        instrumentMenu.getItems().add(new MenuItem("CHFJPY"));
        instrumentMenu.getItems().add(new MenuItem("EURCHF"));
        instrumentMenu.getItems().add(new MenuItem("EURAUD"));
        instrumentMenu.getItems().add(new MenuItem("EURGBP"));
        instrumentMenu.getItems().add(new MenuItem("EURUSD"));
        instrumentMenu.getItems().add(new MenuItem("EURJPY"));
        instrumentMenu.getItems().add(new MenuItem("GBPUSD"));
        instrumentMenu.getItems().add(new MenuItem("GBPJPY"));
        instrumentMenu.getItems().add(new MenuItem("GOLD"));
        instrumentMenu.getItems().add(new MenuItem("USDCHF"));

        MenuItem USDJPY = new MenuItem("USDJPY");
        USDJPY.setOnAction(e -> System.out.println("Betölti az USDJPY Scenét"));
        instrumentMenu.getItems().add(USDJPY);

        MenuItem USDMXN = new MenuItem("USDMXN");
        USDMXN.setOnAction(e -> System.out.println("Betölti az USDMXN Scenét"));
        USDMXN.setDisable(true);
        instrumentMenu.getItems().add(USDMXN);

        // ===============================================================================================
        // Beállítások menü
        Menu beallMenu = new Menu("_Beállítások");

        CheckMenuItem showLines = new CheckMenuItem("Mutassa a sor számozást");
        showLines.setOnAction(e-> {
            if(showLines.isSelected())
                System.out.println("Most mutatja a sor számozást");
            else
                System.out.println("Most elrejti a sor számozását");
        });

        CheckMenuItem autoSave = new CheckMenuItem("Automatikus mentés");
        autoSave.setOnAction(e-> {
            if(autoSave.isSelected())
                System.out.println("Automatikus mentés bekapcsolva");
            else
                System.out.println("Automatikus mentés kikapcsolva");
        });
        autoSave.setSelected(true);

        beallMenu.getItems().addAll(showLines, autoSave);

        // ===============================================================================================
        // Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, instrumentMenu, beallMenu);

        // ===============================================================================================
        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
