package model;

import java.util.Random;

public class Dice {
//    private final int minValue = 1;
//    private final int maxValue = 6;
    public int roll(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
