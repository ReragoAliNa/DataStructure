public class test {
    public static void main(String[] args) {
        int[] a;
        a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 2;
        }

        for (int element : a) {
            System.out.println(element);
        }
    }
}