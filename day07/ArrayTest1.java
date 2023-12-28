package day07;

public class ArrayTest1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        // 求数组元素最大值
        int maxVlue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVlue < arr[i]) {
                maxVlue = arr[i];
            }
        }
        System.out.println("最大值为：" + maxVlue);
        // 求数组元素最小值
        int minVlue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minVlue > arr[i]) {
                minVlue = arr[i];
            }
        }
        System.out.println("最小值为：" + minVlue);
        // 求数组元素和值
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总和为：" + sum);
        // 求数组元素平均值
        int avg = 0;
        avg = sum / arr.length;
        System.out.println("平均值为：" + avg);


    }
}
