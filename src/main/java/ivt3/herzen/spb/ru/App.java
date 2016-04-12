package ivt3.herzen.spb.ru;
/**
 * Выполнила Жукова Николь */
class MyThread extends Thread {
    @Override
    public void run() {
        int i, n;
        boolean b = true;
        n = ((int) (Math.random() * 900000000 + 100000000));
        for (i = 2;  i <= Math.sqrt(n) && b ; i++ ) {

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n % i == 0) {
                b = false;
            }
        }
        if(b){
            System.out.println("Число " + n + " является простым");
        }
        else {
            System.out.println("Число " + n + " не является простым");
        }
    }
}

    public class App {
        public static void main(String[] args) {
            MyThread MySecondThread = new MyThread();
            MySecondThread.start();
            while (MySecondThread.isAlive()) {
                System.out.println("Идет обработка...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
