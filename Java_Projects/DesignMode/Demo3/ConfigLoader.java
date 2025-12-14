/*
Singleton Pattern

有些对象，整个系统只需要一个，也不能多。比如：系统配置读取器（ConfigLoader）、数据库连接池。
如果new了很多个配置对象，内存浪费且数据可能不一致。

核心：
1. 构造方法私有化（Private Constructor）
2. 静态变量保存实例：自己存自己
3. 公开静态方法获取：只给一个入口
*/

public class ConfigLoader {
    // 1. 静态变量保存唯一实例（volatile 保证多线程安全）
    private static volatile ConfigLoader instance;

    // 2. 构造方法私有化！外部无法 new ConfigLoader()
    private ConfigLoader() {
        System.out.println("加载配置文件...");

    }
    // 3. 全局访问点
    public static ConfigLoader getInstance() {
        //双重检查锁
        if (instance == null) {
            synchronized (ConfigLoader.class) {
                if (instance == null) {
                    instance = new ConfigLoader();
                }
            }
        }
        return instance;
    }

    public void getDbUr1() {
        System.out.println("获取数据库连接地址...");
    }
    
}

// 客户端
class Client {
    public static void main(String[] args) {
        // ConfigLoader c = new ConfigLoader(); // 报错！不准new
        ConfigLoader c1 = ConfigLoader.getInstance();
        ConfigLoader c2 = ConfigLoader.getInstance();
        // 验证：c1 和 c2 是同一个对象，内存地址一样
        System.out.println(c1 == c2);
    }
}
