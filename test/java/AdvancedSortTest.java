import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AdvancedSortTest {

    @Test
    public void testMergeSort1() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.common();
            MergeSort.mergeSort1(arr, 0, arr.length - 1);
            ascend(arr);
        }
    }

    @Test
    public void testMergeSort2() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.common();
            MergeSort.mergeSort2(arr);
            ascend(arr);
        }
    }

    private void ascend(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
}
