package day07;

public class ArrayTest1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        //����
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        // ������Ԫ�����ֵ
        int maxVlue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVlue < arr[i]) {
                maxVlue = arr[i];
            }
        }
        System.out.println("���ֵΪ��" + maxVlue);
        // ������Ԫ����Сֵ
        int minVlue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minVlue > arr[i]) {
                minVlue = arr[i];
            }
        }
        System.out.println("��СֵΪ��" + minVlue);
        // ������Ԫ�غ�ֵ
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("�ܺ�Ϊ��" + sum);
        // ������Ԫ��ƽ��ֵ
        int avg = 0;
        avg = sum / arr.length;
        System.out.println("ƽ��ֵΪ��" + avg);


    }
}
