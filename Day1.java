// Today I have done the 3 major questions of BitManipulation in LeetCode 

// Single number
//  1.find the single number in the array where another numbers are repeated twice
 
//  brute: we can do this with using hashmap 
//  but the major thing is: You must implement a solution with a linear runtime complexity and use only constant extra space.

// then the Bitmanipulationn comes into picture 
//  ** xor of same numbers of even repeated times will become the 0 then the only soln will remain is the single elemnet 
 
 //code
 class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
       for(int i=0;i<nums.length;i++){
          xor=xor^nums[i];
       } 
       return xor;
    }
 }


 ----------------------------------------------------------------------------------------------------------------------
//  Single Number 11
//  2. Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

// You must implement a solution with a linear runtime complexity and use only constant extra space.
 
//   brute: using hashmap but it doesnot statisfy the space complexity 

// then we start calculting the set bits in each coulm if it multiple of 3 we will add 0 else 1

// brute:
class Solution {
    public int singleNumber(int[] nums) {
        //normal array method
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],1+hm.getOrDefault(nums[i],0));
        }
        int ans=0;
        for(int i: hm.keySet()){
            if(hm.get(i)<3){
                ans=i;
            }
        }
        return ans;
    }
}
// TC:O(n) + O(n) = O(n)
// SC:O(n);
 
// better: using bitmanipulation
class Solution {
    public int singleNumber(int[] nums) {
        // using bitmanipulation 
        int res=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int num:nums){
                if((num&(1<<i))!=0){
                    count++;
                }
            }
            if(count%3!=0){
                res|=(1<<i);
                
            }
        }
        return res;
    }
}
// Time Complexity: O(32 × n) → O(n)
// Space Complexity: O(1)

----------------------------------------------------------------------------------------------------------------------
// 3.Single number 111
// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

// Example 1:

// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.

// again the brute will be hashmap 
 
// the best approach is:

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        int diff=xor&-xor;
        int b1=0;
        int b2=0;
        for(int i:nums){
            if((i&diff)!=0){
                b1^=i;
            }else{
                b2^=i;
            }
        }
        return new int[]{b1,b2};
    }
}
// TC:O(2n)
// sc:O(1)


