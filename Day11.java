// 1-02-2026
// //done with weekly contest with 1 problem and 1 daily qun
// 3010. Divide an Array Into Subarrays With Minimum Cost I
// You are given an array of integers nums of length n.
// The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
// You need to divide nums into 3 disjoint contiguous subarrays.
// Return the minimum possible sum of the cost of these subarrays.

 class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
       int min=Integer.MAX_VALUE;
       for(int i=1;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            min=Math.min(min,nums[0]+nums[i]+nums[j]);
        }
       }
       return  min;
    }
}

// 3827. Count Monobit Integers
// You are given an integer n.
// An integer is called Monobit if all bits in its binary representation are the same.
// Return the count of Monobit integers in the range [0, n] (inclusive).

 class Solution {
    public int countMonobit(int n) {
      int count=1;
      int val=1;
    while(val<=n){
        count++;
        val=(val<<1)|1;
    }
        return count;
    }
}