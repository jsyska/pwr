package controllers;

import algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static int[][] processes;
    public static FrameAllocation[] frameAllocations;
    private static int processesNumber;
    private static int pagesNumber;
    private static int minNumberOfReferencesInt;
    private static int maxNumberOfReferencesInt;
    private static int localityRangeInt;
    private static int framesNumberInt;
    private static int equalResult;
    private static int proportionalResult;
    private static int pageFaultFrequencyResult;
    private static int workingSetResult;
    private static int randomResult;

    @FXML
    private TextField numberOfFrames;

    @FXML
    private TextField numberOfPages;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField numberOfProcesses;

    @FXML
    private TextField minNumberOfReferences;

    @FXML
    private TextField maxNumberOfReferences;

    @FXML
    private TextField localityRange;

    @FXML
    void calculate(ActionEvent event) {
        processesNumber = Integer.valueOf(numberOfProcesses.getText());
        pagesNumber = Integer.valueOf(numberOfPages.getText());
        minNumberOfReferencesInt = Integer.valueOf(minNumberOfReferences.getText());
        maxNumberOfReferencesInt = Integer.valueOf(maxNumberOfReferences.getText());
        localityRangeInt = Integer.valueOf(localityRange.getText());
        framesNumberInt = Integer.valueOf(numberOfFrames.getText());
        processes = new Generator(
                processesNumber,
                pagesNumber,
                minNumberOfReferencesInt,
                maxNumberOfReferencesInt,
                localityRangeInt
        ).generateProcesses();
        calculateButton.setVisible(true);

        frameAllocations = new FrameAllocation[] {
                new Equal(copy(processes), framesNumberInt),
                new Proportional(copy(processes), framesNumberInt),
                new PageFaultFrequency(copy(processes), framesNumberInt),
                new WorkingSet(copy(processes), framesNumberInt),
                new Random(copy(processes), framesNumberInt)
        };

        int[] results = new int[5];
        int r = 0;
        for (FrameAllocation fa : frameAllocations){
            results[r] = fa.execute();
            r++;
        }
        equalResult = results[0];
        proportionalResult= results[1];
        pageFaultFrequencyResult = results[2];
        workingSetResult = results[3];
        randomResult = results[4];

        changeScene(event);
    }

    private static int[][] copy(int[][] array) {
        return Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void changeScene(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../assets/calculations.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String printFaults(){
        return "Equal: " + equalResult
                + "\nProportional: " + proportionalResult
                + "\nPageFaultFrequency: " + pageFaultFrequencyResult
                + "\nWorkingSet: " + workingSetResult
                + "\nRandom: " + randomResult;
    }


    public static int getEqualResult() {
        return equalResult;
    }

    public static int getProportionalResult() {
        return proportionalResult;
    }

    public static int getPageFaultFrequencyResult() {
        return pageFaultFrequencyResult;
    }

    public static int getWorkingSetResult() {
        return workingSetResult;
    }

    public static int getRandomResult() {
        return randomResult;
    }
}
