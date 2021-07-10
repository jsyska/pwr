import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./assets/main.fxml"));
        primaryStage.setTitle("Processor Scheduling in Distributed Systems");
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add("./styles/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("assets/icon.png"));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
