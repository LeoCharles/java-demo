package demo06;

public class Assistant implements Employee{


    // 重写抽象方法
    @Override
    public void work() {
        System.out.println("辅导");
    }
}
