package day15.exer3;

/**
 * ����һ��ComparableCircle�࣬�̳�Circle�ಢ��ʵ��CompareObject�ӿڡ���
 * ComparableCircle���и����ӿ��з���compareTo��ʵ���壬�����Ƚ�����Բ�İ�
 * ����С��
 */
public class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            //����ģ�
            //return (int)(this.getRadius()-c.getRadius());
//            ��ȷ�ķ�ʽһ��
//            if (this.getRadius()>c.getRadius()){
//                return 1;
//            }else if(this.getRadius()<c.getRadius()){
//                return -1;
//            }else{
//                return 0;
//            }
            //��ȷ�ķ�ʽ����
            this.getRadius().compareTo(c.getRadius());
        } else {
//            return 0;
            throw new RuntimeException("������������Ͳ�ƥ�䣡");
        }
        return 0;
    }
}
