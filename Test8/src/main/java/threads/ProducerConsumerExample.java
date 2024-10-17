package threads;

import java.util.ArrayList;
import java.util.List;

class PC {
    List<Integer> l;
    int capacity;

    PC( Integer i) {
        this.capacity = i;
        l = new ArrayList<>();
    }



    public void produce (int i) {
        while (true) {
            synchronized (this) {
                while (capacity == l.size()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("produced "+i);
                l.add(i++);
                notify();
            }
        }
    }

    public int consume () {
        while (true) {
            synchronized (this) {
                while (l.size()==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                 int i = l.remove(0);
                System.out.println("consumed "+i);
                notify();
            }
        }
    }

}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        PC pc1 = new PC(1);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                pc1.produce(1);
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pc1.consume();
            }
        });

        t.start();
        t1.start();
    }

}
