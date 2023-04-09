package com.patriciamolnar.other.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesPractice2 {
    // private final String path = "./practice/src/main/java/com/patriciamolnar/other/files/test.txt";
    private final String path = "files/data.txt";

    public static void main(String[] args) throws IOException {
        FilesPractice2 fp = new FilesPractice2();

        File f = new File(fp.path);
        FileWriter fw = new FileWriter(fp.path, true);
        BufferedWriter bWriter = new BufferedWriter(fw);
        
        f.createNewFile(); 
        f.canWrite(); 
        for(int i = 0; i < 5; i++) {
            bWriter.write(Integer.toString(i));
            bWriter.newLine();
        }
        bWriter.close();
    } 
}

/*
 * how to add relative paths?
 * create CSV file (how to format content) 
 */


/**
 * write a program that asks specific questions 
 * and then writes it into the text file
 * 
 */

/**
 * File.createNewFile() returns boolean: 
 * true if file has been created
 * false if it already exists
 */