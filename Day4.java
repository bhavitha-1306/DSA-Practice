// done with 2 medium questions weekly contest of LeetCode and daily problem(easy)

// **3818. Minimum Prefix Removal to Make Array Strictly Increasing
// Solved
// Medium
// premium lock icon
// Companies
// Hint
// You are given an integer array nums.

// You need to remove exactly one prefix (possibly empty) from nums.

// Return an integer denoting the minimum length of the removed prefix such that the remaining array is strictly increasing.

class Solution {
    public int minimumPrefix(int[] nums) {
        int n=nums.length;
        int i=n-1;
        while(i>0 && nums[i-1]<nums[i]){
            i--;
        }
        return i;
    }
}
//3819. Rotate Non Negative Elements
// You are given an integer array nums and an integer k.

// Rotate only the non-negative elements of the array to the left by k positions, in a cyclic manner.

// All negative elements must stay in their original positions and must not move.

// After rotation, place the non-negative elements back into the array in the new order, filling only the positions that originally contained non-negative values and skipping all negative positions.

// Return the resulting array.

 

// Example 1:

// Input: nums = [1,-2,3,-4], k = 3

// Output: [3,-2,1,-4]

// Explanation:​​​​​​​

// The non-negative elements, in order, are [1, 3].
// Left rotation with k = 3 results in:
// [1, 3] -> [3, 1] -> [1, 3] -> [3, 1]
// Placing them back into the non-negative indices results in [3, -2, 1, -4].
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                ls.add(nums[i]);
            }
        }
        int arr[]= new int[ls.size()];
        if(ls.size()==0) return nums;
        for(int i=0;i<ls.size();i++){
            arr[i]=ls.get(i);
        }
        
        rotate(arr,k);
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=arr[m++];
            }
        }
       return nums; 
    }
    static void rotate(int[] arr,int k){
        int n = arr.length;
        k=k%n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
    static void reverse(int[] arr,int l,int r){
        while(l<r){
            int temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
} 
//created a list of positive numbers and rotate then put them back in original array

// i have done a daily problem 
// 1877. Minimize Maximum Pair Sum in Array 
// The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
// For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                ls.add(nums[i]);
            }
        }
        int arr[]= new int[ls.size()];
        if(ls.size()==0) return nums;
        for(int i=0;i<ls.size();i++){
            arr[i]=ls.get(i);
        }
        
        rotate(arr,k);
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=arr[m++];
            }
        }
       return nums; 
    }
    static void rotate(int[] arr,int k){
        int n = arr.length;
        k=k%n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
    static void reverse(int[] arr,int l,int r){
        while(l<r){
            int temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}

//and also watched the xor of numbers in a range video of take u forward