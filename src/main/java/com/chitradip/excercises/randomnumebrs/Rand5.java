package com.chitradip.excercises.randomnumebrs;

import java.util.Random;

/** this is a "given" class **?
 *
 *
 */
public class Rand5 {

    private static Random random = new Random();

    public int rand5() {
        return random.nextInt(5);
    }
}
