package test;

public class PassTest3 {
    public static void main(String[] args) {
        Terry terry = new Terry();
        terry.setName("tmy");
        PassTest3 passTest3 = new PassTest3();
        passTest3.change(terry);
        System.out.println("Terry's name in main: " + terry);
    }

    private void change(Terry terry) {
        terry = new Terry();
        terry.setName("Terry");
        System.out.println("Terry's name in change: " + terry);
    }
}
