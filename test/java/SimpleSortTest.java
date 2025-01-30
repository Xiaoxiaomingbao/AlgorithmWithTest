import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleSortTest {
    @Test
    public void testInsertionSort() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.common();
            SimpleSort.insertionSort(arr);
            ascend(arr);
        }
    }

    @Test
    public void testSelectionSort() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.common();
            SimpleSort.selectionSort(arr);
            ascend(arr);
        }
    }

    @Test
    public void testBubbleSort() {
        for (int i = 0; i < 100; i++) {
            int[] arr = RandomArray.common();
            SimpleSort.bubbleSort(arr);
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
