import java.util.Scanner;

/**
 * Created by Honsen on 2016/10/17.
 *
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("Input: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        boolean result = false;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (IsPrime(input)){
                    System.out.println("素数");
                }else
                    System.out.println("合数");

            }
            boolean IsPrime(int n) {
                if (n < 2) {
                    //小于2的数即不是合数也不是素数
                    return false ;
                }
                for (int i = 2; i < n / 2 + 1; ++i) {
                    // 和比它的一半小数相除，如果都除不尽，证明素数
                    if (0 == n % i) {
                        // 除尽了，合数
                        return false;
                    }
                }
                return true; // 都没除尽，素数
            }
        });
        thread.start();
    }


}