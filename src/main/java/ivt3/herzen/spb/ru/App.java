package ivt3.herzen.spb.ru;
/**
 * Выполнила Жукова Николь */
class TheFirstThread extends Thread {
    @Override
    public void run() {
        int i, n;
        boolean b = true;
        n = ((int) (Math.random() * 900000000 + 100000000));
        for (i = 2; i <= Math.sqrt(n) && b; i++) {
            System.out.println(i) ;
            if (n % i == 0) {
                b = false;

            }
        }
        if (b) {
            System.out.println("Число " + n + " является простым");
        } else {
            System.out.println("Число " + n + " не является простым");
        }
    }
}
class TheSecondThread extends Thread{
    @Override
    public void run() {
        Thread TheFirstThread = new TheFirstThread();
        TheFirstThread.start();
        while ( TheFirstThread.isAlive()) {
            System.out.println("Идет обработка...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class App {
    public static void main(String[] args) {
        Thread TheSecondThread = new TheSecondThread();
        TheSecondThread.start();
    }
}