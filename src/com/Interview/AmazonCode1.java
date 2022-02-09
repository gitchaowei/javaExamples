package com.Interview;
//
//There are two integer arrays A and B, of size N given. There are N gas stations along a circular route,
// where the amount of gas at station i is A[i]. You have a car with an unlimited gas tank, and
// it costs B[i] of gas to travel from station i to its next station (i+1). You begin the journey
// with an empty tank at one of the gas stations.
// Return the minimum starting gas station's index if you can travel around the circuit once,
// otherwise return -1.
//
public class AmazonCode1 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5,6,7};
        int[] cost= {3,4,5,6,7,1,2};

        int start = canCompleteCircuit(gas, cost);
        if (start < 0 ) {
            System.out.println("No start station is found for going through all stations");
        }
        else {
            System.out.println("start station is : " + start);
        }
        return;
    }


    static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }
        if (gas.length == 1) {
            return gas[0] - cost[0] < 0 ? -1 : 0;
        }

        int curr = 0;   // initial gas is 0
        int start = -1; // before arriving at start gas station
        int end = -1;   // before arriving at start gas station

        // loop i for the start station with curr > 0
        for (int i=0; i < gas.length; i++){
            curr = gas[i] - cost[i];
            if (curr > 0) {
                // once start station curr > 0, loop j for all stations with curr >= 0
                // till end station, then return start station index
                start = i;
                end = (start + gas.length - 1) % gas.length;
                int ii=-1;
                for (int j= 1; j< gas.length; j++ ) {
                    ii = (start +j) % gas.length;
                    //if (ii == end) return start;
                    curr = curr + (gas[ii]-cost[ii]);
                    if (curr < 0 && ii !=end) {
                        // break to i loop for next start station with curr > 0
                        break;
                    }
                    if (ii== end)
                        return start;  // completed all station with curr >=0
                }
            }
        }
        return -1; // looped all i and find that no start station can go through all stations
    }
}