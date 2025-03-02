module com.example.notepadjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.notepadjavafx to javafx.fxml;
    exports com.example.notepadjavafx;
    exports com.example.notepadjavafx.ui;
    opens com.example.notepadjavafx.ui to javafx.fxml;
    exports com.example.notepadjavafx.core;
    opens com.example.notepadjavafx.core to javafx.fxml;
    exports com.example.notepadjavafx.ui.eventHandler;
    opens com.example.notepadjavafx.ui.eventHandler to javafx.fxml;
}