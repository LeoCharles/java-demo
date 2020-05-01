package demo16;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 模拟框架类
 *
 * 使用时不能修改框架内的代码，可以创建任意类的对象，调用任意方法
 *
 * 通过配置文件和反射机制来实现
 *
 * 实现步骤：
 * 1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 2. 在程序中加载读取配置文件
 * 3. 使用反射技术来加载文件进内存
 * 4. 创建对象
 * 5. 执行方法
 *
 */

public class FrameworkDemo {
    public static void main(String[] args) throws Exception {
        // 创建 Properties 对象
        Properties prop = new Properties();

        // 获取类加载器
        ClassLoader classLoader = FrameworkDemo.class.getClassLoader();

        // 通过类加载器获取资源的字节流
        InputStream is = classLoader.getResourceAsStream("demo16\\prop.properties");

        if (is != null) {
            // 加载配置文件
            prop.load(is);

            // 获取配置文件中定义的数据
            String className = prop.getProperty("className");
            String methodName = prop.getProperty("methodName");

            // 加载该类进内存
            Class<?> cls = Class.forName(className);

            // 创建对象
            Object obj = cls.getDeclaredConstructor().newInstance();

            // 获取方法对象
            Method method = cls.getDeclaredMethod(methodName);

            // 暴力反射，可以使用私有方法
            method.setAccessible(true);

            // 修改配置文件的 methodName， 就能调用不同的方法
            method.invoke(obj);

        } else {
            System.out.println("加载配置文件失败了！");
        }

    }
}
