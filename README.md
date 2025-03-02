# JavaFX Notepad Application

## Overview
This is a simple Notepad application built using **JavaFX**. It allows users to write, edit, and save notes in a JSON file format. The application provides a clean and user-friendly interface for handling text-based content.

## Features
- **Create and Edit Notes**: Users can write and modify text in a notepad-style interface.
- **Save to JSON**: Notes are saved in a structured JSON format for easy retrieval.
- **Load Notes**: Previously saved notes can be loaded and edited.
- **User-friendly UI**: Simple and intuitive design using JavaFX components.

## Technologies Used
- **JavaFX** for GUI development
- **Jackson (or Gson)** for JSON handling
- **Maven/Gradle** (if applicable) for dependency management

## Installation and Usage
### Prerequisites
- **Java 17 or later** (Ensure JavaFX is included if using JDK 11+)
- **Maven or Gradle** (Optional for dependency management)

### Running the Application
1. Clone this repository:
   ```sh
   git clone https://github.com/YKBlake/notepad-javafx.git
   cd javafx-notepad
   ```
2. Compile and run the application:
   ```sh
   mvn javafx:run
   ```
   Or, if using Gradle:
   ```sh
   gradle run
   ```
   Alternatively, if running manually:
   ```sh
   javac --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -d bin src/**/*.java
   java --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp bin Main
   ```

## JSON File Structure
Notes are stored in a JSON file (e.g., `notes.json`) with the following structure:
```json
[
  {
    "title": "My First Note",
    "content": "This is a sample note."
  },
  {
    "title": "Shopping List",
    "content": "- Milk\n- Bread\n- Eggs"
  }
]
```

## Future Enhancements
- **Dark Mode Support**
- **Multiple Note Tabs**
- **Markdown Support**

## License
This project is open-source and available under the **MIT License**.

## Author
- YKBlake
