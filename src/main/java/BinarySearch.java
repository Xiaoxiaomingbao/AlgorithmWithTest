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
        int mid = (left + right) / 2;
        while (mid >= left && mid <= right) {
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
                mid = (left + right) / 2;
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
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (mid >= left && mid <= right) {
            if (arr[mid] >= target) {
                if (left == right) {
                    return mid;
                }
                right = mid;  // 避免错失最优解
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 某数小于左右相邻两数，则定义其为局部最小值，求解出一个局部最小值即可
     * @param arr 无序数组，要求相邻两数不等，长度至少为2
     * @return 局部最小值（必存在），返回-1说明发生异常
     */
    public static int localMinimum(int[] arr) {
        // 先判断首尾的变化趋势
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (left == mid) {  // 防止left和right相邻时出现死循环
                return mid;
            }
            // 自始至终保证left到right的闭区间中包含局部最小值
            if (arr[mid] < arr[mid - 1]) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}