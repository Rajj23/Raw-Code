import java.util.*;
public class subSequence {

    static void printF(int i,int[] arr,List<Integer> ds,int n){
        if(i==n){
            for(int d:ds){
                System.out.print(d+ " ");
            }
            if(ds.isEmpty()){
                System.out.println("{}");
            }
            System.out.println();
            return;
        }

        ds.add(arr[i]);
        printF(i+1, arr, ds, n);
        ds.removeLast();
        printF(i+1, arr, ds, n);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        printF(0,arr,ds,n);

    }
}
