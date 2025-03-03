package org.plein.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class DiagonalSort {

    /**
     * https://leetcode.com/problems/sort-the-matrix-diagonally/description/
     * Have a method that given a row and col sort the array. Use min heap.
     * Call that method for each element of the first row and 
     * each element of the first column of the matrix.
     */
    public int[][] diagonalSort(int[][] mat) {
        for (int col = 0; col < mat[0].length; col++) {
            sort(0, col, mat);
        }
        for (int row = 1; row < mat.length; row++) {
            sort(row, 0, mat);
        }
        return mat;
    }

    void sort(int row, int col, int[][] mat) {
        Queue<Integer> queue = new PriorityQueue<>();
        int tmpCol = col;
        int tmpRow = row;
        while (col < mat[0].length && row < mat.length) {
            queue.add(mat[row][col]);
            row++;
            col++;
        }
        
        while (!queue.isEmpty()) {
            mat[tmpRow][tmpCol] = queue.poll();
            tmpRow++;
            tmpCol++;
        }
    }
}
