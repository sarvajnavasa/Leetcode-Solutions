
class Solution {
    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> 
                (nums1[a[0]] + nums2[a[1]])
                - (nums1[b[0]] + nums2[b[1]])
            );

        // Add first pair from each row
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            int i = current[0];
            int j = current[1];

            result.add(
                Arrays.asList(nums1[i], nums2[j])
            );

            k--;

            // Move to next element in nums2
            if (j + 1 < nums2.length) {

                pq.add(new int[]{i, j + 1});
            }
        }

        return result;
    }
}