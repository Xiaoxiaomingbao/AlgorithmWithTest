import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideMergeTest {
    @Test
    public void testSmallSum() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(20, DivideMerge.smallSum(arr));
    }

    @Test

    public void testInversePairCount() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        assertEquals(0, DivideMerge.inversePairCount(arr1));
        assertEquals(10, DivideMerge.inversePairCount(arr2));
    }
}
