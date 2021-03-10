/**
 * https://leetcode.com/problems/campus-bikes/
 * 
 * Time Complexity:     O(N_WORKERS * N_BIKES)
 * Space Complexity:    O(N_WORKERS * N_BIKES)
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes/discuss/308738/C++-bucket-sort-O(M*N)-time-and-space-solution/301229
 *  https://leetcode.com/problems/campus-bikes/discuss/308738/C%2B%2B-bucket-sort-O(M*N)-time-and-space-solution
 */
package com.an7one.leetcode.lvl3.lc1057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0BucketSort {
    private int[][] workers, bikes;
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        this.workers = workers;
        this.bikes = bikes;
        
        final int CAPACITY = 2001, N_WORKERS = workers.length, N_BIKES = bikes.length;
        List<List<Assignment>> buckets = new ArrayList<List<Assignment>>(CAPACITY);
        for(int i = 0; i < CAPACITY; i++){
            buckets.add(new ArrayList<Assignment>());
        }
        
        for(int w = 0; w < N_WORKERS; w++){
            for(int b = 0; b < N_BIKES; b++){
                Assignment assignment = new Assignment(w, b);
                buckets.get(assignment.distance).add(assignment);
            }
        }
        
        boolean[] bikesAssigned = new boolean[N_BIKES];
        int[] ans = new int[N_WORKERS];
        Arrays.fill(ans, -1);
        for(int dist = 0; dist < CAPACITY; dist++){
            if(buckets.get(dist).isEmpty()) continue;
            
            List<Assignment> assignments = buckets.get(dist);
            for(int i = 0; i < assignments.size(); i++){
                int idxWorker = assignments.get(i).idxWorker;
                int idxBike = assignments.get(i).idxBike;
                
                if(bikesAssigned[idxBike] || ans[idxWorker] != -1) continue;
                ans[idxWorker] = idxBike;
                bikesAssigned[idxBike] = true;
            }
        }
        
        return ans;
    }
    
    private class Assignment{
        protected int idxWorker;
        protected int idxBike;
        protected int distance;
        
        protected Assignment(int idxWorker, int idxBike){
            this.idxWorker = idxWorker;
            this.idxBike = idxBike;
            
            this.distance = getDistance(workers[idxWorker], bikes[idxBike]);
        }
        
        private int getDistance(int[] pos1, int[] pos2){
            return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
        }
    }
}