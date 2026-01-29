//29-01-2026
// a day with productive cooding practice
//lc-31
//Next permutation
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //find the index of the element is less than its next
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
               idx=i;
               break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                swap(nums,i,idx);
                break;
            }
        }
        reverse(nums,idx+1,n-1);
    }
    public void reverse(int[] nums,int i,int j){
        int n = nums.length;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

// the i have done with solving the Maximum product subarray
// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// Note that the product of an array with a single element is the value of that element.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6

//without dp
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
       int pre=1;
       int ans=Integer.MIN_VALUE;
       int suf=1;
        for(int i=0;i<n;i++){
         if(pre==0){
           pre=1;
         }
         if(suf==0){
            suf=1;
         }
         pre*=nums[i];
         suf*=nums[n-i-1];
     ans=Math.max(ans,Math.max(pre,suf));
        }

     return ans;

    }
}


//had revision with longest consecutive seuqnece
class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length==0) return 0;
       Set<Integer> st = new HashSet<>();
       for(int i=0;i<nums.length;i++){
       st.add(nums[i]);
       }
       int ans=0;
       for(int i:st){
        if(!st.contains(i-1)){
            int current=i;
            int count=1;
        while(st.contains(current+1)){
            current++;
            count++;
        }
        ans=Math.max(ans,count);
       }
       }
       return ans;
    }
}  