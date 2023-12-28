package javahigh.day04.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk8中日期时间API的测试
 *
 * @Author lizhihao
 * @Date 2023/12/16 21:06
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8); //Tue Sep 08 00:00:00 CST 2020
        System.out.println(date1);
    }

    /**
     * LocalDate、LocalTime、LocalDateTime的使用
     * 说明：
     * 1.LocalDateTime相较于LocalDate、LocalTime,使用频率较高
     */
    @Test
    public void test1() {
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 12, 17, 22, 13, 22);
        System.out.println(localDateTime1);

        //getXxx():
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(4);
        System.out.println(localDateTime3);
        System.out.println(localDateTime);

        //plusXxx()
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime);

        //miusXxx()
        LocalDateTime localDateTime5 = localDateTime.minusDays(6);
        System.out.println(localDateTime5);
        System.out.println(localDateTime);


    }

    @Test
    public void test2() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2023-12-17T16:32:39.278040700Z(本初子午线)

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2023-12-18T00:36:22.588181600+08:00

        //toEpochMilli()：获取自1970年1月1日0时0分（UTC）开始的毫秒数
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 ---->Date类的getTime()方法
        Instant instant1 = Instant.ofEpochMilli(1702908799563L);
        System.out.println(instant1);


    }

    /**
     * DateTimeFormatter:格式化或解析日期、时间
     * 类型于SimpleDateFormat
     */
    @Test
    public void test3() {
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        //格式化-》字符串
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        String format = isoDateTime.format(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(format);
        //解析：字符串-》日期
        TemporalAccessor parse = isoDateTime.parse(format);
        System.out.println(parse);

        //方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        //本地化相关的格式。如：ofLocalizedDateTime()
        //FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDateTime

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        //格式化：
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);//2023年12月23日 CST 下午10:33:22
        //解析：
        TemporalAccessor parse1 = dateTimeFormatter.parse(format1);
        System.out.println(parse1);
        //本地化相关的格式。如：ofLocalizedDate()
        //FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDate


        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalDate now = LocalDate.now();
        String format2 = dateTimeFormatter1.format(now);
        System.out.println(format2);//2023/12/23


        //重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化：
        String format3 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format3);
        //解析：
        TemporalAccessor parse2 = dateTimeFormatter2.parse(format3);
        System.out.println(parse2);
        System.out.println(parse2);



    }
}
