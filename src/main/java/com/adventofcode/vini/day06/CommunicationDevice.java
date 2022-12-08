package com.adventofcode.vini.day06;

import java.util.LinkedHashSet;
import java.util.Set;

public class CommunicationDevice {
    String dataStream;

    public CommunicationDevice(String dataStream) {
        this.dataStream = dataStream;
    }

    public String getDataStream() {
        return this.dataStream;
    }

    public int getStartOfPacketMarker() {
        char[] dataArr = this.dataStream.toCharArray();

        if(this.dataStream == null || this.dataStream.isEmpty() || this.dataStream.length() < 3) {
            return -1;
        }

        int uniqueCharCount = 0;
        for(int i=0; i<dataArr.length - 4; i++) {
            Set<Character> set = new LinkedHashSet<>();
            uniqueCharCount = 0;
            
            for(int j=i; j<i+4; j++) {
                if(!set.add(dataArr[j])) {
                    break;
                } else {
                    uniqueCharCount++;
                    if(uniqueCharCount == 4) {
                        System.out.println(set);
                        return j + 1; // Return 'position' not 'index'
                    }
                }
            }
        }

        return -1;
    }

    public int getStartOfMessageMarker() {
        char[] dataArr = this.dataStream.toCharArray();

        if(this.dataStream == null || this.dataStream.isEmpty() || this.dataStream.length() < 3) {
            return -1;
        }

        int uniqueCharCount = 0;
        for(int i=0; i<dataArr.length - 4; i++) {
            Set<Character> set = new LinkedHashSet<>();
            uniqueCharCount = 0;
            
            for(int j=i; j<i+14; j++) {
                if(!set.add(dataArr[j])) {
                    break;
                } else {
                    uniqueCharCount++;
                    if(uniqueCharCount == 14) {
                        System.out.println(set);
                        return j + 1; // Return 'position' not 'index'
                    }
                }
            }
        }

        return -1;
    }
}
