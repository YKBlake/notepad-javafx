package com.example.notepadjavafx.ui.eventHandler;

import com.example.notepadjavafx.ui.NoteBlock;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditEventHandler extends NoteEventHandler {

    public EditEventHandler(NoteBlock noteBlock) {
        super(noteBlock);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String title = getNoteBlock().getNote().title;
        String text = getNoteBlock().getNote().content;
        for (Node component : getNoteBlock().getNotePadWindow().getNotePadRoot().getChildrenUnmodifiable()) {
            String id = component.getId();
            if ("noteTextArea".equals(id)) {
                TextArea noteTextArea = (TextArea) component;
                noteTextArea.setText(text);
                noteTextArea.textProperty().addListener((observable, oldValue, newValue) -> getNoteBlock().getNote().content = newValue);
            } else if ("titleTextField".equals(id)) {
                TextField textField = (TextField) component;
                textField.setText(title);
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    getNoteBlock().getNote().title = newValue;
                    getNoteBlock().getTitleLabel().setText(newValue);
                });
            }
        }
        getNoteBlock().getNotePadWindow().getNotePadStage().show();
    }
}
