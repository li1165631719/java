package day07;

public class ArrayTest2 {
    public static void main(String[] args) {
        String[] arr = new String[]{"FF", "EE", "DD", "CC", "BB", "AA"};
        //数组的赋值（区别于数组变量的赋值：arr1=arr）
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        //数组的反转
        //方法一：
//        for(int i=0;i<arr1.length/2;i++){
//            String temp=arr1[i];
//            arr1[i]=arr1[arr1.length-i-1];
//            arr1[arr1.length-i-1]=temp;
//
//        }
        //方法二：
        for (int i = 0, j = arr1.length - 1; i < j; i++, j--) {
            String temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;
        }
        //遍历
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();
        //查找
        //线性查找
        String dest = "BB";
        boolean isFlag = true;
        for (int i = 0; i < arr.length; i++) {
            if (dest.equals(arr[i])) {
                System.out.println("找到了指定的元素，位置为：" + i);
                isFlag = false;
                break;
            }


        }
        if (isFlag == true) {
            System.out.println("很遗憾没找到。");
        }
        //二分查找法：
        //前提：所要查找的数组必须有序
        int[] arr2 = new int[]{-99, -98, -34, -16, 111, 112, 139, 396};
        int dest1 = -34;
        int head = 0;
        int end = arr2.length - 1;
        boolean isFlag1 = true;
        while (head <= end) {
            int middle = (head + end) / 2;
            if (dest1 == arr2[middle]) {
                System.out.println("找到指定元素啦，位置为：" + middle);
                isFlag1 = false;
                break;
            } else if (dest1 < arr2[middle]) {
                end = middle - 1;

            } else if (dest1 > arr2[middle]) {
                head = middle + 1;
            }

        }
        if (isFlag1) {
            System.out.println("很抱歉，没找到指定元素！");
        }


    }
}
