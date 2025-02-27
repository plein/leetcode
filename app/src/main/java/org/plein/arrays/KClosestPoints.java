package org.plein.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class KClosestPoints {
    
    private Object[] array;

    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/description/
     * 
     * Depending on K we can use one approach or another.
     * When k is bigger than n/2, use a simple Arrays sort with comparator.
     * When k is smaller, use a PriorityQueue, important to keep removing elements from the 
     * queue when there are already k, to make inserts faster.
     */
    public int[][] kClosest(int[][] points, int k) {

        if (k > points.length / 2) { // O(nlogn)
            Arrays.sort(points, (v1, v2) -> 
                (v1[0] * v1[0] + v1[1] * v1[1]) - (v2[0] * v2[0] + v2[1] * v2[1]));
            return Arrays.copyOfRange(points, 0, k);
        } else { // O(nlogK)
            Queue<int[]> queue = new PriorityQueue<>((v1, v2) -> 
                (v2[0] * v2[0] + v2[1] * v2[1]) - (v1[0] * v1[0] + v1[1] * v1[1])
            );
    
            // Add elements, maintaining only k elements in max heap
            for (int[] point : points) {
                queue.add(point);
                if (queue.size() > k) {
                    queue.poll(); // Remove the farthest point
                }
            }
    
            // Convert the heap to a 2D array
            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll();
            }
            return result;
        }
    }

    public int[][] kClosestStream(int[][] points, int k) {
        
        Map<Integer, List<int[]>> disPoints = new TreeMap<>();

        for (int i = 0; i < points.length; i++) {
            disPoints.computeIfAbsent(points[i][0]*points[i][0] + points[i][1]*points[i][1], v -> new ArrayList<>()).add(points[i]);
        }

        List<int[]> list = disPoints.values().stream().flatMap(v -> v.stream()).limit(k).toList();

        return list.toArray(new int[k][]);
    }

    public int[][] kClosestFirst(int[][] points, int k) {
        
        Map<Integer, List<Integer>> disPoints = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            disPoints.computeIfAbsent(points[i][0]*points[i][0] + points[i][1]*points[i][1], v -> new ArrayList<>()).add(i);
        }

        List<Integer> distances = new ArrayList<>(disPoints.keySet());
        Collections.sort(distances);

        int[][] solution = new int[k][2];
        int disPos = 0;
        int counter = 0;
        while (counter < k) {
            Integer currentDistance = distances.get(disPos);
            for (Integer position : disPoints.get(currentDistance)) {
                if (counter < k) {
                    solution[counter] = points[position];
                    counter++;
                } else {
                    break;
                }
            }
            disPos++;
        }
        return solution;
    }
}
