package lingxing;

public class MultiThread {

    private static final Object obj0 = new Object();
    private static volatile boolean printNumber = true;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj0) {
                int i = 0;
                String str = "123";
                while (i < 3) {
                    while (!printNumber) {
                        try {
                            obj0.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print(str.charAt(i));
                    i++;
                    printNumber = false;
                    obj0.notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj0) {
                int i = 0;
                String str = "ABC";
                while (i < 3) {
                    while (printNumber) {
                        try {
                            obj0.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(str.charAt(i));
                    i++;
                    printNumber = true;
                    obj0.notify();
                }
            }
        }).start();
    }

}
