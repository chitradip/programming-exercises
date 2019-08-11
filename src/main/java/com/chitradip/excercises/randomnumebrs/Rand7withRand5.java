package com.chitradip.excercises.randomnumebrs;

import java.util.Random;

//
public class Rand7withRand5 {

    private Rand5 rand5;

    Rand7withRand5(Rand5 rand5) {

        this.rand5 = rand5;
    }


    public int rand7() {

        int rand25 = 5*rand5.rand5() + rand5.rand5();
        while ( rand25 > 20) {

            //recalculate rand
            rand25 =  5*rand5.rand5() + rand5.rand5();
        }

        return rand25 % 7;
    };
}
