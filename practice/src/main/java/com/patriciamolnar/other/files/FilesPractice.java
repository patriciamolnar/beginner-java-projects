package com.patriciamolnar.other.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class FilesPractice {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/patriciamolnar/Documents/chinese.txt");

        FilesPractice fp = new FilesPractice(); 
        fp.writeFile(path, "我学习爪哇。我非常喜欢。");
        fp.readFile(path);
    }

    private void writeFile(Path path, String text) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (IOException ioe) {
            errorCallback(ioe);
        }
    }

    private void readFile(Path path) {
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch(IOException ioe) {
            errorCallback(ioe);
        }
    }

    private void errorCallback(IOException ioe) {
        ioe.printStackTrace();
        ioe.getMessage();
    }
}

/**
 * todo:
 * find a way to write to an existing file, instead of overwriting it. 
 * 
 * 
 * alternative options to create a path
 * Paths.get("c:/tmp/debug.log");
 * 
 * URI.create("file://c:/tmp/debug.log");
 * path3 = Paths.get(uri);
 * 
 * newBufferedReader - default charset is StandardCharsets.UTF_8
 * if wrong charset defined, will throw MalformedInputException exception
 * 
 * to check if a file under path exists: 
 * boolean exists = Files.exists(path);
 * 
 * one way to write to file
 * BufferedWriter writer = Files.newBufferedWriter(path);
 * writer.write(text);
 * writer.flush(); //transfers what has been written to the file
 * writer.close();
 */