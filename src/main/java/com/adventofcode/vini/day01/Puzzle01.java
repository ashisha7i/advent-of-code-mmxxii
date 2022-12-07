package com.adventofcode.vini.day01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.Map.Entry;

import com.adventofcode.vini.util.FileReader;

/**
 * Day 01 - Puzzle 01
 *
 */
public class Puzzle01 
{
    public static void main( String[] args )
    {
        List<String> allLines = FileReader.allLines("day01/input.txt");
        
        int elfNumber = 1;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> elvesFoodMap = new HashMap<>();
        
        // Reading the file and getting the calories collected by each Elf
        for(String line: allLines){
            if(!line.equals("")){
                stack.push(Integer.parseInt(line));
            } else {
                elvesFoodMap.put(elfNumber, getTotalCalriesForElf(stack));
                elfNumber++;
            }
        }

        // Handling the last group
        elvesFoodMap.put(elfNumber, getTotalCalriesForElf(stack));

        // Getting the MAX calories collected
        Optional<Entry<Integer, Integer>> maxEntry = elvesFoodMap.entrySet()
                    .stream()
                    .max((a, b) -> a.getValue().compareTo(b.getValue()));
        
        Entry<Integer, Integer> result = maxEntry.get();
        System.out.printf("Elf %d has the max calories collected %d%n", result.getKey(), result.getValue());
    }

    /**
     * Sums up the calories collected by each Elf
     * @param stack
     * @return
     */
    private static Integer getTotalCalriesForElf(Stack<Integer> stack) {
        Integer calories = 0;
        while(!stack.empty()){
            calories += stack.pop();
        }

        return calories;
    }


}
