/*
Create a data structure that buffers packets
It receives a stream of packets, one at a time
The packets may be out of order or duplicated
Produce a stream of packets, one at a time
The output should be in order, with no duplicates or gaps

0, 1, 1, 4
getNextPacket() -> 0
getNextPacket() -> 1
getNextPacket() -> null
getNextPacket() -> null
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());
    NumBuffer numBuffer = new NumBuffer();
    numBuffer.addNumber(0);
    numBuffer.addNumber(1);
    numBuffer.addNumber(1);
    numBuffer.addNumber(4);
    numBuffer.addNumber(2);
    numBuffer.addNumber(3);

    for (int i = 0; i < 7; i++) {
      System.out.print(numBuffer.getNextPacket());
    }
  }
}


// 0,1,1,4,2,3
// mNumBuffer.add(0);
class NumBuffer {
  private int max;
  private Map<Integer, Boolean> nums;
  private PriorityQueue<Integer> minHeap;
  
  public NumBuffer() {
    max = Integer.MIN_VALUE;
    nums = new HashMap<>();
    minHeap = new PriorityQueue<>();
  }
  
  public void addNumber(int num) {
    if (nums.containsKey(num) && nums.get(num) == true) {
      return;
    } else {
      if (minHeap.size() == 0 || num - max == 1) {
        nums.put(num, true);
        minHeap.offer(num);
        max = Math.max(max, num);
        for (Map.Entry<Integer, Boolean> entry : nums.entrySet()) {
          if (!entry.getValue()) {addNumber(entry.getKey());}
        }
      } else {
        nums.put(num, false);
      }
    }
  }
        
  public Integer getNextPacket() {
    if (minHeap == null || minHeap.size() == 0) {
      return null;
    }
    return minHeap.poll();
  }
}