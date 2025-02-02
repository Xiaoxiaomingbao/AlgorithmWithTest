import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        // 搜索数组中的数
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.ascending();
            int num = arr[RandomArray.indexInArray(arr)];
            int res = BinarySearch.binarySearch(arr, num);
            assertEquals(num, arr[res]);
        }
        // 搜索数组范围内的随机数
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberInArrayRange(arr);
            int res = BinarySearch.binarySearch(arr, num);
            if (res == -1) {
                for (int k : arr) {
                    assertNotEquals(num, k);
                }
            }
            else {
                assertEquals(num, arr[res]);
                System.out.println("数组范围内的随机数 " + num + " 命中");
            }
        }
        // 搜索数组范围外的随机数
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberLeftArrayRange(arr);
            int res = BinarySearch.binarySearch(arr, num);
            assertEquals(-1, res);
        }
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberRightArrayRange(arr);
            int res = BinarySearch.binarySearch(arr, num);
            assertEquals(-1, res);
        }
    }

    @Test
    public void testLeftmostPlace() {
        // target 在数组范围内
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberInArrayRange(arr);
            int res = BinarySearch.leftmostPlace(arr, num);
            assertNotEquals(-1, res);
            verifyLeftmostPlace(arr, res, num);
        }
        // target 在数组范围左侧
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberLeftArrayRange(arr);
            int res = BinarySearch.leftmostPlace(arr, num);
            assertEquals(0, res);
        }
        // target 在数组范围右侧
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberRightArrayRange(arr);
            int res = BinarySearch.leftmostPlace(arr, num);
            assertEquals(-1, res);
        }
    }

    private void verifyLeftmostPlace(int[] arr, int index, int target) {
        assertTrue(arr[index] >= target);
        if (index > 0) {
            assertFalse(arr[index - 1] >= target);
        }
    }

    @Test
    public void testPeak() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.neighbourDifferent();
            int res = BinarySearch.peak(arr);
            assertTrue(res >= 0);
            assertTrue(res < arr.length);
            if (arr.length == 1) {
                return;
            }
            if (res == 0) {
                assertTrue(arr[0] > arr[1]);
                return;
            }
            if (res == arr.length - 1) {
                assertTrue(arr[arr.length - 1] > arr[arr.length - 2]);
                return;
            }
            assertTrue(arr[res] > arr[res + 1]);
            assertTrue(arr[res] > arr[res - 1]);
        }
    }
}
