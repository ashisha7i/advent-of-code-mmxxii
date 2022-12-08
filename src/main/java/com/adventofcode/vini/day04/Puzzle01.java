package com.adventofcode.vini.day04;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventofcode.vini.util.FileReader;

public class Puzzle01 {
    public static void main(String[] args) {
        List<String> allLines = FileReader.allLines("day04/input.txt");
        System.out.println(allLines);

        int count = 0;

        for(String line: allLines) {
            String firstPair = line.split(",")[0];
            String secondPair = line.split(",")[1];


            int rangeOneStart = Integer.parseInt(firstPair.split("-")[0]);
            int rangeOneEnd   = Integer.parseInt(firstPair.split("-")[1]);
            int rangeTwoStart = Integer.parseInt(secondPair.split("-")[0]);
            int rangeTwoEnd   = Integer.parseInt(secondPair.split("-")[1]);


            int rangeOneElementCount = rangeOneEnd - rangeOneStart;
            int rangeTwoElementCount = rangeTwoEnd - rangeTwoStart;

            List<Integer> outerList = new ArrayList<>();
            List<Integer> innerList = new ArrayList<>();


            if(rangeOneElementCount > rangeTwoElementCount) {
                for(int i=rangeOneStart; i<= rangeOneEnd; i++) {
                    outerList.add(i);
                }
                for(int i=rangeTwoStart; i<= rangeTwoEnd; i++) {
                    innerList.add(i);
                }
            } else {
                for(int i=rangeTwoStart; i<= rangeTwoEnd; i++) {
                    outerList.add(i);
                }
                for(int i=rangeOneStart; i<= rangeOneEnd; i++) {
                    innerList.add(i);
                }
            }

            if(doesOverlap(outerList, innerList)) {
                count++;
            }

            System.out.printf("%-12s   %-12s    %s", firstPair, secondPair, doesOverlap(outerList, innerList));
            System.out.println("");
            
        }

        System.out.println(count);
    }

    private static boolean doesOverlap(List<Integer> outerList, List<Integer> innerList) {
        return outerList.containsAll(innerList);
    }
}
