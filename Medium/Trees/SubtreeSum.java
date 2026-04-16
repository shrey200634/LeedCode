import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    // Map to store the frequency of each subtree sum
    private Map<Integer, Integer> sumCounts;
    // Variable to track the highest frequency of any sum
    private int maxFreq;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumCounts = new HashMap<>();
        maxFreq = 0;

        // Traverse the tree to calculate all subtree sums and their frequencies
        calculateSum(root);

        // Collect all sums that occurred 'maxFreq' times
        List<Integer> maxFreqSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCounts.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxFreqSums.add(entry.getKey());
            }
        }

        // Convert the list of results into an int array
        int[] result = new int[maxFreqSums.size()];
        for (int i = 0; i < maxFreqSums.size(); i++) {
            result[i] = maxFreqSums.get(i);
        }

        return result;
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively find the sum of the left and right subtrees
        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);

        // The total sum for the current subtree
        int currentSum = node.val + leftSum + rightSum;

        // Update the frequency map
        int count = sumCounts.getOrDefault(currentSum, 0) + 1;
        sumCounts.put(currentSum, count);

        // Update the global maximum frequency
        maxFreq = Math.max(maxFreq, count);

        // Return the current sum so the parent node can use it
        return currentSum;
    }
}