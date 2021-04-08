package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/numbers.txt");
        System.out.println("---The sum of all numbers in file is " + calculateSumOfNumbers(file));
        System.out.println("---(Stream API) The sum of all numbers in file is " + calculateSumOfNumbersWithJava8(file.toPath()));
    }

    public static double calculateSumOfNumbers(File file) throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String lines;
        double sumOfAllNumbers = 0;

        try {
            while ((lines = bf.readLine()) != null) {
                if (lines.startsWith("#") || lines.trim().isEmpty()) {
                    continue;
                }
                sumOfAllNumbers += Double.parseDouble(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sumOfAllNumbers;
    }

    public static double calculateSumOfNumbersWithJava8(Path file) {
        double count = 0;
        try (Stream<String> stream = Files.lines(file)) {
            count = stream
                    .filter(line -> !line.startsWith("#"))
                    .filter(line -> !line.trim().isEmpty())
                    .map(Double::parseDouble)
                    .reduce(0.0, Double::sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}

