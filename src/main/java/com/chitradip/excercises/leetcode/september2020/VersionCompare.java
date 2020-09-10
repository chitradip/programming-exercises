package com.chitradip.excercises.leetcode.september2020;

import java.nio.ByteBuffer;
import java.security.KeyPairGenerator;
import java.util.Arrays;
import java.util.UUID;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 */
public class VersionCompare {
    public static void main(String[] args) {
        var compare = new VersionCompare();
        System.out.println(compare.compareVersion("0.1", "1.1"));
        System.out.println(compare.compareVersion("1.0.1", "1"));
        System.out.println(compare.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compare.compareVersion("1.01", "1.001"));

    }
    public int compareVersion(String version1, String version2) {
//        return compare(splitVersion(version1), splitVersion(version2));
        return compare2(version1, version2);
    }
    public int compare2(String version1, String version2) {
        int ver1Idx = 0;
        int ver2Idx = 0;

        while(ver1Idx < version1.length() || ver2Idx < version2.length() ) {
            int currVersion1 = 0;
            int currVersion2 = 0;
            while(ver1Idx < version1.length() && version1.charAt(ver1Idx) != '.') {
                currVersion1 *=10;
                currVersion1 += version1.charAt(ver1Idx) - '0';
                ver1Idx++;
            }
            while(ver2Idx < version2.length() && version2.charAt(ver2Idx) != '.') {
                currVersion2 *=10;
                currVersion2 += version2.charAt(ver2Idx) - '0';
                ver2Idx++;
            }
            if ( currVersion1 < currVersion2) {
                return -1;
            } else if ( currVersion1 > currVersion2) {
                return 1;
            }
            //else continue;
            ver1Idx++;
            ver2Idx++;
        }
        return 0;
    }
    public int[] splitVersion(String version) {
        String[] arr = version.split("[.]");
        return Arrays.stream(arr)
                .mapToInt(Integer::valueOf)
                .toArray();
    }
    public int compare(int[] version1, int[] version2) {
        int maxLen = Math.max(version1.length, version2.length);
        for ( int i = 0; i < maxLen; i++ ) {
            int one = i < version1.length ? version1[i] : 0;
            int two = i < version2.length ? version2[i] : 0;
            if ( one < two) {
                return -1;
            } else if ( one > two) {
                return 1;
            } else {
                //equal continue
            }
        }
        return 0;
    }

}
