package Medium.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC {
    
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        Arrays.sort(nums);
        int n = nums.length;
        int size = n / 3;
        
        int i = 0;
        while (i < n) {
            int currentNum = nums[i];
            int count = 0;
            
            while (i < n && nums[i] == currentNum) {
                count++;
                i++;
            }
            
            if (count > size) {
                list.add(currentNum);
            }
        }
        
        return list;
    }
}

