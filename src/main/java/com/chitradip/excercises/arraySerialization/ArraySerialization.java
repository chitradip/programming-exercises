package com.chitradip.excercises.arraySerialization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySerialization {
    /*
        Given a list of strings, convert into one string such that you can convert it back to the list

        1. toString() should convert ["cat", "dogs", "giraffes" ] to "\<Some String\>"
        2. fromString() should convert "\<Some String\>" to ["cat", "dogs", "giraffes" ]
     */

    private final char delim;
    private final char escapeChar;

    public ArraySerialization() {
        this.delim = ',';
        escapeChar = '\\';
    }


    public String serialize(List<String> strings) {
        if ( strings == null ) {
            return null;
        } else {
            /* In case you have Java 8  - its simple
           return strings.stream().map( x -> escape(x))
                   .collect(Collectors.joining(","));
             */
            //In case you don't have Java 8 :)
            StringBuilder stringBuilder = new StringBuilder();

            if ( strings.size() > 0 ) {
                stringBuilder.append(escape(strings.get(0)));
            }

            for ( int idx = 1; idx < strings.size(); idx++) {
                stringBuilder.append(delim);
                stringBuilder.append(escape(strings.get(idx)));
            }
            return stringBuilder.toString();
        }

    }

    public List<String> deSerialize(String serialized) {
        if ( serialized == null ) {
            return null;
        } else {
           List<String> ret = new ArrayList<>();
           int currIdx = 0;
           while (currIdx < serialized.length()) {
               int endIdx = findFirstDelim(currIdx, serialized);
               ret.add(unescape(serialized.substring(currIdx, endIdx)));
               currIdx = endIdx + 1; // Set to the char after delimiter. for next word
           }
            return ret;

        }


    }

    private String unescape(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean escaped = false;
        for ( char ch : input.toCharArray()) {
            // Escape the escape char or the seperator.
            if (  !escaped && ch == escapeChar) {
                //Set the escaped flag to true if its not already escaped and the curr char is escape.
                //
                escaped = true;
            } else {
                stringBuilder.append(ch);
                //reset the escaped - could be conditional but why?
                escaped = false;
            }
        }
        return stringBuilder.toString();
    }

    private int findFirstDelim(int start, String serialized) {
        boolean escaped = false;
        for ( int idx = start; idx<serialized.length(); idx++) {
            if ( !escaped && serialized.charAt(idx) == escapeChar) {
                escaped = true;
                continue;
            } else if (!escaped && serialized.charAt(idx) == delim) {
                return idx;
            } else {
                // Could be conditional but again why?
                escaped = false;
            }
        }
        //If it reaches here it has ended.
        return serialized.length();
    }

    private String escape(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        for ( char ch : input.toCharArray()) {
            // Escape the escape char or the seperator.
            if ( ch == delim || ch == escapeChar) {
                stringBuilder.append(escapeChar);
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
