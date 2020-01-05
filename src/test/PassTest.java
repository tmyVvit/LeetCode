package test;

public class PassTest {
    public static void main(String[] args) {
        int num = 1;
        PassTest passTest = new PassTest();
        passTest.change(num);
        System.out.println("number in main: " + num);
    }

    private void change(int num) {
        num = 2;
        System.out.println("number in change: " + num);
    }
}
