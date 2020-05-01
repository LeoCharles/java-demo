package demo16;

public class Person {

    private String name;

    private int age;

    public String label;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    private void sayHi() {
        System.out.println("Hi!");
    }

    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", label='" + label + '\'' +
                '}';
    }
}
