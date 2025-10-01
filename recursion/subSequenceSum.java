import java.util.*;

public class subSequenceSum {
    
    // This will print All subsequence of given Sum

    // static void printSum(int i,int[] arr,int s,int n,List<Integer> ds,int sum){
    //     if(i==n){
    //         if(s==sum){
    //             for(int d : ds){
    //                 System.out.print(d+" ");
    //             }
    //             System.out.println();
    //         }
    //         return;
    //     }
    //     // takeit condition
    //     s+=arr[i];
    //     ds.add(arr[i]);
    //     printSum(i+1, arr, s, n, ds, sum);

    //     // not takeit condition
    //     s-=arr[i];
    //     ds.removeLast();
    //     printSum(i+1, arr, s, n, ds, sum);
    // }


    // This will only print only 1 Subsequence of given Sum

    static boolean printSum(int i,int[] arr,int s,int n,List<Integer> ds,int sum){
        if(i==n){
            if(s==sum){
                for(int d : ds){
                    System.out.print(d+" ");
                }
                System.out.println();
                return true;
            }
            return false;
        }
        // takeit condition
        s+=arr[i];
        ds.add(arr[i]);
        if(printSum(i+1, arr, s, n, ds, sum)==true){
            return true;
        }

        // not takeit condition
        s-=arr[i];
        ds.removeLast();
        if(printSum(i+1, arr, s, n, ds, sum)==true){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        printSum(0,arr,0,n,ds,2);
    }
}
