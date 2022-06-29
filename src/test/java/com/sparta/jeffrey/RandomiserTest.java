package com.sparta.jeffrey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomiserTest {
    Randomiser randomiser = new Randomiser();
    @Test
    public void GetRandomArrayLength(){
        assertEquals(5,randomiser.makeIntArray(5));
    }
}