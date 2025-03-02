package com.example.notepadjavafx.ui;

import com.example.notepadjavafx.core.Resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NotePadWindow {

    private final Parent notePadRoot;
    private final Stage notePadStage;

    public NotePadWindow() throws IOException {
        notePadRoot = FXMLLoader.load(Resources.notePadFxml);
        Scene notePadScene = new Scene(notePadRoot);
        notePadScene.getStylesheets().add(Resources.noteWindowCss.toExternalForm());
        notePadStage = new Stage();
        notePadStage.setScene(notePadScene);
        notePadStage.setTitle("Note");
        notePadStage.getIcons().add(Resources.notesLogoJpg);
        notePadStage.setResizable(false);
    }

    public Parent getNotePadRoot() {
        return notePadRoot;
    }

    public Stage getNotePadStage() {
        return notePadStage;
    }

}
