package controllers;

import algorithms.*;
import algorithms.Process;
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
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.range;

public class Controller implements Initializable {

    private static int processorsNumberInt;
    private static int processesNumberInt;
    private static double maxProcessorLoadDouble;
    private static double minProcessorLoadDouble;
    private static double processMinLoadDouble;
    private static double processMaxLoadDouble;
    private static int processMinTimeInt;
    private static int processMaxTimeInt;
    private static int maxMigrationRequestsInt;
    public static ProcessorAllocationStats maximumThresholdResultsArr;
    public static ProcessorAllocationStats minimumThresholdResultsArr;
    public static ProcessorAllocationStats randomResultsArr;
    public static Process[] processes;
    public static ProcessorAllocationManager[] managers;
    List<Processor> processors;
    ProcessorAllocationStats[] results;


    @FXML
    private TextField processorsNumber;

    @FXML
    private TextField processesNumber;

    @FXML
    private TextField maxProcessorLoad;

    @FXML
    private TextField minProcessorLoad;

    @FXML
    private TextField processMinLoad;

    @FXML
    private TextField processMaxLoad;

    @FXML
    private TextField processMinTime;

    @FXML
    private TextField processMaxTime;

    @FXML
    private TextField maxMigrationRequests;

    @FXML
    private Button calculateButton;

    @FXML
    private Button defaultDataButton;

    @FXML
    void calculate(ActionEvent event) {
        processorsNumberInt = Integer.valueOf(processorsNumber.getText());
        processesNumberInt = Integer.valueOf(processesNumber.getText());
        maxProcessorLoadDouble = Double.parseDouble(maxProcessorLoad.getText());
        minProcessorLoadDouble = Double.parseDouble(minProcessorLoad.getText());
        processMinLoadDouble = Double.parseDouble(processMinLoad.getText());
        processMaxLoadDouble = Double.parseDouble(processMaxLoad.getText());
        processMinTimeInt = Integer.valueOf(processMinTime.getText());
        processMaxTimeInt = Integer.valueOf(processMaxTime.getText());
        maxMigrationRequestsInt = Integer.valueOf(maxMigrationRequests.getText());
        processors = generateProcessors(processorsNumberInt);
        processes = new ProcessGenerator(
                processMinLoadDouble,
                processMaxLoadDouble,
                processMinTimeInt,
                processMaxTimeInt
        ).generate(processesNumberInt);

        managers = new ProcessorAllocationManager[] {
                new MaximumThreshold(copyProcessors(processors), maxMigrationRequestsInt),
                new Random(copyProcessors(processors)),
                new MinimalThreshold(copyProcessors(processors), maxMigrationRequestsInt),
        };
        int i = 0;
        results = new ProcessorAllocationStats[3];
        for (ProcessorAllocationManager manager : managers) {
            ProcessorAllocationStats temp = manager.process(processesQueue(processes));
            System.out.println(temp);
            results[i] = temp;
            i++;
        }
        maximumThresholdResultsArr = results[0];
        randomResultsArr=results[1];
        minimumThresholdResultsArr=results[2];

        changeScene(event);
    }

    private static List<Processor> generateProcessors(int numberOfProcessors) {
        return range(0, numberOfProcessors)
                .mapToObj(i -> new Processor(minProcessorLoadDouble, maxProcessorLoadDouble))
                .collect(toList());
    }

    public static Queue<Process> processesQueue(Process[] processes) {
        Queue<Process> copy = new LinkedList<>();
        for (Process process : processes)
            copy.add(new Process(process));
        return copy;
    }

    public static List<Processor> copyProcessors(List<Processor> processors) {
        List<Processor> copy = new ArrayList<>(processors.size());
        for (Processor processor : processors) {
            copy.add(new Processor(processor));
        }
        return copy;
    }

    @FXML
    void geberateDefaultData(ActionEvent event) {
        processorsNumber.setText("75");
        processesNumber.setText("10000");
        maxProcessorLoad.setText("0.5");
        minProcessorLoad.setText("0.3");
        processMinLoad.setText("0.1");
        processMaxLoad.setText("0.6");
        processMinTime.setText("50");
        processMaxTime.setText("100");
        maxMigrationRequests.setText("15");
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

}

