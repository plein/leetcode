package org.plein.graphs;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {

    /**
     * https://leetcode.com/problems/course-schedule/
     * 
     * This solution use Khan alforigth, we count the number of dependencies for each course then iterate over the ones not block, 
     * checking what courses they unblock. We do so until nothing is unblock or everything has been unblocked.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseUnblockMap = new HashMap<>(); // Identify what courses V are unblock by couse K
        int[] dependenciesCount = new int[numCourses]; // Count the number of courses blocking course[i]
        
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][1];
            int second = prerequisites[i][0];
            dependenciesCount[second]++;
            courseUnblockMap.computeIfAbsent(first, k -> new HashSet<>()).add(second);
        }

        // List<Integer> solution = new ArrayList<>(); In case we want to return the list of courses and not only true or false
        int coursesDone = 0;
        Stack<Integer> queue = new Stack<Integer>();

        // Find all courses unblocked and add to the queue
        for (int i = 0; i < numCourses; i++) {
            if (dependenciesCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.pop();
            // solution.add(course);
            coursesDone++;
            Set<Integer> dependents = courseUnblockMap.get(course); // Go for all courses unblocked by current one
            if (dependents != null) {
                for (Integer free : dependents) {
                    dependenciesCount[free]--;
                    if (dependenciesCount[free] == 0) {
                        queue.add(free);
                    }
                }
            }

        }
        return coursesDone == numCourses;
    }

}