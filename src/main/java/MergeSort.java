public class MergeSort {

    /**
     * 递归
     * @param arr 待排序数组
     * @param l 开始下标（包含）
     * @param r 结束下标（包含）
     */
    public static void mergeSort1(int[] arr, int l, int r) {
        if (arr == null || l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(arr, l, m);
        mergeSort1(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            // 谁小拷贝谁
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        // 左侧指针和右侧指针，必有一个越界，有一个不越界
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
    }

    /**
     * 非递归
     * @param arr 待排序数组
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {return;}
        // 一共 O(log n) 次
        for (int l, m, r, step = 1; step < arr.length; step <<= 1) {
            // 内部分组归并，O(n)
            l = 0;
            while (l < arr.length) {
                m = l + step - 1;
                if (m + 1 >= arr.length) {
                    // 没有右边了
                    break;
                }
                // 右边的长度可能不到 step
                r = Math.min(l + (step << 1) - 1, arr.length - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }
}