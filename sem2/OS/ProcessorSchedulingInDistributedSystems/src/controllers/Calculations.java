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
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Calculations implements Initializable {

    @FXML
    private BarChart<Double, String> cpuUsageChart;

    @FXML
    private BarChart<Integer, String> requestsChart;

    @FXML
    private BarChart<Integer, String> migrationsChart;

    @FXML
    private Button back;

    @FXML
    private Button detailedResult;

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../assets/main.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            //get the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            tableViewScene.getStylesheets().add("./styles/style.css");


            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showDetailedResults(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../assets/detailedResults.fxml"));
        Stage newStage = new Stage();
        newStage.setTitle("Detailed Results");
        newStage.setScene(new Scene(root, 600, 400));
        newStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series cpuUsageSet = new XYChart.Series<>();
        cpuUsageSet.getData().add(new XYChart.Data("Min Threshold", Controller.maximumThresholdResultsArr.getAverageLoad()));
        cpuUsageSet.getData().add(new XYChart.Data("Random", Controller.randomResultsArr.getAverageLoad()));
        cpuUsageSet.getData().add(new XYChart.Data("Max Threshold", Controller.minimumThresholdResultsArr.getAverageLoad()));
        cpuUsageChart.getData().addAll(cpuUsageSet);

        XYChart.Series requestsSet = new XYChart.Series<>();
        requestsSet.getData().add(new XYChart.Data("Min Threshold", Controller.maximumThresholdResultsArr.getLoadRequests()));
        requestsSet.getData().add(new XYChart.Data("Random", Controller.randomResultsArr.getLoadRequests()));
        requestsSet.getData().add(new XYChart.Data("Max Threshold", Controller.minimumThresholdResultsArr.getLoadRequests()));
        requestsChart.getData().addAll(requestsSet);

        XYChart.Series migrationsSet = new XYChart.Series<>();
        migrationsSet.getData().add(new XYChart.Data("Min Threshold", Controller.maximumThresholdResultsArr.getLoadMigrations()));
        migrationsSet.getData().add(new XYChart.Data("Random", Controller.randomResultsArr.getLoadMigrations()));
        migrationsSet.getData().add(new XYChart.Data("Max Threshold", Controller.minimumThresholdResultsArr.getLoadMigrations()));
        migrationsChart.getData().addAll(migrationsSet);
    }
}
