# 算法基础

## 简单排序算法

### 插入排序 选择排序 冒泡排序

```java
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
```

附：异或运算 例题
1. 某个数组中只有一种数出现奇数次，其他数都出现偶数次，求这个特殊的数
2. 某个数组中只有两种数出现奇数次，其他数都出现偶数次，求这两个特殊的数

解：
1. 对数组中所有数取异或即可
2. 对数组中所有数取异或，得到两个特殊数的异或运算结果$r$，$r$中必有一位是1，设其为第$p$位，对数组中第$p$位为1的数取异或，得到其中一个特殊数$a$，再将$a$与$r$异或，得到另一个特殊数$b$

### 二分法

1. 在一个有序数组中，找某个数是否存在
2. 在一个有序数组中，找大于等于某个数的最左侧位置
3. 局部最小值问题：数组无序，相邻两数不等。某数小于左右相邻两数，则定义其为局部最小值。求解数组中的局部最小值，找出一个即可。

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {  // 要求数组升序排列；返回下标，找不到返回-1
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
    public static int leftmostPlace(int[] arr, int target) {  // 要求数组升序排列；返回下标，找不到返回-1
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
    public static int localMinimum(int[] arr) {  // 数组长度至少为2；异常返回-1
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
```

## $O(n\log n)$的排序

### 归并排序



# 基础提升


# 中级提升


# 高级进阶


