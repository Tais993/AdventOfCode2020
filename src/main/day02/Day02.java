package main.day02;

import main.day01.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day02 {
    static ArrayList<Password> passwords = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        String fileUrl = Day01.class.getClassLoader().getResource("day02.txt").getFile();
        Scanner scanner = new Scanner(new File(fileUrl));

        while (scanner.hasNext()) {
            String firstPart = scanner.next();
            String[] requiredMinMax = firstPart.split("-");
            int minRequired = Integer.parseInt(requiredMinMax[0]);
            int maxRequired = Integer.parseInt(requiredMinMax[1]);

            String secondPart = scanner.next();
            char charRequired = secondPart.charAt(0);
            String password = scanner.next();

            passwords.add(new Password(minRequired, maxRequired, charRequired, password));
        }
        int validPasswords = (int) passwords.stream().filter(Password::isValidPartTwo).count();
        System.out.println(validPasswords);
    }
}
