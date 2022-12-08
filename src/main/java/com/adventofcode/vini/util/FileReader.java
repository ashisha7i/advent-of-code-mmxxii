package com.adventofcode.vini.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> allLines(String fileName) {
        List<String> fileLines = new ArrayList<>();

        InputStream is = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNextLine()) {
            fileLines.add(scanner.nextLine());
        }
        scanner.close();
        return fileLines;
    }

    public static List<String> allLinesFrom(String fileName, int startingLine) {
        int currentLine = 0;
        List<String> fileLines = new ArrayList<>();

        InputStream is = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNextLine()) {
            currentLine++;
            if(currentLine < startingLine) {
                scanner.nextLine();
                continue;
            }
            fileLines.add(scanner.nextLine());
        }
        scanner.close();
        return fileLines;
    }
}
