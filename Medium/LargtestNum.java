package Medium;

import java.util.Arrays;

public class LargtestNum {

    public String largeNum (int []nums ){
        String[] strNum  = new String[nums.length];
        for(int i =0 ; i< nums.length ; i++){
            strNum[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNum , (a,b) ->{
            String order1 = a+b ;
            String order2 = b+a  ;
            return order2.compareTo(order1);
        });

        if (strNum[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strNum){
            sb.append(s);
        }
        return sb.toString();
    }
    
}
