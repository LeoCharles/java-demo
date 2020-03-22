package demo08;

/**
 * 四种权限修饰符
 *
 * 所在位置                public   >    protected    >    (default)   >   private
 * 同一个类(我自己)         yes            yes               yes            yes
 * 同一个包(我邻居)         yes            yes               yes            no
 * 不同包子类(我儿子)       yes            yes               no             no
 * 不同包非子类(陌生人)     yes            no                no             no
 */
public class demo08Main {
    public static void main(String[] args) {

    }
}


