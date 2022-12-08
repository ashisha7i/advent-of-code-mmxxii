package com.adventofcode.vini.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.adventofcode.vini.util.FileReader;

public class Puzzle01 {
    
    public static void main(String[] args) {
        List<String> allLines = FileReader.allLines("day03_input.txt");
        Integer prioritiesSum = 0;

        for(String line: allLines) {
            int length = line.length();
            String compartment1 = line.substring(0, length/2);
            String compartment2 = line.substring(length / 2);
            
            Set<Character> setA = convertToSet(compartment1);
            Set<Character> setB = convertToSet(compartment2);

            setA.retainAll(setB);

            System.out.println(setA);

            Integer sum = setA.stream().mapToInt(e -> getPriority(e.charValue())).reduce(0, (a,b) -> a+b);
            prioritiesSum += sum;
            System.out.println(sum);
        }
        System.out.println(prioritiesSum);
    }

    private static Set<Character> convertToSet(String str) {
        Set<Character> result = new HashSet<>();

        for(Character c: str.toCharArray()){
            result.add(c);
        }

        return result;
    }

    /**
     * Lower case letters 'a' through 'z' have priorities  1 through 26
     * Upper case letters 'A' through 'Z' have priorities 27 through 52
     * @param c
     * @return
     */
    private static int getPriority(char c) {
        if(c >= 'a' && c <= 'z') {
            return (c - 'a') + 1;
        } else if (c >= 'A' && c <= 'Z') {
            return (c - 'A') + 26 + 1;
        }
        
        return -1;
    }
}
