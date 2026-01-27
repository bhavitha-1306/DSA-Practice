//so i was little effective today and done more than 5 leetcode problems
// 1.solved Longest palindromic Substring
// without using dp 

//without using Dyanamic Programming
class Solution {
    public boolean ispalindromic(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
              //  break;
            }
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
       int n = s.length();
       String maxi="";
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(ispalindromic(s,i,j)){
                String cur=s.substring(i,j+1);
                if(cur.length()>maxi.length()){
                    maxi=cur;
                }
            }
        }
       } 
       return maxi;
    }
}
//lc-1614
//after this i solved an easy question of Strings 
//Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
class Solution {
    public int maxDepth(String s) {
        List<Character> lst = new ArrayList<>();
        int  n = s.length();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('|| s.charAt(i)==')'){
                lst.add(s.charAt(i));
            }
        }
        int max=0;
        for(int i=0;i<lst.size();i++){
            if(lst.get(i)=='('){
                count++;
                max=Math.max(count,max);
            }else{
                count--;
            }
        }
        return max;
    }
}
// solved the Daily Question 
// 1200. Minimum Absolute Difference
// Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
          min=Math.min(min,Math.abs(arr[i-1]-arr[i]));
        }
        System.out.println(min);
      //  return lst;
         for(int i=1;i<n;i++){
               if(Math.abs(arr[i]-arr[i-1])==min){
                List<Integer> ls = new ArrayList<>();
                    ls.add(arr[i-1]);
                    ls.add(arr[i]);
                  //Collections.sort(ls);
                     lst.add(ls);
               }
        }
        return lst;
    }
}
//solved another problem called String to Integer(atoi)
//lc-8
//where itss alittle tricky so i used gpt for this but i completely understood the logic
//where the qun states to convert a string to an integer
//by this i learned how to handle the overflow
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i=0;
        int sign=1;
        int res=0;
        //spaces
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        //symbols
        if(i<n && (s.charAt(i)=='+'|| s.charAt(i)=='-')){
            if(s.charAt(i)=='-') sign=-1;
            i++;
        }
        //read digits with overflow check
        while(i<n && Character.isDigit(s.charAt(i))){
           int digit = s.charAt(i) - '0';

            // 🔴 FIX IS HERE
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }
     return  res*sign;
    }
}
// the again an easy problem 
//longest common prefix
//lc-14
//ongst an array of strings.
//If there is no common prefix, return an empty string "".
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str=strs[0];
        int n = strs.length;
        if(strs==null || strs.length==0){
            return "";
        }
        if(str.length()==0){
            return "";
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            for(int j=1;j<n;j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=ch){
                    return str.substring(0,i);
                }
            }
        }
      return str;
    }
}
// Largest Odd Number in a string(easy problem)
class Solution {
    public String largestOddNumber(String num) {
         for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {   // odd digit
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
//Divide two integers without using multiplication, division and mod operator.
//lc-29
//i like the question and little tricky but its good
//solved by using Bit Manipulation
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor){
            return 1;
        }
        int sign=1;
        if(dividend>0 && divisor<0) sign=-1;
        if(dividend<0 && divisor>0) sign=-1;
        long n = Math.abs((long)dividend);
        long m = Math.abs((long)divisor);
        long quo=0;
        while(n>=m){
            int cnt=0;
            while(n>(m<<(cnt+1))){
                cnt++;
            }quo+=1L<<cnt;
            n-=(m<<cnt);
        }
        if (dividend == Integer.MIN_VALUE && divisor== -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }

        if(sign==1){
            return (int)quo;
        }
        return sign*(int)quo;
    }
}