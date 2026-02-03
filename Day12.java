// 02-02-2026
// started with binary search and done with 3 major problems 
34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[]= new int[2];
        int  n=nums.length;
        int lb = lowerbound(nums,target);
        if(lb==n || nums[lb]!=target){
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        int ub = upperbound(nums,target)-1;
            arr[0]=lb;
            arr[1]=ub;
        return arr;
    }
    public static int lowerbound(int[] arr,int k ){
        int n = arr.length;
        int low=0;
        int high= arr.length-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int upperbound(int[] arr,int k){
        int n = arr.length;
        int low=0;
        int high= arr.length-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}

// Search Single Element in a sorted array
// Problem Statement: Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.
// Examples
// Input : arr[] = {1,1,2,2,3,3,4,5,5,6,6}
// Output: 4
// Explanation: Only the number 4 appears once in the array.
public static int singleelement(int[] arr){
        int n = arr.length;
        if(arr[0]!=arr[1]){
            return arr[0];
        }
        if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((arr[mid]!=arr[mid-1]) && (arr[mid]!=arr[mid+1])){
                return arr[mid];
            }else if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
}
//peak element
// Peak element in Array
// Problem Statement:
//  Given an array of length N, peak element is defined as the element greater than both of its neighbors. Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i]. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
public static int peakelement(int[] arr){
        int n = arr.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
             if(arr[mid]>arr[mid+1]){
                high=mid;
            }else{
               low=mid+1;
            }
        }
        return arr[low];
    }