package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/numbers.txt");
        System.out.println("---The sum of all numbers in file is "+calculateSumOfNumbers(file));
    }

    public static float calculateSumOfNumbers(File file) throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String lines;
        float sumOfAllNumbers = 0;

        try {
            while ((lines = bf.readLine()) != null) {
                if (lines.startsWith("#") || lines.trim().isEmpty()) {
                    System.out.println("Skipped the ignored or empty line");
                    continue;
                }
                sumOfAllNumbers += Float.parseFloat(lines);
                System.out.println(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sumOfAllNumbers;
    }
}

