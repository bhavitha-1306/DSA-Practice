//done with daily qun 
//744. Find Smallest Letter Greater Than Target
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        char ans = letters[0];
        for(int i=0;i<letters.length;i++){
             int res=target-'0';
             System.out.println(res);
             int fin=letters[i]-'0';
               System.out.print(fin);
             if(fin>res){
                ans=letters[i];
                break;
             }
        }
        return ans;
    }
}
//contest qun 
//3823. Reverse Letters Then Special Characters in a String
Solved
// Easy
// premium lock icon
// Companies
// Hint
// You are given a string s consisting of lowercase English letters and special characters.

// Your task is to perform these in order:

// Reverse the lowercase letters and place them back into the positions originally occupied by letters.
// Reverse the special characters and place them back into the positions originally occupied by special characters.
// Return the resulting string after performing the reversals.
class Solution {
    public String reverseByType(String s) {
        List<Character> special = new ArrayList<>();
        List<Character> alpha = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                alpha.add(s.charAt(i));
            }else{
                special.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int idx=alpha.size()-1;
        int idx2=special.size()-1;
        for(int i=0;i<sb.length();i++){
            if(Character.isLetter(sb.charAt(i))){
                sb.setCharAt(i,alpha.get(idx));
                idx--;
            }else{
                sb.setCharAt(i,special.get(idx2));
                idx2--;
            }
        }
        return sb.toString();
    }
}