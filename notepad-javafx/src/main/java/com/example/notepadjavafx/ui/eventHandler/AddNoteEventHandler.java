package com.example.notepadjavafx.ui.eventHandler;

import com.example.notepadjavafx.ui.NoteBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class AddNoteEventHandler implements EventHandler<ActionEvent> {

    private final Parent root;

    public AddNoteEventHandler(Parent root) {
        this.root=root;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FlowPane fp = null;
        for (Node component1 : root.getChildrenUnmodifiable()) {
            if ("noteScrollPane".equals(component1.getId()))
                fp = (FlowPane) ((ScrollPane) component1).getContent();
        }
        NoteBlock noteBlock;
        try {
            noteBlock = new NoteBlock(fp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fp.getChildren().add(noteBlock.getAnchorPane());
    }
}
