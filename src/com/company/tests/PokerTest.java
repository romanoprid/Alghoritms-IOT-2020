package com.company.tests;

import com.company.manager.Poker;
import com.company.manager.Position;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {

    @org.junit.jupiter.api.Test
    public void findMaxSequence() throws Exception {
        Poker poker = new Poker(100, 10000);
        Position maxPosition = new Position();
        poker.readFromFileHand("test1.txt");
        assertEquals(8, poker.findMaxSequence(maxPosition));
    }
}