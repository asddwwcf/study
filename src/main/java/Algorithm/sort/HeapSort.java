package Algorithm.sort;

public class HeapSort {

    static class Heap{
        private Integer[] a; //数组，从下标1开始存储数据
        private int n; //堆可以存储的最大数据个数
        private int count; //堆中已经存储的数据个数

        public Heap(int capacity){
            this.a = new Integer[capacity + 1];
            this.n = capacity;
            this.count = 0;
        }

        public void buildHeap() {
            for (int i = n/2; i >= 1; --i){
                heapify(a, n, i);
            }
        }

        public void insert(int data){
            if (count >= n ) return; //堆满了
            ++count;
            a[count] = data;
            int i = count;
            while (i / 2 > 0 && a[i / 2] < a[i]){
                swap(a, i,i/2);
                i = i / 2;
            }
        }


        //删除堆顶元素
        public void removeMax() {
            if(count == 0) return;  //堆中没有数据
            a[1] = a[count];
            --count;
            heapify(a, count, 1);
        }

        //自上往下堆化
        private void heapify(Integer[] a, int n, int i) {
            while(true){
                int maxpos = i;
                if(i*2 <= n && a[i] < a[i*2]) maxpos = i*2;
                if(i*2 + 1 <= n && a[maxpos] < a[i*2 + 1]) maxpos = i*2+1;
                if (maxpos == i) break;
                swap(a, i, maxpos);
                i = maxpos;
            }
        }


        public void setCount(int count) {
            this.count = count;
        }

        public void setN(int n) {
            this.n = n;
        }

        public void setA(Integer[] a) {
            this.a = a;
        }
    }

    public static void swap(Integer[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }


    public static void heapSort(Integer[] a, int n) {
        Heap hp = new Heap(n);
        hp.buildHeap();
        int k = n;
        while (k > 1)
        {
            swap(a, 1, k);
            --k;
            hp.heapify(a, k, 1);
        }
    }

}
