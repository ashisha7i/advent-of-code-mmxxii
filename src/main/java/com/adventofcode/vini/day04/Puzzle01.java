package com.adventofcode.vini.day04;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventofcode.vini.util.FileReader;

public class Puzzle01 {
    public static void main(String[] args) {
        List<String> allLines = FileReader.allLines("day04/input.txt");
        System.out.println(allLines);

        int fullOverlapCount = 0;
        int partialOverlapCount = 0;

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

            if(isFullOverlap(outerList, innerList)) {
                fullOverlapCount++;
            }

            if(isOverlap(outerList, innerList)) {
                partialOverlapCount++;
            }

            System.out.printf("%-12s   %-12s    %-6s    %s", firstPair, secondPair, isFullOverlap(outerList, innerList), isOverlap(outerList, innerList));
            System.out.println("");
            
        }

        System.out.println(fullOverlapCount);
        System.out.println(partialOverlapCount);
    }

    private static boolean isFullOverlap(List<Integer> outerList, List<Integer> innerList) {
        return outerList.containsAll(innerList);
    }

    private static boolean isOverlap(List<Integer> outerList, List<Integer> innerList) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i: outerList) {
            map.put(i, i);
        }

        for(Integer j: innerList) {
            if(map.get(j) != null) {
                return true;
            }
        }

        return false;
    }
}
