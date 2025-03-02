package com.example.notepadjavafx.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class NoteManager {

    private final List<Note> notes = new ArrayList<>();
    private final SimpleDateFormat idFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    private static NoteManager noteManager;

    public static NoteManager get() {
        if (noteManager == null)
            noteManager = new NoteManager();
        return noteManager;
    }

    public NoteManager() {
        deserialize();
    }

    public Note create() {
        Date now = new Date();
        Note note = new Note(
                idFormatter.format(now),
                "",
                "",
                dateFormatter.format(now)
        );
        notes.add(note);
        return note;
    }

    public void delete(Note note) {
        notes.remove(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void serialize() {
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(notes);
            Files.writeString(Paths.get("src/main/resources/notes.json"), json);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save notes", e);
        }
    }

    private void deserialize() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("notes.json")) {
            if (inputStream == null)
                throw new IOException("Resource not found: notes.json");

            ArrayList<LinkedHashMap<String, String>> nodes = new ObjectMapper().readValue(inputStream, new TypeReference<>() {
            });
            for (LinkedHashMap<String, String> noteMap : nodes) {
                notes.add(new Note(
                        noteMap.get("id"),
                        noteMap.get("title"),
                        noteMap.get("content"),
                        noteMap.get("date")
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
