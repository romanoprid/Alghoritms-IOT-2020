package com.company.manager;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Poker poker = new Poker(100, 10000);
        poker.generation();
        try {
            try {
                poker.readFromFileHand("lngpoker.txt");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new Exception("Error");
            }
            poker.showHand();
            System.out.println();
            Position maxPosition = new Position();
            int maxLength = poker.findMaxSequence(maxPosition);
            System.out.println("MaxLength=" + maxLength + " " + "MaxPosition=" + maxPosition.position);
            writeResult("result.txt", maxLength);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeResult(String fileName, int result) throws IOException {

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(result + "");
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
