package sort;

import java.util.Arrays;

public class hanshu {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 3, 2, 4};
        //判断数组是否相等
        boolean isS = Arrays.equals(arr1, arr2);
        System.out.println(isS);
        //遍历数组
        System.out.println(Arrays.toString(arr1));
        //填充数组
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));
        //数组排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        //二分查找
        int index = Arrays.binarySearch(arr2, 3);
        if (index > 0) {
            System.out.println("找到了，位置为：" + index);

        } else {
            System.out.println("未找到");
        }
    }
}
