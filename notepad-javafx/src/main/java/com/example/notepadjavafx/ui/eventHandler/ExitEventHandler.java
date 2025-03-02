package com.example.notepadjavafx.ui.eventHandler;

import com.example.notepadjavafx.core.NoteManager;
import com.example.notepadjavafx.ui.NoteBlock;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ExitEventHandler extends NoteEventHandler {

    public ExitEventHandler(NoteBlock noteBlock) {
        super(noteBlock);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ObservableList<Node> children = getNoteBlock().getFlowPane().getChildren();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i) != this.getNoteBlock().getAnchorPane())
                continue;
            NoteManager.get().delete(getNoteBlock().getNote());
            children.remove(i);
            return;
        }
    }
}
