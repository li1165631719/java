package sort;

//直接插入排序
public class InsertSort {
    public static void main() {
        int i, j;
        int[] arr = new int[10];
        for (i = 2; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {//如果插入的值较小，则需要设置哨兵，把较大的元素进行后移操作
                arr[0] = arr[i];
            }
            for (j = i - 1; arr[j] > arr[0]; j--) {//判断要移动几位并移动
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = arr[0];
        }
    }
}//算法时间复杂度为O（n^2）
//该算法元素移动顺序，所以是稳定的
