import java.util.Random;

public class RandomArray {
    public static int indexInArray(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(arr.length);
    }

    public static int numberInArrayRange(int[] arr) {
        Random rd = new Random();
        return rd.nextInt(arr[0], arr[arr.length - 1]);
    }

    public static int[] common() {
        Random rd = new Random();
        int len = rd.nextInt(1,100);  // 获取[origin, bound)之间的整型数
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
        arr[0] = rd.nextInt();
        for (int i = 1; i < len; i++) {
            arr[i] = rd.nextInt(arr[i - 1], Integer.MAX_VALUE);
        }
        return arr;
    }

    public static int[] neighbourDifferent() {
        Random rd = new Random();
        int len = rd.nextInt(2,100);
        int[] arr = new int[len];
        arr[0] = rd.nextInt();
        for (int i = 1; i < len; i++) {
            int temp = rd.nextInt();
            if (temp % 2 == 0 || arr[i - 1] == 0) {
                arr[i] = rd.nextInt(arr[i - 1] + 1, Integer.MAX_VALUE);
            }
            else {
                arr[i] = rd.nextInt(arr[i - 1]);
            }
        }
        return arr;
    }
}
