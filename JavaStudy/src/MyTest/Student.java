package MyTest;

/**
 * Created by wy on 2015-09-29.
 */
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Student p1 = new Student("cole",30);
        System.out.print(p1.getName());
    }
}
