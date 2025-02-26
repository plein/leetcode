package org.plein.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        
        Map<Integer, List<Integer>> disPoints = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            // double distance = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);

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
