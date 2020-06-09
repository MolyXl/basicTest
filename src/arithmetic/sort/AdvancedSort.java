package arithmetic.sort;

/**
 * @author mazhuli
 * @date 2020/6/9
 * @desc 高级排序
 */
public class AdvancedSort {
    /**
     * @author: mazhuli
     * @param: arr
     * @desc: 希尔排序
     * @date: 2020/6/9 15:49
     */
    public static void shellSort(int[] arr) {        //
        int inner, outer;
        int temp;
        int h = 1;
        while (h <= arr.length / 2) {
            h = h * 2 + 1;//间隔序列
        }
        //不断缩小间隔，直到1
        while (h > 0) {
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;
                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 2;//不断减少序列间隔
        }
    }


    private static void quickSort(int[] list, int left, int right) {

        // 左下标一定小于右下标，否则就越界了
        if (left < right) {
            // 对数组进行分割，取出下次分割的基准标号
            int base = division(list, left, right);

            // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, left, base - 1);

            // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, base + 1, right);
        }
    }

    public static int division(int[] list, int left, int right) {
        int base = list[left];
        while (left < right) {
            // 从序列右端开始，向左遍历，直到找到小于base的数
            while (left <= right && list[right] >= base) {
                right--;
            }
            // 找到了比base小的元素，将这个元素放到最左边的位置
            list[left] = list[right];

            // 从序列左端开始，向右遍历，直到找到大于base的数
            while (left <= right && list[left] <= base) {
                left++;
            }
            // 找到了比base大的元素，将这个元素放到最右边的位置
            list[right] = list[left];
        }

        // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        list[left] = base;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 4;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 23;
        arr[6] = 2;
        arr[7] = 25;
        arr[8] = 2;
        arr[9] = 21;
        //shellSort(arr);
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
