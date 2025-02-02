public class BinarySearch {
    /**
     * 传统的二分搜索
     * @param arr 升序排列的数组
     * @param target 目标值
     * @return 返回下标，找不到返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {  // 自始至终将搜索目标锁定在 [left, right]
            int mid = left + ((right - left) >> 1);  // 防溢出
            if (target == arr[mid]) {
                return mid;
            }
            else {
                if (target > arr[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 在一个有序数组中，找大于等于某个数的最左侧位置
     * @param arr 升序排列的数组
     * @param target 目标值
     * @return 返回下标，找不到返回-1
     */
    public static int leftmostPlace(int[] arr, int target) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {  // 自始至终将搜索目标锁定在 [left, right]
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                ans = mid;  // 记录下当前找到的解（数组中大于等于 target 的数），继续找下去未必会发现更优解
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 设 -1 和 arr.length 位置的数为无穷小，若某数同时大于左右两侧的数，则定义为峰值
     * @param arr 无序数组，要求相邻两数不等
     * @return 一个峰值所在的位置
     */
    public static int peak(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        // arr.length >= 2
        // 单独检查 0 位置是不是峰值点
        if (arr[0] > arr[1]) {
            return 0;
        }
        // 单独检查 arr.length - 1 位置是不是峰值点
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int ans = -1;  // 可证明峰值一定存在，不会返回 -1
        while (left <= right) {  // 自始至终将搜索目标锁定在 [left, right]
            int mid = left + ((right - left) >> 1);
            if (arr[mid - 1] > arr[mid]) {  // ↗ ↘
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {  // ↗ ↘
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}