package com.example.endexam;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelloController {

    @FXML
    private Button btnEdit;

    @FXML
    private MenuItem btnExit;

    @FXML
    private Button btnLock;

    @FXML
    private MenuItem btnOpen;

    @FXML
    private MenuItem btnSave;

    @FXML
    private Label lblDisplay;

    @FXML
    private TextArea txtArea;

    FileChooser file = new FileChooser();

    @FXML
    void getCharacters(KeyEvent event) {
        lblDisplay.setText("Characters Typed: "+txtArea.getText().length());
    }

    @FXML
    void onEdit(ActionEvent event) {
        txtArea.setEditable(true);
        btnEdit.setDisable(true);
        btnLock.setDisable(false);
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onLock(ActionEvent event) {
        txtArea.setEditable(false);
        btnLock.setDisable(true);
        btnEdit.setDisable(false);
    }

    @FXML
    void onOpen(ActionEvent event) throws FileNotFoundException {
        File selectedFile = file.showOpenDialog(new Stage());
        Scanner input = new Scanner(selectedFile);
        txtArea.appendText("\n");
        while(input.hasNextLine()){
            txtArea.appendText(input.nextLine()+"\n");
        }
        input.close();
    }

    @FXML
    void onSave(ActionEvent event) throws FileNotFoundException {
        File selectedFile = file.showSaveDialog(new Stage());
        PrintWriter output = new PrintWriter(selectedFile);
        output.println(txtArea.getText());
        output.close();
    }

}
