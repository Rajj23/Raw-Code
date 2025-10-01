class swapArr{
    static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    // static void rec(int[] arr,int l,int r){
    //     if(l>=r){
    //         return;
    //     }
    //     swap(arr,l,r);
    //     rec(arr,l+1,r-1);
    // }

    static void rec(int[] arr,int i){
        int n = arr.length;
        if(i>=n/2){
            return;
        }
        swap(arr,i,(n-i-1));
        rec(arr,i+1);
    }

    public static void main(String[] args){
        int[] arr = {2,4,14,8,0,7};
        for(int ar:arr){
            System.out.print(ar+" ");
        }
        System.out.println();
        int n = arr.length;


        // rec(arr,0,n-1);

        rec(arr,0);

        System.out.println("Reverse: ");
        for(int ar:arr){
            System.out.print(ar+" ");
        }
    }
}