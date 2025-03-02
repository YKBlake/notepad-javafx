package com.example.notepadjavafx;

import com.example.notepadjavafx.core.Note;
import com.example.notepadjavafx.core.NoteManager;
import com.example.notepadjavafx.core.Resources;
import com.example.notepadjavafx.ui.NoteBlock;
import com.example.notepadjavafx.ui.eventHandler.AddNoteEventHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

public class NotesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NoteManager noteManager = NoteManager.get();
        List<Note> notes = noteManager.getNotes();
        assert Resources.mainWindowFxml != null;
        Parent root = FXMLLoader.load(Resources.mainWindowFxml);
        for (Node component : root.getChildrenUnmodifiable()) {
            String componentId = component.getId();
            if ("noteScrollPane".equals(componentId)) {
                FlowPane flowpane = (FlowPane) ((ScrollPane) component).getContent();
                if (notes != null)
                    for (Note note : notes) {
                        NoteBlock noteBlock = new NoteBlock(flowpane, note);
                        flowpane.getChildren().add(noteBlock.getAnchorPane());
                    }
            } else if ("noteAddButton".equals(componentId)) {
                ((Button) component).setOnAction(new AddNoteEventHandler(root));
            }
        }
        Scene scene = new Scene(root);
        assert Resources.mainWindowCss != null;
        scene.getStylesheets().add(Resources.mainWindowCss.toExternalForm());
        stage.setScene(scene);
        stage.setTitle("My Notes");
        stage.getIcons().add(Resources.notesLogoJpg);
        stage.setResizable(false);
        stage.setOnCloseRequest(windowEvent -> NoteManager.get().serialize());
        stage.show();
    }

}
