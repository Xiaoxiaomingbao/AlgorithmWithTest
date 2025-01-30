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
                System.out.println("随机数" + num + "命中");
            }
        }
    }

    @Test
    public void testLeftmostPlace() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.ascending();
            int num = RandomArray.numberInArrayRange(arr);
            int res = BinarySearch.leftmostPlace(arr, num);
            assertNotEquals(-1, res);
            verifyLeftmostPlace(arr, res, num);
        }
    }

    private void verifyLeftmostPlace(int[] arr, int index, int target) {
        assertTrue(arr[index] >= target);
        if (index > 0) {
            assertFalse(arr[index - 1] >= target);
        }
    }

    @Test
    public void testLocalMinimum() {
        ;
    }
}
