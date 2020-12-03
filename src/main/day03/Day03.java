package main.day03;

import main.day01.Day01;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Day03 {
    static Scanner scanner;

    public static void main(String[] args) throws IOException, URISyntaxException {
        URI fileUrl = Day01.class.getClassLoader().getResource("day03_input").toURI();
        File file = new File(fileUrl);
        scanner = new Scanner(file);

//        partOne(Files.readAllLines(Path.of(fileUrl)));
        partTwo(Files.readAllLines(Path.of(fileUrl)));
    }

    public static void partOne(List<String> lines) {
        int cords = 3;
        int totalTrees = 0;

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            cords += 3;
            if (line.length() <= cords ) {
                cords = cords % line.length();
            }
            totalTrees += ((line.charAt(cords) == '#') ? 1 : 0);
        }

        System.out.println(totalTrees);
    }

    public static void partTwo(List<String> lines) {
        int cords = 3;
        int totalTrees = 0;

        for (String line : lines) {
            while (line.length() > cords-1) {
                totalTrees += ((line.charAt(cords) == '#') ? 1 : 0);
                cords += 3;
            }
            cords = cords % line.length();
        }

        System.out.println(totalTrees);
    }
}
