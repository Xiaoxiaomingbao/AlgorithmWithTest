import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwapTest {
    @Test
    public void testXORSwap() {
        int[] arr = RandomArray.common();
        int[] array = arr.clone();
        for (int i = 0; i < 100; i++) {
            int m = RandomArray.indexInArray(arr);
            int n = RandomArray.indexInArray(arr);
            if (m == n) {
                continue;
            }
            System.out.println("交换" + arr[m] + "和" + arr[n]);
            SimpleSort.swap(arr, m, n);
            SimpleSort.swap2(array, m, n);
            assertEquals(arr[m], array[m]);
            assertEquals(arr[n], array[n]);
        }
    }
}
