package javahigh.day04.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * JDK8之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.calendar
 *
 * @Author lizhihao
 * @Date 2023/12/12 9:52
 */
public class DateTimeTest {
    /**
     * SimpleDateFormat的使用，SimpleDateFormat对日期Date类的格式化和解析
     * 1.两个操作：
     * 1.1格式化：日期-----》字符串
     * 1.2解析：格式化的逆过程，字符串------》日期
     * <p>
     * 2.SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() {
        //实例化SimpleDateFormat：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-----》字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串------》日期
        String str = "2023/12/12 下午10:47";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);

            //************按照指定的方式格式化和解析：调用带参的构造器***********************
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format1 = simpleDateFormat1.format(date);
            System.out.println(format1);//2023-12-12 11:15:49
            //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
            //否则，抛异常
            Date date2 = simpleDateFormat1.parse("2023-12-12 11:15:49");
            System.out.println(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 练习一：字符串“2020-09-08”转换为java.sql.Date
     * <p>
     * 练习二：“三天打鱼两天晒网” 1990-01-01 xxxx-xx-xx 打渔？晒网？
     * <p>
     * 举例：2020-09-08？ 总天数
     * <p>
     * 总天数%5==1，2，3：打鱼
     * 总天数%5==4，0：晒网
     * <p>
     * 总天数的计算？
     * 方式一：（date2.getTime（）-date1.getTime（））/(1000*60*60*24)+1
     * 方式二：1990-01-01 ---》2019-12-31 +2020-01-01-----》2020-09-08
     */
    @Test
    public void testExer() {
        String birth = "2020-09-08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(birth);
            java.sql.Date date = new java.sql.Date(parse.getTime());
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Calendar 日历类的使用
     * <p>
     * 注意：
     * 获取月份时候，一月是0，二月是1，以此类推，12月是11
     * 获取星期时：周日是1，周一是2.。。。。周六是7
     */

    @Test
    public void testCalendar() {
        //实例化
        //方式一：创建其子类的对象
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        //方式二：调用它的静态方法
        Calendar calendar = Calendar.getInstance();
        //    System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//22
        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);//+3天，也可以直接传-3减3天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//25
        //getTime():日历类----->Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date----->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


    }

}
