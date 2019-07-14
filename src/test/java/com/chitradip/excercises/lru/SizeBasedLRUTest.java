package com.chitradip.excercises.lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeBasedLRUTest {

    private SizeBasedLRU<Integer, String> cache = new SizeBasedLRU<>(3);

    @Test
    public void sizeTest() {

        for ( int i =0; i < 10; i++ ){
            cache.putCache(i, String.valueOf(i));
        }

        assertEquals(3, cache.getSize());

    }


    @Test
    public void evictionTest() {
        for ( int i =0; i < 3; i++ ){
            cache.putCache(i, String.valueOf(i));
        }

        //Get 0 and 2. So 1 will be evicted on pressure.
        assertEquals("0", cache.getFromCache(0));
        assertEquals("2", cache.getFromCache(2));

        //Try to insert more thena 3.
        cache.putCache(4, String.valueOf(4));


        assertEquals("0", cache.getFromCache(0));
        assertEquals("2", cache.getFromCache(2));
        assertEquals("4", cache.getFromCache(4));
        assertNull(cache.getFromCache(1));

    }
}