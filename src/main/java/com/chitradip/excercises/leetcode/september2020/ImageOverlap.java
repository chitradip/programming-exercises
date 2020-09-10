package com.chitradip.excercises.leetcode.september2020;

import java.util.*;

public class ImageOverlap {
    public static void main(String[] args) {

    }

    public int largestOverlap(int[][] A, int[][] B) {
        Set<Point> aList = toPoints(A);
        Set<Point> bList = toPoints(B);

//        int maxOverlap = Math.min(aList.size(), bList.size());
        int currMax = 0;
        for ( int shiftI = -A.length ; shiftI < A.length; shiftI++) {
            for (int shiftJ = -A.length ; shiftJ <A.length; shiftJ++)  {
                Set<Point> aShiftList = toPoints(A, shiftI, shiftJ);
                int maxOverlap = Math.min(aShiftList.size(), bList.size());
                if ( maxOverlap > currMax ) {
                    int overlap = overLap(aShiftList, bList);
                    if ( overlap > currMax) {
                        currMax = overlap;
                    }
                }
            }
        }

        return currMax;

    }

    public Set<Point> toPoints(int[][] A) {
        Set<Point> aList = new HashSet<>();
        for ( int i = 0; i < A.length; i++ ) {
            for (int j = 0; j< A[i].length; j++ ) {
                if (A[i][j] == 1) {
                    aList.add(new Point(i,j));
                }
            }
        }

        return aList;
    }
    public Set<Point> toPoints(int[][] A, int shiftI, int shiftJ) {
        Set<Point> aList = new HashSet<>();
        for ( int i = 0; i < A.length ; i++ ) {
            for (int j = 0; j< A[i].length; j++ ) {
                if ( i + shiftI >= 0
                        && i + shiftI < A.length && (j + shiftJ) >= 0
                        && j + shiftI < A.length &&
                        A[i][j] == 1){
                        aList.add(new Point(i + shiftI, j + shiftJ));
                }
            }
        }

        return aList;
    }

    public int overLap(Set<Point> a, Set<Point> b) {
        int num =0;
        for (Point p : a) {
            if ( b.contains(p)) {
                num++;
            }
        }
        return num;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public  Point shift(int i, int j) {
            return new Point(x +i , y +j);
        }
    }
}
