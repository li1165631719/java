package day13.exer3;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 */
public class ScoreTest {
    public static void main(String[] args) {
        //1.ʵ����Scanner.���ڴӼ��̻�ȡѧ���ɼ�
        Scanner scanner = new Scanner(System.in);

        //2.����Vetor����Vetor v=new Vetor();�൱��ԭ��������
        Vector vector = new Vector();


        //3.for(;;)��while(true)��ʽ����Vector���������
        int maxScore = 0;
        for (; ; ) {
            System.out.println("������ѧ���ɼ����Ը����������������");
            int score = scanner.nextInt();
            //3.2�������Ǹ���ʱ������ѭ��
            if (score < 0) {
                break;
            }
            if (score > 100) {
                System.out.println("�������ݷǷ�������������");
                continue;//ֱ�ӽ�����һ��ѭ��
            }
            //3.1��Ӳ�����v.addElement(Object);
            //JDK 5.0 ֮ǰ��
//            Integer score1=new Integer(score);
//            vector.add(score1);
            //JDK 5.0֮��
            vector.add(score);
            //4.��ȡѧ���ɼ������ֵ
            if (maxScore < score) {
                maxScore = score;
            }


        }
        //5.����Vector,�õ�ÿ��ѧ���ĳɼ����������ɼ��Ƚϣ��õ�ÿ��ѧ���ĵȼ���

        char level;
        for (int i = 0; i < vector.size(); i++) {
            Object obj = vector.elementAt(i);
            //JDK 5.0֮ǰ:
//           Integer inScore=(Integer)obj;
//           int score=inScore.intValue();
            //JDK 5.0֮��
            int score = (Integer) obj;
            if (maxScore - score <= 10) {
                level = 'A';
            } else if (maxScore - score <= 20) {
                level = 'B';
            } else if (maxScore - score <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }

            System.out.println("student-" + i + " " +
                    "score is " + score + ",level is " + level);

        }


    }
}
