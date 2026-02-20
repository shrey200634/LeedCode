package Hard;

public class ShortestPalindrome {
     public String shortestPalindrome(String s) {
        if (s.isEmpty()){
            return s;
        }
        long FH =0 ;
        long BH =0;

        long power =1;
        long PRIME= 31;

        long MOD = 1_000_00_007;

        int lastIndex =0;

        for(int i =0; i<s.length() ; i++){
            char c = s.charAt(i);

            //FORDWARD HASH ;

            FH = (FH * PRIME  +c) %MOD;
            // BACKWARD 
            BH =(BH +(long)c *power )%MOD;

            if ( FH==BH){
                lastIndex=i;

            }
            power =(power * PRIME  ) %MOD;
        }

        String remaining = s.substring(lastIndex +1);
        StringBuilder sb = new StringBuilder(remaining);
        return sb.reverse().toString() +s;

        
    }
    
}
