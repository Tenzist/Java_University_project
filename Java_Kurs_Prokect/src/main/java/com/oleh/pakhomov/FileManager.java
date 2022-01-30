package com.oleh.pakhomov;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    SceneController sceneController = new SceneController();
    public FileManager(File file) {
        this.file = file;
    }
    private final File file;
    public void saveToFile(String data) {
        try {
            if (!file.exists() || !file.isFile()) {
                file.createNewFile();
            }
            var printer = new PrintWriter(file.getPath());
            printer.flush();
            printer.write(data);
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<String> loadFromFile() {
        try {
            if (!file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("File don't exist");
            }
            var data = Files.readAllLines(Paths.get(file.toURI()));
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
