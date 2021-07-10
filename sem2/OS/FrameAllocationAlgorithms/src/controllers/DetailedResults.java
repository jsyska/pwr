package controllers;

import algorithms.FrameAllocation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailedResults implements Initializable {

    @FXML
    private TextArea console;
    private PrintStream ps;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ps = new PrintStream(new Console(console));
        System.setOut(ps);
        System.setErr(ps);
        for (int i = 0; i < Controller.processes.length; ++i) {
            System.out.println("\n_______________ Results for process " + i + ":");
            for (FrameAllocation fa : Controller.frameAllocations)
                System.out.println(fa.getClass().getSimpleName() + ": " + fa.gerProcessResult(i));
        }
    }

    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char) b));
        }
    }
}
