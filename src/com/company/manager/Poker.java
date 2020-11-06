package com.company.manager;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


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


    public int countJoker() {
        int count = 0;
        while (hand.get(count) == 0) {
            count++;
        }
        return count;
    }

    public int findMaxSequence(Position maxPosition) {
        int joker = countJoker();
        int countJoker0 = joker;
        int maxLengthSequence = 1;
        int currentLengthSequence = 1;
        int currentPosition = joker;
        for (int i = joker; i < hand.size() - 1; i++) {
            if (hand.get(i + 1) - hand.get(i) == 1) {

                currentLengthSequence++;

            } else {
                if (hand.get(i + 1) - hand.get(i) - 1 <= joker && joker != 0) {
                    for (int j = 0; j < hand.get(i + 1) - hand.get(i) - 1; j++) {
                        joker--;
                        currentLengthSequence += 1;
                        System.out.println("Joker=" + (hand.get(i) + j + 1));
                    }
                    currentLengthSequence++;

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

        int endPosition = maxPosition.position + maxLengthSequence - (countJoker0 - joker);
        int card = hand.get(endPosition - 1);
        while ((card + 1) <= MIN_COLODA && joker > 0) {
            System.out.println("Joker=" + (card + 1));
            card++;
            joker--;
            maxLengthSequence++;
        }

        int startPosition = maxPosition.position;
        card = hand.get(startPosition);
        while (card > 0 && joker != 0) {
            System.out.println("Joker=" + (card - 1));
            card--;
            joker--;
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

    public void readFromFileHand(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        hand.clear();
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            if (count > countHand) throw new Exception("Over have");
            int card = scanner.nextInt();
            if (card > MIN_COLODA) throw new Exception("Wrong element");
            hand.add(card);

        }
        scanner.close();
        Utils.quickSort(hand, 0, hand.size() - 1);
    }

}
