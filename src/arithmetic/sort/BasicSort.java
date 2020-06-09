package arithmetic.sort;

/**
 * @author mazhuli
 * @date 2020/6/9
 * @desc 基础排序
 */
public class BasicSort {
    /**
     * @author: mazhuli
     * @param: array
     * @desc: 插入排序
     * @date: 2020/6/9 11:10
     */
    public static void insertSort(int[] array) {        //将新的元素插入到已排好序的数组中,(有序数组可做二分快速查找)
        for (int i = 1; i < array.length; i++) {
            int j;
            int insertedNum = array[i];
            for (j = i - 1; j >= 0 && array[j] > insertedNum; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = insertedNum;
        }
    }

    /**
     * @author: mazhuli
     * @param: array
     * @desc: 冒泡排序
     * @date: 2020/6/9 11:10
     */
    public static void bubleSort(int[] array) {         //从前向后,遍历剩余数组中每个值,与当前值比较大小并交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tem = array[j];
                    array[j] = array[i];
                    array[i] = tem;
                }
            }
        }
    }

    /**
     * @author: mazhuli
     * @param: array
     * @desc: 选择排序
     * @date: 2020/6/9 11:10
     */
    public static void selectionSort(int[] array) {         //从前向后,查询剩余数组中的最小值与当前值交换
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tem = array[i];
                array[i] = array[min];
                array[min] = tem;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 4;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 1;
        arr[4] = 2;
        //insertSort(arr);
        //bubleSort(arr);
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
