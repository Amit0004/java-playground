package com.sde;


import java.util.Arrays;

/**
 * Link: https://www.codingninjas.com/studio/problems/job-sequencing-problem_1169460
 * Link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
 * Level: Medium
 * Concept Used : Greedy algorithms
 */
public class JobSequencing {
    public int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        int maxDeadline = 0;
        for(int[] job: jobs) {
            if(job[1] > maxDeadline) {
                maxDeadline = job[1];
            }
        }

        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1);
        int countJobs = 0, profit = 0;

        for(int[] job: jobs) {
            for(int j = job[1]; j > 0; j--) {
                if(result[j] == -1) {
                    countJobs++;
                    profit += job[2];
                    result[j] = job[0];
                    break;
                }
            }
        }

        return new int[]{countJobs, profit};
    }
    public static void main(String[] args) {
        JobSequencing js = new JobSequencing();
//        int[][] jobs = {
//                {1, 2, 30},
//                {2, 2, 40},
//                {3, 1, 10},
//                {4, 1, 10}
//        };

        int[][] jobs = {
                {1, 1, 40},
                {2, 1, 50},
                {3, 1, 60},
        };

        int[] output = js.jobScheduling(jobs);
        System.out.println("Jobs sequencing output >> " + Arrays.toString(output));
    }
}
