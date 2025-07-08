public class QuickSort {

    public static void quickSort1(int[] arr, int l, int r) {
        if (arr == null || l >= r) {return;}
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        int mid = partition1(arr, l, r, x);  // [l, mid] 小于等于 x 的数
        quickSort1(arr, l, mid);
        quickSort1(arr,mid + 1, r);
    }

    /**
     * 小于等于 x 放左边，大于 x 放右边，划分完成后小于等于 x 区域最后一个数是 x
     * @return 小于等于 x 的最后一个数的下标
     */
    private static int partition1(int[] arr, int l, int r, int x) {
        int a = l, xi = 0;  // [l, a - 1] 为小于等于 x 的区域，xi 记录最后一个 x 的位置
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                SimpleSort.swap(arr, a, i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        SimpleSort.swap(arr, xi, a - 1);
        return a - 1;
    }

    public static void quickSort2(int[] arr, int l, int r) {
        if (arr == null || l >= r) {return;}
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        Pair<Integer> pair = partition2(arr, l, r, x);
        quickSort2(arr, l, pair.first - 1);
        quickSort2(arr,pair.second + 1, r);
    }

    private static class Pair<T> {
        T first;
        T second;
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * 荷兰国旗问题
     * 小于 x 放左边，大于 x 放右边，等于 x 放中间
     * @return 返回的第一个数是小于 x 的结束下标（不包含），返回的第二个数是大于 x 的开始下标（不包含）
     */
    private static Pair<Integer> partition2(int[] arr, int l, int r, int x) {
        int first = l;
        int last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                SimpleSort.swap(arr, first++, i++);
            } else {
                SimpleSort.swap(arr, i, last--);
            }
        }
        return new Pair<>(first, last);
    }
}
