//3507. Minimum Pair Removal to Sort Array I
//Given an array nums, you can perform the following operation any number of times:

// Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
// Replace the pair with their sum.
// Return the minimum number of operations needed to make the array non-decreasing.
class Solution {
     private static boolean Decreasing(List<Integer> l) {
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) < l.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int num : nums) l.add(num);

        int operations = 0;

        while (!Decreasing(l)) {
            int Sum = Integer.MAX_VALUE;
            int Index = -1;

        
            for (int i = 0; i < l.size() - 1; i++) {
                int sum1 = l.get(i) + l.get(i + 1);
                if (sum1 < Sum) {
                    Sum = sum1;
                    Index = i;
                }
            }

           
            int merged = l.get(Index) + l.get(Index + 1);
            l.remove(Index);       
            l.set(Index, merged);   

            operations++;
        }

        return operations;
    }

}