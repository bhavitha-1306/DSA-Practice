// User function Template for Java
//Longest Subarray with Sum K

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int res=0;
        int pref=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            pref+=arr[i];
            if(pref==k){
                res=i+1;
            }else if(mp.containsKey(pref-k)){
                res=Math.max(res,i-mp.get(pref-k));
            }
            if(!mp.containsKey(pref)){
                mp.put(pref,i);
            }
        }
        return res;
    }
}
//Largest subarray with 0 sum
class Solution {
    int maxLength(int arr[]) {
        // code here
       int n = arr.length;
       int pre[]=new int[n];
       pre[0]=arr[0];
       for(int i=1;i<n;i++){
           pre[i]=pre[i-1]+arr[i];
       }
       HashMap<Integer,Integer> hm = new HashMap<>();
       int max=0;
     //  hm.put(0, -1);

       for(int i=0;i<n;i++){
          if(hm.containsKey(pre[i])){
              max=Math.max(max,i-hm.get(pre[i]));
          }else{
              hm.put(pre[i],i);
          }
       }
       return max;
    }
}
//Subarrays with sum K
class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res=0;
        int currsum=0;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum==k){
                res++;
            }
            if(hm.containsKey(currsum-k)){
                res+=hm.get(currsum-k);
            }
            hm.put(currsum,1+hm.getOrDefault(currsum,0));
        }
        return res;
    }
}