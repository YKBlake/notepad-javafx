package com.example.notepadjavafx.ui;

import com.example.notepadjavafx.core.Note;
import com.example.notepadjavafx.core.NoteManager;
import com.example.notepadjavafx.ui.eventHandler.EditEventHandler;
import com.example.notepadjavafx.ui.eventHandler.ExitEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

import java.io.IOException;

public class NoteBlock {

    private final AnchorPane anchorPane;
    private final NotePadWindow notepadWindow;
    private final FlowPane flowPane;
    private final Label titleLabel;
    private final Label dateLabel;
    private final Button exitButton;
    private final Button editButton;

    private final Note note;

    public NoteBlock(FlowPane flowPane) throws IOException {
        notepadWindow = new NotePadWindow();
        this.flowPane = flowPane;
        this.note = NoteManager.get().create();
        anchorPane = new AnchorPane();
        titleLabel = new Label(note.title);
        dateLabel = new Label(note.date);
        exitButton = new Button("X");
        editButton = new Button("...");
        init();
    }

    public NoteBlock(FlowPane flowPane, Note note) throws IOException {
        notepadWindow = new NotePadWindow();
        this.flowPane = flowPane;
        this.note = note;
        anchorPane = new AnchorPane();
        titleLabel = new Label(note.title);
        dateLabel = new Label(note.date);
        exitButton = new Button("X");
        editButton = new Button("...");
        init();
    }

    private void init() {
        initAnchorPane();
        initTitleLabel();
        initDateLabel();
        initExitButton();
        initEditButton();
    }

    private void initAnchorPane() {
        anchorPane.setPrefWidth(392);
        anchorPane.setMaxWidth(392);
        anchorPane.setMinWidth(392);
        anchorPane.setPrefHeight(68);
        anchorPane.setMaxHeight(68);
        anchorPane.setMinHeight(68);
    }

    private void initTitleLabel() {
        titleLabel.setLayoutX(14);
        titleLabel.setLayoutY(20);
        titleLabel.setPrefHeight(34);
        titleLabel.setPrefWidth(344);
        titleLabel.setFont(new Font(20));
        anchorPane.getChildren().add(titleLabel);
    }

    private void initDateLabel() {
        dateLabel.setLayoutX(14);
        dateLabel.setLayoutY(0);
        dateLabel.setPrefHeight(25);
        dateLabel.setPrefWidth(344);
        dateLabel.setFont(new Font(10));
        anchorPane.getChildren().add(dateLabel);
    }

    private void initExitButton() {
        exitButton.setLayoutX(360);
        exitButton.setLayoutY(4);
        exitButton.setPrefHeight(30);
        exitButton.setPrefWidth(30);
        exitButton.setFont(new Font(15));
        exitButton.setOnAction(new ExitEventHandler(this));
        anchorPane.getChildren().add(exitButton);
    }

    private void initEditButton() {
        editButton.setLayoutX(360);
        editButton.setLayoutY(34);
        editButton.setPrefHeight(30);
        editButton.setPrefWidth(30);
        editButton.setFont(new Font(15));
        editButton.setOnAction(new EditEventHandler(this));
        anchorPane.getChildren().add(editButton);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public NotePadWindow getNotePadWindow() {
        return notepadWindow;
    }

    public FlowPane getFlowPane() {
        return flowPane;
    }

    public Note getNote() {
        return note;
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

}
