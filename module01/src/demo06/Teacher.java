package demo06;

public class Teacher implements Employee {

    // 重写接口方法
    @Override
    public void work() {
        System.out.println("讲课");
    }
}
