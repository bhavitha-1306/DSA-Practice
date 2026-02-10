// 11-02-26
// daily question 
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int mx=0;
        for(int i=0;i<=n-1;i++){
            Set<Integer> e = new HashSet<>();
            Set<Integer> o = new HashSet<>();
            for(int j=i;j<=n-1;j++){
                int cur=nums[j];
                if(cur%2==0){
                  e.add(cur);
                }else{
                  o.add(cur);
                }
                if(e.size()==o.size()){
                    mx=Math.max(mx,j-i+1);
                }
            }
        }
        return mx;
    }
}
// after a long tym done with an hard question 
class Solution {
    public static int largest(int arr[],int j){
        int ans=1;
        int sumation = 0;
        for(int i=0;i<arr.length;i++){
            if(sumation+arr[i]<=j){
                sumation+=arr[i];
            }else{
                ans++;
                sumation=arr[i];
            }
        }
        return ans;
    } 
    public static int max(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
           sum+=arr[i];
        }
        return sum;
    }
    public int splitArray(int[] nums, int k) {
        int low=max(nums);
        int high=sum(nums);
        int n = nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(largest(nums,mid)<=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}