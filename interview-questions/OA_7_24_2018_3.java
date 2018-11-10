package com.practiceproblems.amazon;

import java.util.*;

/*
    题目的意思是要去送货，假设是在一个二维的地图上，图上的点也是用List<List<Integer>>表示。每个坐标上的点有三种，0，1，2.
    0表示可以到达，1表示没有路可以去，2表示是要送的货的终点。每次都是从{0，0}这个点出发。最后要求求出最短的路径
 */

public class OA_7_24_2018_3 {
    public int findShortestDistance(List<List<Integer>> map) {
        if (map == null || map.size() == 0 || map.get(0).size() == 0) {
            return -1;
        }
        if (map.get(0).get(0) == 2) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int[] xDirection = {-1, 1, 0, 0};
        int[] yDirection = {0, 0, 1, -1};
        int distance = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            distance++;

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cell[0] + xDirection[i];
                    int y = cell[1] + yDirection[i];

                    if (x < 0 || x >= map.size() || y < 0 || y >= map.get(0).size()) {
                        continue;
                    }

                    int cellValue = map.get(x).get(y);
                    if (cellValue == 2) {
                        return distance;
                    } else if (cellValue == 0) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        OA_7_24_2018_3 shortestPath = new OA_7_24_2018_3();

        List<List<Integer>> secondInput = new ArrayList<>();
        secondInput.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0));
        secondInput.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0, 1));
        secondInput.add(Arrays.asList(0, 0, 1, 0, 1, 1, 0, 2));
        secondInput.add(Arrays.asList(1, 0, 1, 1, 1, 0, 1, 0));
        secondInput.add(Arrays.asList(1, 0, 1, 1, 1, 0, 0, 0));
        secondInput.add(Arrays.asList(0, 0, 1, 1, 0, 1, 1, 0));
        secondInput.add(Arrays.asList(0, 1, 0, 0, 0, 0, 1, 0));
        secondInput.add(Arrays.asList(0, 0, 0, 1, 1, 0, 0, 0));
        int result = shortestPath.findShortestDistance(secondInput);
        System.out.println("--------------");
        System.out.println(result);

    }

    public static void printListOfList(List<List<Integer>> res) {
        for (List<Integer> i : res) {
            for (int ii : i) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }
    }
}
