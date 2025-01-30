public class SimpleSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {  // 通过多次交换把arr[i]插入到合适的位置，这样做都前提是arr[i]之前的数都已经排好序
                swap(arr, j, j + 1);
            }
        }
    }

    public static void selectionSort(int[] arr) {  // 每次选出最小的放到最前面
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {  // 依次遍历所有下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {  // 依次遍历比i大的所有下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {  // 从大到小遍历除了0以外的所有下标
            for (int i = 0; i < e; i++) {  // 依次考虑交换不超过e的相邻下标
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 两个下标不能相等
     * @param arr 数组
     * @param i 下标
     * @param j 下标
     */
    public static void swap2(int[] arr, int i, int j) {
        // 使用异或运算实现交换
        // 异或运算具有交换律和结合律（因为异或运算是无进位加法）
        // a' = a ^ b
        // b' = a' ^ b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
        // a" = a' ^ b' = (a ^ b) ^ a = b ^ (a ^ a) = b ^ 0 = b
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
