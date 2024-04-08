module com.example.endexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.endexam to javafx.fxml;
    exports com.example.endexam;
}