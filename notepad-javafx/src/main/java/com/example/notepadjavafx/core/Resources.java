package com.example.notepadjavafx.core;

import javafx.scene.image.Image;

import java.net.URL;

public class Resources {

    public static final URL mainWindowFxml;
    public static final URL notePadFxml;
    public static final URL mainWindowCss;
    public static final URL noteWindowCss;
    public static final Image notesLogoJpg;

    static {
        mainWindowFxml = Resources.class.getResource("/fxml/mainWindow.fxml");
        notePadFxml = Resources.class.getResource("/fxml/NotePad.fxml");
        assert notePadFxml!=null;
        mainWindowCss = Resources.class.getResource("/css/mainWindow.css");
        noteWindowCss = Resources.class.getResource("/css/NoteWindow.css");
        assert noteWindowCss!=null;
        URL notesLogoUrl = Resources.class.getResource("/image/NotesLogo.jpg");
        assert notesLogoUrl!=null;
        notesLogoJpg = new Image(notesLogoUrl.toExternalForm());
    }

}
