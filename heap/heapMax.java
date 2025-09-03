class heap{
        int[] arr = new int[100];
        int size = 0;

        void insert(int val){
            size++;
            int index = size;
            arr[index] = val;

            while(index>1){
                int parent = index/2;
                if(arr[parent]<arr[index]){
                    swap(parent,index);
                    index = parent;
                }
                else{
                    return;
                }
            }
        }

        void delete(){
            if(size==0){
                System.out.println("No element to delete");
            }

            int i = 1;
            arr[i] = arr[size];
            size--;

            while(i<size){
                int leftChild = i*2;
                int rightChild = i*2+1;

                if(leftChild<size && arr[i]<arr[leftChild]){
                    swap(i,leftChild);
                    i=leftChild;
                }
                else if(rightChild<size && arr[i]<arr[rightChild]){
                    swap(i,rightChild);
                    i=rightChild;
                }
                else{
                    return;
                }
            }
        }
        

        void print(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        void swap(int a,int b){
            int temp = arr[a];
            arr[a] = arr[b];
           arr[b] = temp;
        }

    }


class heapMax{

        static void swap(int[]arr, int a,int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

       static void heapify(int[] num,int n,int i){
            int largest = i;
            int left = i*2;
            int right = i*2+1;

            if(left<n && num[largest]<num[left]){
                largest=left;
            }

            if(right<n && num[largest]<num[right]){
                largest=right;
            }

            if(largest!=i){
                swap(num,largest,i);
                heapify(num, n, largest);
            }
        }
    
    
    public static void main(String[] args){
        heap h = new heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        h.print();

        h.delete();
        h.print();

        int[] arr = new int[]{-1,54,53, 55,52,50};

        int n = 5;
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }

        System.out.println("Printing heapify now: ");

        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }


    }
}