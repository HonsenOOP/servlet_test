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
                    System.out.println("����");
                }else
                    System.out.println("����");

            }
            boolean IsPrime(int n) {
                if (n < 2) {
                    //С��2���������Ǻ���Ҳ��������
                    return false ;
                }
                for (int i = 2; i < n / 2 + 1; ++i) {
                    // �ͱ�����һ��С��������������������֤������
                    if (0 == n % i) {
                        // �����ˣ�����
                        return false;
                    }
                }
                return true; // ��û����������
            }
        });
        thread.start();
    }


}