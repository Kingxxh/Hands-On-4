public class Fibonacci {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);  // 按照题目要求使用直接返回
    }

    public static void main(String[] args) {
        int n = 5;  // 计算 Fibonacci(5)
        System.out.println("Fibonacci(" + n + ") = " + fib(n));
    }
}
