package com.practiceproblems.amazon;

import java.util.*;

public class OA_7_24_2018_2 {
    public List<List<Integer>> optimalUtilization(int maxTravelDist,
                                                  List<List<Integer>> forwardRouteList,
                                                  List<List<Integer>> returnRouteList) {

        class RouteComparator implements Comparator<List<Integer>> {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        }

        forwardRouteList.sort(new RouteComparator());
        returnRouteList.sort(new RouteComparator());

        int i = 0;
        int j = returnRouteList.size() - 1;
        long difference = Long.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        while(i < forwardRouteList.size() && j >= 0) {
            long sum = (long) forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
            if(sum > (long) maxTravelDist) {
                j--;
            } else {
                long localDiff = maxTravelDist - sum;
                if(localDiff <= difference) {
                    List<Integer> list = Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0));
                    if(localDiff < difference) {
                        difference = localDiff;
                        result = new ArrayList<>();
                    }
                    result.add(list);

                }

                int jTemp = j;
                j--;
                while(j >= 0 && returnRouteList.get(j).get(1).equals(returnRouteList.get(j + 1).get(1))) {
                    List<Integer> newList = Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0));
                    result.add(newList);
                    j--;
                }
                j = jTemp;


                i++;
            }

        }

        return result;
    }



    public static void main(String[] args) {
        OA_7_24_2018_2 optimalUtilization = new OA_7_24_2018_2();

        List<List<Integer>> forwardShippingRouteList = new ArrayList<>();
        forwardShippingRouteList.add(Arrays.asList(1, 8));
        forwardShippingRouteList.add(Arrays.asList(2, 15));
        forwardShippingRouteList.add(Arrays.asList(3, 9));
//        forwardShippingRouteList.add(Arrays.asList(4, 10000));
//        forwardShippingRouteList.add(Arrays.asList(4, 5500));
//        forwardShippingRouteList.add(Arrays.asList(5, 6000));
//        forwardShippingRouteList.add(Arrays.asList(6, 2500));

        List<List<Integer>> returnShippingRouteList = new ArrayList<>();
        returnShippingRouteList.add(Arrays.asList(1, 8));
        returnShippingRouteList.add(Arrays.asList(2, 11));
        returnShippingRouteList.add(Arrays.asList(3, 12));
//        returnShippingRouteList.add(Arrays.asList(4, 5000));
//        returnShippingRouteList.add(Arrays.asList(5, 3500));
//        returnShippingRouteList.add(Arrays.asList(6, 6500));
//        returnShippingRouteList.add(Arrays.asList(7, 4500));
//        returnShippingRouteList.add(Arrays.asList(8, 4500));

        List<List<Integer>> list = optimalUtilization.optimalUtilization(20, forwardShippingRouteList, returnShippingRouteList);
        for(List<Integer> l : list) {
            System.out.println("[" + l.get(0) + "," + l.get(1) + "]");
        }

    }
}
