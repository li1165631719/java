package day15.java8;

interface Filial {// Т˳��

    default void help() {
        System.out.println("���裬����������");
    }
}

interface Spoony {// �����

    default void help() {
        System.out.println("ϱ�������£�������");
    }
}

class Father {
    public void help() {
        System.out.println("���ӣ�����ϱ����");
    }

}

class Man implements Filial, Spoony {
    @Override
    public void help() {
        System.out.println("�Ҹ���ô���أ�");
        Filial.super.help();
        Spoony.super.help();
    }
}