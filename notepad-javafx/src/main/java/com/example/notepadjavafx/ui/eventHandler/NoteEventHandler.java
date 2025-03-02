package com.example.notepadjavafx.ui.eventHandler;

import com.example.notepadjavafx.ui.NoteBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class NoteEventHandler implements EventHandler<ActionEvent> {

    protected final NoteBlock noteBlock;

    public NoteEventHandler(NoteBlock noteBlock) {
        super();
        this.noteBlock = noteBlock;
    }

    public NoteBlock getNoteBlock() {
        return noteBlock;
    }

}
