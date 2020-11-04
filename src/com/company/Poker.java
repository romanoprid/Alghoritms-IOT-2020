package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Poker {
    private final List<Integer> coloda;
    private List<Integer> hand;
    private final int countColoda;
    private final int countHand;
    private final int MIN_COLODA = 36;

    public Poker(int countColoda, int countHand) {
        this.countColoda = countColoda;
        this.countHand = countHand;
        this.coloda = new LinkedList<Integer>();
        this.hand = new LinkedList<Integer>();
    }


    public void generation() {
        for (int i = 0; i < countColoda; i++) {
            coloda.add(i % (MIN_COLODA + 1));
        }

    }

    public void shuffle() {
        Random random = new Random();
        int n = random.nextInt(countColoda / 3);
        for (int i = 0; i < n; i++) {
            int firstIndex = random.nextInt(countColoda);
            int secondIndex = random.nextInt(countColoda);
            if (firstIndex != secondIndex) {
                int buffer = coloda.get(firstIndex);
                coloda.set(firstIndex, coloda.get(secondIndex));
                coloda.set(secondIndex, buffer);
            }
        }
    }


    public void writeColoda(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Integer element : coloda) {

                writer.write(element + " ");
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    public void writeHand(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Integer element : hand) {

                writer.write(element + " ");
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }




    public void giveOnHand() {
        try {
            hand.clear();
            for (int i = 0; i < countHand; i++) {
                hand.add(coloda.get(i));
            }

        } catch (Exception e) {
            System.out.println("Give is impossible!!!");
        }
        Utils.quickSort(hand, 0, hand.size() - 1);

    }


    public int countJoker() {
        int count = 0;
        while (hand.get(count) == 0) {
            count++;
        }
        return count;
    }

    public int findMaxSequence(Position maxPosition, int countJoker) {
        int maxLengthSequence = 1;
        int currentLengthSequence = 1;
        int currentPosition = countJoker;
        for (int i = countJoker; i < hand.size() - 1; i++) {
            if (hand.get(i + 1) - hand.get(i) == 1) {
                currentLengthSequence++;
            } else {
                if (hand.get(i + 1) - hand.get(i) == 2 && countJoker != 0) {
                    countJoker--;
                    currentLengthSequence += 2;
                    System.out.println("Joker=" + (hand.get(i) + 1));
                } else {

                    if (currentLengthSequence > maxLengthSequence) {
                        maxLengthSequence = currentLengthSequence;
                        maxPosition.position = currentPosition;
                    }
                    currentLengthSequence = 1;
                    currentPosition = i + 1;

                }

            }


        }

        if (currentLengthSequence > maxLengthSequence) {
            maxLengthSequence = currentLengthSequence;
            maxPosition.position = hand.size() - currentLengthSequence;
        }

        int endPosition = maxPosition.position + maxLengthSequence;
        int card = hand.get(endPosition - 1);
        while ((card + 1) <= MIN_COLODA && countJoker > 0) {
            System.out.println("Joker=" + (card + 1));
            card++;
            countJoker--;
            maxLengthSequence++;
        }

        int startPosition = maxPosition.position;
        card = hand.get(startPosition);
        while (card > 0 && countJoker != 0) {
            System.out.println("Joker=" + (card - 1));
            card--;
            countJoker--;
            maxLengthSequence++;
            maxPosition.position--;

        }

        return maxLengthSequence;
    }


    public void showHand() {
        for (Integer element : hand) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

//    public void setHand(int[] array) {
//        hand = new LinkedList<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            hand.add(array[i]);
//        }
//        Utils.quickSort(hand, 0, array.length - 1);
//    }


}
