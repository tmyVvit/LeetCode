package test;

public class PassTest2 {
    public static void main(String[] args) {
        Terry terry = new Terry();
        terry.setName("tmy");
        PassTest2 passTest2 = new PassTest2();
        passTest2.change(terry);
        System.out.println("Terry's name in main: " + terry);
    }

    private void change(Terry terry) {
        terry.setName("Terry");
        System.out.println("Terry's name in change: " + terry);
    }
}

