/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15]]
 * 
 * k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 */

package main.java.lcidiot.lc0378;

class SolutionApproachBinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0)
            return -1;
        int n = matrix[0].length;
        if (n == 0)
            return -1;
        if (k > m * n)
            return -1;

        int low = matrix[0][0], high = matrix[m - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, j = n - 1;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += j + 1;
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}