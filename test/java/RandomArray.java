import java.util.Random;

public class RandomArray {
    public static int indexInArray(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(arr.length);
    }

    public static int numberInArrayRange(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(arr[0], arr[arr.length - 1] + 1);
    }

    public static int numberLeftArrayRange(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(Integer.MIN_VALUE + 1, arr[0]);
    }

    public static int numberRightArrayRange(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(arr[arr.length - 1] + 1, Integer.MAX_VALUE);
    }

    public static int[] common() {
        Random rd = new Random();
        int len = rd.nextInt(1,100);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static int[] ascending() {
        Random rd = new Random();
        int len = rd.nextInt(2,100);
        int[] arr = new int[len];
        arr[0] = rd.nextInt(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 2 * len);
        for (int i = 1; i < len; i++) {
            arr[i] = rd.nextInt(arr[i - 1], Integer.MAX_VALUE - 2 * (len - i));  // 防止因为 arr[i - 1] 过大而找不到 arr[i]
        }
        return arr;
    }

    public static int[] neighbourDifferent() {
        Random rd = new Random();
        int len = rd.nextInt(1,100);
        int[] arr = new int[len];
        arr[0] = rd.nextInt(Integer.MIN_VALUE + 2 * len, Integer.MAX_VALUE - 2 * len);
        for (int i = 1; i < len; i++) {
            int temp = rd.nextInt();
            if (temp % 2 == 0) {
                arr[i] = rd.nextInt(Integer.MIN_VALUE + 2 * (len - i), arr[i - 1]);
            } else {
                arr[i] = rd.nextInt(arr[i - 1] + 1, Integer.MAX_VALUE - 2 * (len - i));
            }
        }
        return arr;
    }
}
