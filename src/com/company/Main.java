package com.company;

public class Main {

    public static void main(String[] args) {
        Poker poker = new Poker(100, 10);
        poker.generation();
        poker.shuffle();
        poker.writeColoda("coloda.txt");
        poker.giveOnHand();
        poker.writeHand("lngpoker.txt");
        poker.showHand();
        System.out.println();
        Position maxPosition = new Position();
        int maxLength = poker.findMaxSequence(maxPosition, poker.countJoker());
        System.out.println("MaxLength=" + maxLength + " " + "MaxPosition=" + maxPosition.position);
    }
}
