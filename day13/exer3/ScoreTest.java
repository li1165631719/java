package day13.exer3;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 */
public class ScoreTest {
    public static void main(String[] args) {
        //1.实例化Scanner.用于从键盘获取学生成绩
        Scanner scanner = new Scanner(System.in);

        //2.创建Vetor对象：Vetor v=new Vetor();相当于原来的数组
        Vector vector = new Vector();


        //3.for(;;)或while(true)方式，给Vector中添加数组
        int maxScore = 0;
        for (; ; ) {
            System.out.println("请输入学生成绩（以负数代表输入结束）");
            int score = scanner.nextInt();
            //3.2当输入是负数时，跳出循环
            if (score < 0) {
                break;
            }
            if (score > 100) {
                System.out.println("输入数据非法，请重新输入");
                continue;//直接进入下一次循环
            }
            //3.1添加操作：v.addElement(Object);
            //JDK 5.0 之前：
//            Integer score1=new Integer(score);
//            vector.add(score1);
            //JDK 5.0之后：
            vector.add(score);
            //4.获取学生成绩的最大值
            if (maxScore < score) {
                maxScore = score;
            }


        }
        //5.遍历Vector,得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级。

        char level;
        for (int i = 0; i < vector.size(); i++) {
            Object obj = vector.elementAt(i);
            //JDK 5.0之前:
//           Integer inScore=(Integer)obj;
//           int score=inScore.intValue();
            //JDK 5.0之后：
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
