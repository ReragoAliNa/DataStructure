package Exercises;

public class transform {
    public static void main(String[] args) {
        char x ='a';
        char y = 'b';
        System.out.println((int)(x));
        System.out.println((int)(y));
        System.out.println(x + y); // char类型在运算时会被提升为int类型
        short a = 1;
        short b = 2;
        // char s = a; // 不能直接赋值，需要强制转换
        int o = a + b; // 不能直接相加，需要强制转换
        // System.out.println(o);       
    }
}
