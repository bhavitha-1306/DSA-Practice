date:27-01-2026
//done with 3 sum and 4 sum problems in leetcode
//lc-15
//both brute better and optimal solutions by decreasing the time complexiyty
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1]==nums[i])continue;
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ls.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                while(left<right && nums[left]==nums[left-1]) left++;
                while(left<right && nums[right]==nums[right+1]) right--;
                }
                else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ls;
    }
}
//lc-18
//4 sum problem optimal solution
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long sum =(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]) left++;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}