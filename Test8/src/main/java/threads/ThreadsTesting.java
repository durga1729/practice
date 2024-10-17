package threads;

// Java program to illustrate
// Object lock concept
class ThreadsTesting implements Runnable {
    public void run() {
        Lock();
        Lock1();
    }

    public  static synchronized void Lock() {

            System.out.println(Thread.currentThread().getName() + " static synchronized");
        //   }
    }

    public   synchronized void Lock1() {

            System.out.println(Thread.currentThread().getName() + " synchronized ");

    }


  /*  public  void Lock2() {
        System.out.println(Thread.currentThread().getName()+" static ");
    }*/
/*

    public  void Lock3() {
        System.out.println(Thread.currentThread().getName()+" normal ");
    }
*/


    public static void main(String[] args) {
        ThreadsTesting g = new ThreadsTesting();
        Thread t1 = new Thread(g);
        ThreadsTesting g1 = new ThreadsTesting();
        Thread t2 = new Thread(g1);
        //   Geek g2 = new Geek();
        // Thread t3 = new Thread(g2);
        t1.setName("t1");
        t2.setName("t2");
        //t3.setName("t3");
        t1.start();
        t2.start();
        // t3.start();
    }
}

