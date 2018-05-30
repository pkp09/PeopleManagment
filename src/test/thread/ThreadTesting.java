package test.thread;

//public class ThreadTesting {
//	/**
//	 * @param args
//	 */
////	public static void main(String[] args) {
////		new MyClass("Hello");
////		new MyClass("World");
//		
////		new MyClass(new Counter()).start(); // (1)
////		new MyClass().start(); // (2)
////		new Thread(new Counter()).start();
//		
//		
////		Counter counter1 = new Counter();
////		Thread worker = new Thread(counter1, "Counter A");
////		worker.setDaemon(true);
////		worker.start();
////		System.out.println("ThreadTesting.main()" + worker);
////		
////		Counter counter2 = new Counter();
////		Thread worker2 = new Thread(counter2, "Counter B");
////		worker2.setDaemon(true);
////		worker2.start();
////		System.out.println("ThreadTesting.main()" + worker2);
////		
////		try {
////			int val;
////			do {
////				val = counter1.getValue(); // (7) Access the counter value.
////				System.out.println("Counter value read by "+ Thread.currentThread().getName() + ": " + val);// (8) Print thread name.
////						
////				Thread.sleep(1000); // (9) Current thread sleeps.
////			} while (val < 5);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////			System.out.println("The main thread is interrupted.");
////		}
////		System.out.println("Exit from main() method.");
////
////	}
//
////}
//
//class Counter implements Runnable {
//	//private int currentValue;
//
//	public Counter() {
//		//currentValue = 0;
//	}
//
////	public int getValue() {
////		return currentValue;
////	}
//
//	
//	public void run() {
//System.out.println("Counter.run()");
////		try {
////			while (currentValue < 5) {
////				System.out.println(Thread.currentThread().getName() + ": "+ (currentValue++));// (2) Print thread name.
////
////				Thread.sleep(250); // (3) Current thread sleeps.
////			}
////		} catch (InterruptedException e) {
////			System.out.println(Thread.currentThread().getName()+ " interrupted.");
////		}
////		System.out.println("Exit from thread: "+ Thread.currentThread().getName());
//	}
//}


//class MyClass extends Thread {
//	public MyClass() { }
//	public MyClass(Runnable runnable) {super(runnable);}
//	
////	public MyClass(String s) {
////		msg = s;
////	}
//
////	String msg;
//
//	public void run() {
//		System.out.println("MyClass");
//	}
//
//}



//class R1 implements Runnable {
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//	}
//}
//
// class ThreadTesting implements Runnable {
//	public void run() {
//		Thread t1 = new Thread(new R1(), "|R1a|");
//		t1.run();
//		new Thread(new R1(), "|R1b|").start();
//		System.out.println(Thread.currentThread().getName());
//	}
//
//	public static void main(String[] args) {
//		new Thread(new ThreadTesting(), "|R2|").start();
//	}
//}
 
 
//public class ThreadTesting extends Thread {
//	ThreadTesting(String name) {
//		super(name);
//	}
//
//	public void run() throws IllegalStateException {
//		System.out.println(Thread.currentThread().getName());
//		throw new IllegalStateException();
//	}
//
//	public static void main(String[] args) {
//		new ThreadTesting("|T1|").start();
//	}
//}


//public class ThreadTesting extends Thread {
//	public void run() {
//		System.out.println("|work|");
//	}
//
//	public static void main(String[] args) {
//		ThreadTesting worker = new ThreadTesting();
//		worker.start();
//		worker.run();
//		worker.start();
//	}
//}


//public class ThreadTesting {
//	static Thread makeThread(final String id, boolean daemon) {
//		Thread t = new Thread(id) {
//			public void run() {
//				System.out.println(id);
//			}
//		};
//		t.setDaemon(daemon);
//		t.start();
//		return t;
//	}
//
//	public static void main(String[] args) {
//		Thread a = makeThread("A", false);
//		Thread b = makeThread("B", true);
//		System.out.print("End\n");
//	}
//}


public class ThreadTesting extends Thread {
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	static volatile int i1, i2, j1, j2, k1, k2;

	public void run() {
		while (true) {
			doIt();
			check();
		}
	}

	void doIt() {
		synchronized (lock1) {
			i1++;
		}
		j1++;
		synchronized (lock2) {
			k1++;
			k2++;
		}
		j2++;
		synchronized (lock1) {
			i2++;
		}
	}

	void check() {
		if (i1 != i2)
			System.out.println("i");
		if (j1 != j2)
			System.out.println("j");
		if (k1 != k2)
			System.out.println("k");
	}

	public static void main(String[] args) {
		new ThreadTesting().start();
		new ThreadTesting().start();
	}
}