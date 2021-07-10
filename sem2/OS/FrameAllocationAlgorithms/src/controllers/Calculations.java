package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Calculations implements Initializable {

    Controller ctrl = new Controller();

    @FXML
    private Button back;

    @FXML
    private BarChart<Integer, String> pagesChart;

    @FXML
    private Label faults;


    @FXML
    private Button detailedResults;

    @FXML
    void showDetailedResults(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../assets/detailedResults.fxml"));
        Stage newStage = new Stage();
        newStage.setTitle("Detailed Results");
        newStage.setScene(new Scene(root, 492, 331));
        newStage.show();
    }


    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../assets/sample.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //get the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series set = new XYChart.Series<>();
        set.getData().add(new XYChart.Data("Equal",Controller.getEqualResult()));
        set.getData().add(new XYChart.Data("Proportional",Controller.getProportionalResult()));
        set.getData().add(new XYChart.Data("Page fault frequency",Controller.getPageFaultFrequencyResult()));
        set.getData().add(new XYChart.Data("Working set",Controller.getWorkingSetResult()));
        set.getData().add(new XYChart.Data("Random",Controller.getRandomResult()));
        pagesChart.getData().addAll(set);

        faults.setText(ctrl.printFaults());
    }
}
