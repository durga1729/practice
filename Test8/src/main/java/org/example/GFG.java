package org.example;

public class GFG {

    int counter = 1;
    static int N = 10;

    public void printOdd() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("even " + counter);
                counter++;
                notify();
            }

        }
    }

    public void printEven() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("odd " + counter);
                counter++;
                notify();

            }
        }
    }

    public static void main(String[] args) {
        GFG gfg = new GFG();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                gfg.printOdd();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                gfg.printEven();
            }
        });

        t.start();
        t1.start();
    }
}
