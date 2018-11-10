package com.practiceproblems.amazon;

import java.util.*;

/*
    题目是说有一个List<List<Integer>>表示一堆餐厅的location，就是横纵坐标，然后customer是在原点(0,0)上。
    要求求出离customer最近的n个餐厅的位置。n是input里面给的。餐厅的总数也会在input里面给。
 */

public class OA_7_24_2018 {
    public List<List<Integer>> nearestXSteakHouses(int totalSteakhouses,
                                                   List<List<Integer>> allLocations,
                                                   int numSteakhouses) {
        if(numSteakhouses > totalSteakhouses) return null;

        new PQ(new Comparator<>(){ 
        })
        PriorityQueue<List<Integer>> maxPQ = new PriorityQueue<>((o1, o2) -> {
            int x1 = o1.get(0);
            int y1 = o1.get(1);
            int x2 = o2.get(0);
            int y2 = o2.get(1);

            int distance1 = x1 * x1 + y1 * y1;
            int distance2 = x2 * x2 + y2 * y2;

            return distance2 - distance1;
        });

        for(List<Integer> location : allLocations) {
            maxPQ.offer(location);
            if(maxPQ.size() > numSteakhouses) {
                maxPQ.poll();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while(maxPQ.size() != 0) {
            result.add(maxPQ.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        OA_7_24_2018 steakHouse = new OA_7_24_2018();

        List<List<Integer>> allLocations = new ArrayList<>();
        allLocations.add(Arrays.asList(1,2));
        allLocations.add(Arrays.asList(3,4));
        allLocations.add(Arrays.asList(5,6));
        allLocations.add(Arrays.asList(-4,-2));
        allLocations.add(Arrays.asList(1,-3));
        allLocations.add(Arrays.asList(-1,-2));


        List<List<Integer>> list = steakHouse.nearestXSteakHouses(5, allLocations, 3);
        for(List<Integer> l : list) {
            System.out.println("[" + l.get(0) + "," + l.get(1) + "]");
        }

    }
}
