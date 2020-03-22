package demo10;

/**
 * 内部类
 *
 * 分类：
 * 1.成员内部类
 * 2.局部内部类（包含匿名内部类）
 *
 * 成员内部类定义格式：
 * 修饰符 class 类名称 {
 *    修饰符 class 内部类名称 {
 *        // ...
 *    }
 * }
 *
 * 注意：内用外，随意访问；外用内，需要内部类对象。
 *
 * 使用成员内部类方式：
 * 1. 间接方式：在外部类的方法中使用内部类，main 只调用外部类的方法
 * 2. 直接方式：外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称()
 *
 * 局部内部类定义格式：
 *
 * 修饰符 class 外部类名称 {
 *     修饰符 返回值类型 外部类名称(参数列表) {
 *         class 局部内部类名称 {
 *              // ...
 *          }
 *      }
 *  }
 *
 *
 * 如果接口的实现类(或者父类的子类)，只需要使用唯一的一次
 * 那么这种情况下就可以省略调该类的定义，直接使用匿名内部类
 *
 * 匿名内部类格式:
 *
 * 接口名称 对象名 = new 接口名称() {
 *     // 覆盖重写所有抽象方法
 * };
 *
 * 1.匿名内部类在创建对象的时候只能使用唯一的一次。
 * 如果希望多次创建对象，而且类的内容一样的话，只能使用单独定义的实现类
 * 2.匿名对象在调用方法的时候，只能调用唯一的一次，如果想调用多次，需要给对象起个名字
 *
 *
 * 内部类的最大作用就是可以实现多重继承
 */
public class InnerClass {

    public static void main(String[] args) {

        // 使用成员内部类
        Body body = new Body();
        // 间接方式：通过外部类对象，调用外部类方法，间接调用内部类
        body.methodBody();

        System.out.println("===========");

        // 直接方式：外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称()
        Body.Heart heart = new Body().new Heart();
        heart.beat();


        // 使用局部内部类
        Outer outer = new Outer();
        outer.methodOuter();



        // 接口的实现类只是用了一次，可以使用匿名内部类
//        MyInterfaceImpl impl = new MyInterfaceImpl();
//        impl.methodAbs();
        // 匿名内部类
        MyInterface obj = new MyInterface() {
            @Override
            public void methodAbs() {
                System.out.println("使用匿名内部类的方式重写接口抽象方法");
            }
        };
        // 调用匿名内部类方法
        obj.methodAbs();

    }

}
