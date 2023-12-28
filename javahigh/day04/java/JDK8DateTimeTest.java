package javahigh.day04.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk8������ʱ��API�Ĳ���
 *
 * @Author lizhihao
 * @Date 2023/12/16 21:06
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //ƫ����
        Date date1 = new Date(2020 - 1900, 9 - 1, 8); //Tue Sep 08 00:00:00 CST 2020
        System.out.println(date1);
    }

    /**
     * LocalDate��LocalTime��LocalDateTime��ʹ��
     * ˵����
     * 1.LocalDateTime�����LocalDate��LocalTime,ʹ��Ƶ�ʽϸ�
     */
    @Test
    public void test1() {
        //now():��ȡ��ǰ�����ڡ�ʱ�䡢����+ʱ��
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

        //���ֲ��ɱ���
        //withXxx():������ص�����
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
        //now():��ȡ���������߶�Ӧ�ı�׼ʱ��
        Instant instant = Instant.now();
        System.out.println(instant);//2023-12-17T16:32:39.278040700Z(����������)

        //���ʱ���ƫ����
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2023-12-18T00:36:22.588181600+08:00

        //toEpochMilli()����ȡ��1970��1��1��0ʱ0�֣�UTC����ʼ�ĺ�����
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

        //ofEpochMilli():ͨ�������ĺ���������ȡInstantʵ�� ---->Date���getTime()����
        Instant instant1 = Instant.ofEpochMilli(1702908799563L);
        System.out.println(instant1);


    }

    /**
     * DateTimeFormatter:��ʽ����������ڡ�ʱ��
     * ������SimpleDateFormat
     */
    @Test
    public void test3() {
        //��ʽһ��Ԥ����ı�׼��ʽ���磺ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        //��ʽ��-���ַ���
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        String format = isoDateTime.format(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(format);
        //�������ַ���-������
        TemporalAccessor parse = isoDateTime.parse(format);
        System.out.println(parse);

        //��ʽ�������ػ���صĸ�ʽ���磺ofLocalizedDateTime(FormatStyle.LONG)
        //���ػ���صĸ�ʽ���磺ofLocalizedDateTime()
        //FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:������LocalDateTime

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        //��ʽ����
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);//2023��12��23�� CST ����10:33:22
        //������
        TemporalAccessor parse1 = dateTimeFormatter.parse(format1);
        System.out.println(parse1);
        //���ػ���صĸ�ʽ���磺ofLocalizedDate()
        //FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:������LocalDate


        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalDate now = LocalDate.now();
        String format2 = dateTimeFormatter1.format(now);
        System.out.println(format2);//2023/12/23


        //�ص㣺��ʽ�����Զ���ĸ�ʽ���磺ofPattern(��yyyy-MM-dd hh:mm:ss��)
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //��ʽ����
        String format3 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format3);
        //������
        TemporalAccessor parse2 = dateTimeFormatter2.parse(format3);
        System.out.println(parse2);
        System.out.println(parse2);



    }
}
