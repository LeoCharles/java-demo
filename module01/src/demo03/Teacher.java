package demo03;

/**
 * 教师类 继承自 员工类
 */
public class Teacher extends Employee {

   String title = "教师";
   String name;

   public Teacher() {
      // super(); // 默认调用父类无参构造方法
      // 调用父类重载构造
      super("teacher");
      System.out.println("Teacher 类构造方法");
   }

   // 重写父类的方法，方法反回值范围必须【小于等于】父类的范围
   // 父类是 Object，子类是 String  Object > String
   @Override
   public String returnNull() {
      return null;
   }

   // 重写父类的方法，方法权限修饰符必须【大于等于】父类的权限修饰符
   // public > protected > (default) > private
   @Override
   public void testMethod() {
      System.out.println("Teacher 类中一个公共的方法");
   }
}
