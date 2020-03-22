package demo06;

/**
 * 检测一个对象属于哪个类
 * 格式： 对象 instanceof 类名称 ，返回一个布尔值结果
 */
public class InstanceofTest {
    public static void main(String[] args) {

        getMeAPet(new Dog());


        getMeAPet(new Cat());
    }

    // 传入的动物不知道具体是什么类
    public static void getMeAPet(Animal animal) {
        // 向下转型之前，先进行类型判断，防止出现类型转换异常

        // 判断 animal 是不是 Dog
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
        // 判断 animal 是不是 Cat
        if (animal instanceof  Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }
}
