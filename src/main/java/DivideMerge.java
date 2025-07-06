public class DivideMerge {
    /**
     * “小和”：累加数组中的每个元素前面小于等于该元素的所有元素之和
     * @param arr 输入数组
     * @return “小和”
     */
    public static long smallSum(int[] arr) {
        if (arr == null || arr.length == 0) return 0L;
        return smallSum(arr, 0, arr.length - 1);
    }

    private static long smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(arr, l, m) + smallSum(arr, m + 1, r) + mergeSmallSum(arr, l, m, r);
    }

    // 现在左侧有序，右侧有序
    // 利用左侧和右侧的有序性计算跨左侧和右侧的“小和”
    // 再使用归并法让整体有序
    private static long mergeSmallSum(int[] arr, int l, int m, int r) {
        long ans = 0L;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        // 正常归并
        MergeSort.merge(arr, l, m, r);
        return ans;
    }

    /**
     * 逆序对：一个数的下标小于另一个数的下标，但这个数比另一个数大
     * @param arr 输入数组
     * @return 逆序对的数量
     */
    public static int inversePairCount(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return inversePairCount(arr, 0, arr.length - 1);
    }

    private static int inversePairCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return inversePairCount(arr, l, m) + inversePairCount(arr, m + 1, r) + mergeInversePairCount(arr, l, m, r);
    }

    private static int mergeInversePairCount(int[] arr, int l, int m, int r) {
        int count = 0;
        for (int j = m + 1, i = l; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                i++;
            }
            count += (m - i + 1);
        }
        // 正常归并
        MergeSort.merge(arr, l, m, r);
        return count;
    }
}
