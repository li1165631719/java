package javahigh.day07.exer1;

/**
 * MyDate类包含：
 * private成员变量year,month,day;并为每一个属性定义getter，setter方法：
 */
public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate b2 = (MyDate) o;
            //比较年
            int minusYear = this.getYear() - b2.getYear();
            if (minusYear != 0) {
                return minusYear;
            }
            //比较月
            int minusMonth = this.getMonth() - b2.getMonth();
            if (minusMonth != 0) {
                return minusMonth;
            }
            //比较日
            int minusDay = this.getDay() - b2.getDay();
            if (minusDay != 0) {
                return minusDay;
            }
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
