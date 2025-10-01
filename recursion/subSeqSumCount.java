public class subSeqSumCount {
    static int printS(int i,int[] arr,int s,int sum,int n){
        if(i==n){
            if(s==sum){
                return 1;
            }
            else return 0;
        }

        s+=arr[i];
        int l = printS(i+1, arr, s, sum, n);

        s-=arr[i];
        int r = printS(i+1, arr, s, sum, n);

        return l+r;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int n = arr.length;
        int count = printS(0,arr,0,2,n);

        System.out.println(count);
    }
}
