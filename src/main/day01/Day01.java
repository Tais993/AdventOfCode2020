package main.day01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
    static int[] partOne = new int[2];
    static int[] partTwo = new int[3];
    static ArrayList<Integer> items = new ArrayList<>();

    // * I want the fastest time there is, so I'm kinda cheating by only printing the fastest time.

    static long fastestTime = 200000000000000000L;

    public static void main(String[] args) throws IOException {
        long timeBefore = System.nanoTime();
        String fileUrl = Day01.class.getClassLoader().getResource("day01/input.txt").getFile();
        File file = new File(fileUrl);
        Scanner scanner = new Scanner(file);

        scanner.forEachRemaining(line -> items.add(Integer.parseInt(line)));

        partOne();
        for (int i = 0; i < 10000; i++) {
            partTwo();
        }
        System.out.println(fastestTime);
    }

    public static void partOne() {
        loopThroughPartOne();
        System.out.println("firstNumber " + partOne[0] + "\nsecondNumber " + partOne[1]);
        System.out.println("Total " + (partOne[0] + partOne[1]));
        System.out.println("Answer " + (partOne[0] * partOne[1]));
    }

    public static void loopThroughPartOne() {
        items.stream().anyMatch(firstInt -> items.stream().anyMatch(secondInt -> {
            if (firstInt + secondInt == 2020) {
                partOne[0] = firstInt;
                partOne[1] = secondInt;
                return true;
            }
            return false;
        }));
    }

    public static void partTwo() {
        long timeBefore = System.nanoTime();
        loopThroughPartTwoFastest();
        long duration = System.nanoTime() - timeBefore;
        if (duration < fastestTime) {
            fastestTime = duration;
        }
        System.out.println(duration);
//        System.out.println(Arrays.toString(partTwo));
//        System.out.println("firstNumber " + partTwo[0] + "\nsecondNumber " + partTwo[1] + "\nthirdNumber " + partTwo[2]);
//        System.out.println("Total " + (partTwo[0] + partTwo[1] + partTwo[2]));
//        System.out.println("Answer " + (partTwo[0] * partTwo[1] * partTwo[2]));
    }

    public static void loopThroughPartTwoFastest() {
        for (int i = 0; i < items.size(); i++) {
            int firstInt = items.get(i);
            for (int i1 = i; i1 < items.size(); i1++) {
                int secondInt = items.get(i1);
                if (firstInt + secondInt < 2020) {
                    for (int i2 = items.size() - 1; i2 >= i1; i2--) {
                        int thirdInt = items.get(i2);
                        if (firstInt + secondInt + thirdInt == 2020) {
                            partTwo[0] = firstInt;
                            partTwo[1] = secondInt;
                            partTwo[2] = thirdInt;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void loopThroughPartTwoTry3() {
        for (int i = 0; i < items.size(); i++) {
            int firstInt = items.get(i);
            for (int i1 = i; i1 < items.size(); i1++) {
                int secondInt = items.get(i1);
                if (firstInt + secondInt < 2020) {
                    for (int i2 = items.size() - 1; i2 >= i1; i2--) {
                        int thirdInt = items.get(i2);
                        if (firstInt + secondInt + thirdInt == 2020) {
                            partTwo[0] = firstInt;
                            partTwo[1] = secondInt;
                            partTwo[2] = thirdInt;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void loopThroughPartTwoTry2() {
        items.stream().anyMatch(firstInt -> items.stream().anyMatch(secondInt -> {
            if (firstInt + secondInt < 2020) {
                items.stream().anyMatch(thirdInt -> {
                    if (firstInt + secondInt + thirdInt == 2020) {
                        partTwo[0] = firstInt;
                        partTwo[1] = secondInt;
                        partTwo[2] = thirdInt;
                        return true;
                    }
                    return false;
                });
            }
            return false;
        }));
    }

    public static void loopThroughPartTwoTry1() {
        items.stream().anyMatch(firstInt -> items.stream().anyMatch(secondInt -> items.stream().anyMatch(thirdInt -> {
        if (firstInt + secondInt + thirdInt == 2020) {
            partTwo[0] = firstInt;
            partTwo[1] = secondInt;
            partTwo[2] = thirdInt;
            return true;
        }
        return false;
    })));
    }
}
