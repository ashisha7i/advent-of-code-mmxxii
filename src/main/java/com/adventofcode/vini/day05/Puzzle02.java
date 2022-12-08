package com.adventofcode.vini.day05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.adventofcode.vini.util.FileReader;

public class Puzzle02 {

    private static Stack<Character> stack1 = new Stack<>();
    private static Stack<Character> stack2 = new Stack<>();
    private static Stack<Character> stack3 = new Stack<>();
    private static Stack<Character> stack4 = new Stack<>();
    private static Stack<Character> stack5 = new Stack<>();
    private static Stack<Character> stack6 = new Stack<>();
    private static Stack<Character> stack7 = new Stack<>();
    private static Stack<Character> stack8 = new Stack<>();
    private static Stack<Character> stack9 = new Stack<>();

    private static Map<Integer, Stack<Character>> stackMap = new HashMap<>();


    static {
        initStack(stack1, "NSDCVQT");
        initStack(stack2, "MFV");
        initStack(stack3, "FQWDPNHM");
        initStack(stack4, "DQRTF");
        initStack(stack5, "RFMNQHVB");
        initStack(stack6, "CFGNPWQ");
        initStack(stack7, "WFRLCT");
        initStack(stack8, "TZNS");
        initStack(stack9, "MSDJRQHN");

        stackMap.put(1, stack1);
        stackMap.put(2, stack2);
        stackMap.put(3, stack3);
        stackMap.put(4, stack4);
        stackMap.put(5, stack5);
        stackMap.put(6, stack6);
        stackMap.put(7, stack7);
        stackMap.put(8, stack8);
        stackMap.put(9, stack9);
    }

    public static void main(String[] args) {
        List<String> allLines = FileReader.allLinesFrom("day05/input.txt", 11);

        for(String command: allLines) {
            Instruction instruction = getInstructionFromCommand(command);
            processInstruction(instruction);
        }

        System.out.println(getCratesFromTopLayer());

        
    }

    private static void initStack(Stack<Character> stack, String crates) {
        char[] cratesArr = crates.toCharArray();
        for(Character c: cratesArr) {
            stack.push(c);
        }
    }

    private static String getCratesFromTopLayer() {
        char[] arr = new char[9];
        
        for(int i=0; i<9; i++) {
            arr[i] = stackMap.get(i+1).pop(); // Stack map is '1' based index
        }

        return new String(arr);
    }

    private static void processInstruction(Instruction instruction) {
        Stack<Character> stackFrom = stackMap.get(instruction.getStackFrom());
        Stack<Character> stackTo   = stackMap.get(instruction.getStackTo());
        
        Stack<Character> tempStack = new Stack<>();

        for(int i=0; i<instruction.getStackCount(); i++) {
            Character temp = stackFrom.pop();
            tempStack.push(temp);
        }

        while(!tempStack.empty()) {
            stackTo.push(tempStack.pop());
        }

    }

    private static Instruction getInstructionFromCommand(String commandLine) {
        // Template "move 1 from 8 to 7"
        String[] parts = commandLine.split(" ");
        Integer count = Integer.parseInt(parts[1]);
        Integer fromStack = Integer.parseInt(parts[3]);
        Integer toStack = Integer.parseInt(parts[5]);

        return new Instruction(count, fromStack, toStack);
    }


}

