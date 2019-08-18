package com.chitradip.excercises.arraySerialization;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySerializationTest {

    private ArraySerialization arraySerialization = new ArraySerialization();

    @Test
    public void basicTest() {
        List<String> arr = Arrays.asList("abcd", "dsdfsd", "ffse");
        assertEquals(arraySerialization.deSerialize(arraySerialization.serialize(arr)), arr);

    }

    @Test
    public void delimiterAndEscapeTest() {
        List<String> arr = Arrays.asList("ab,cd", ",dsdfsd,", "ff\\s,\\e");
        assertEquals(arr, arraySerialization.deSerialize(arraySerialization.serialize(arr)));

    }

    @Test
    public void multipleDelimiterTest() {
        List<String> arr = Arrays.asList(",,,,,,,,,", "\\\\\\\\\\", "\\,,,\\\\,,,,,,,\\");
        assertEquals(arr, arraySerialization.deSerialize(arraySerialization.serialize(arr)));

    }
}
