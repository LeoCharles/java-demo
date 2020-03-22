package demo10;


/**
 * 成员内部类
 */
public class Body { // 外部类

    // 成员内部类
    public class Heart {

        // 内部类成员变量
        String label = "heart";

        public void beat() {
            System.out.println("心脏跳动，砰砰砰！");
            // 访问内部类重名的成员变量
            System.out.println(this.label);
            // 访问外部类重名的成员变量
            // 格式：外部类.this.变量名
            System.out.println(Body.this.label);
        }
    }

    // 外部类成员变量
    String label = "body";
    // 外部类成员方法
    public void methodBody() {
        System.out.println("外部类的方法");
        // 使用内部类方法
        new Heart().beat();
    }
}
