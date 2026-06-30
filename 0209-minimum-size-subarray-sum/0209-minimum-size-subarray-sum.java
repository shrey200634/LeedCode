class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     int min_length = Integer.MAX_VALUE;
     int left=0 ;
     int currSum =0;

     for (int right =0 ; right < nums.length ; right ++){
        currSum+= nums[right ];

        while ( currSum >=target){
            if ( right -left +1 < min_length ){
                min_length = right-left +1;
            }
            currSum -= nums[left ];
            left ++;
        }
     }
     return min_length !=Integer.MAX_VALUE ? min_length:0;

    }
}