//30 jan 2026
//not much done
// 56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        // 1. Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // 2. Initialize first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Overlapping case
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } 
            // Non-overlapping case
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
