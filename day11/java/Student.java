package day11.java;

public class Student extends Person {
    //    String name;
//    int age;
    String major;

    public Student() {

    }

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    //        public void eat(){
//            System.out.println("³Ô·¹");
//        }
//        public void sleep(){
//            System.out.println("Ë¯¾õ");
//        }
    public void study() {
        System.out.println("Ñ§Ï°");
    }


}
