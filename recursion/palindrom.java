import java.util.Scanner;
public class palindrom {
    static boolean fun(String s,int i){
        int n = s.length();
        if(i>=n/2){
            return true;
        }
        char l = s.charAt(i);
        char r = s.charAt(n-i-1);

        if(l!=r){
            return false;
        }
        return fun(s,i+1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if(fun(s,0)){
            System.out.println("Yes palindrom");
        }else{
            System.out.println("Not a palindrom");
        }
    }
}
