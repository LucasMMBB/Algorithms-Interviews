/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    // test case
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) { return res; }
        Comparator comparator = new IntervalComparator();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(), comparator);
        
        // add intervals to minimum heap
        for (Interval interval : intervals) {
            minHeap.add(interval);
        }
        
        // after sorting, merge intervals
        int preStart = 0, preEnd = 0;
        if (!minHeap.isEmpty()) {
            Interval interval = minHeap.poll();
            preStart = interval.start;
            preEnd = interval.end;
        }
        while (!minHeap.isEmpty()) {
            Interval interval = minHeap.poll();
            if (interval.start <= preEnd) {
                preEnd = interval.end > preEnd ? interval.end : preEnd;
            } else {
                res.add(new Interval(preStart, preEnd));
                preStart = interval.start;
                preEnd = interval.end;
            }
        }
        res.add(new Interval(preStart, preEnd));
        
        return res;
    }
}

public class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}