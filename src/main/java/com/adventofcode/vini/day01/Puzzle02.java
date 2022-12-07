package com.adventofcode.vini.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.adventofcode.vini.util.FileReader;

/**
 * Day 01 - Puzzle 02
 *
 */
public class Puzzle02 
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

        // Getting the TOP 3 MAX calories collected
        List<Entry<Integer, Integer>> topThreeEntries = elvesFoodMap.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .limit(3)
                    .collect(Collectors.toList());

        Integer sumOfTopThree = topThreeEntries.stream()
            .mapToInt(e -> e.getValue())
            .reduce(0, (a, b) -> a + b);
        
        System.out.println(topThreeEntries);
        System.out.println("Total : " + sumOfTopThree);
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
