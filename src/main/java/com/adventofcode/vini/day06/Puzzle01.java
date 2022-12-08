package com.adventofcode.vini.day06;

import java.util.List;

import com.adventofcode.vini.util.FileReader;

public class Puzzle01 {
    public static void main(String[] args) {
        List<String> lst = FileReader.allLines("day06_input.txt");
        String dataStream = lst.get(0);
        CommunicationDevice device = new CommunicationDevice(dataStream);
        System.out.println(device.getStartOfPacketMarker());
        System.out.println(device.getStartOfMessageMarker());
    }
}
