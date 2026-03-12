public class jhb {


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine(); 
            
            for (int i = 0; i < n; i++) {
                String word = sc.nextLine();
                int len = word.length();
                
                if (len > 10) {
                    System.out.println("" + word.charAt(0) + (len - 2) + word.charAt(len - 1));
                } else {
                    System.out.println(word);
                }
            }
        }
        sc.close();
    }
}



    
}
