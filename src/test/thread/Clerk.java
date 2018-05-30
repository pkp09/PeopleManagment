package test.thread;

class Clerk implements Runnable {

	private Record A;

	public Clerk(Record a) {
		A = a;

	}

	public void run() {
		// for(int i=0;i<5;i++) {
		// System.out.println("Value :" +i +" "+Thread.currentThread());
		doStuff(A);

		// System.out.println("Clerk.run()");
		// }
	}

	public synchronized void doStuff(Record a) {
//		synchronized (a) {
			try {
				System.out.println("Before sleep :" + Thread.currentThread());
				wait();

				// Thread.sleep(5000);
				// Thread.yield();
				System.out.println("After sleep :" + Thread.currentThread());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Clerk.doStuff()" + Thread.currentThread());
			a.add(1);
//		}
		//
	}

	public static void main(String[] args) {
		Record a = new Record();
		Thread t1 = new Thread(new Clerk(a));
		t1.setPriority(1);
		Thread t2 = new Thread(new Clerk(a));
		t2.setPriority(2);
		Thread t3 = new Thread(new Clerk(a));
		t3.setPriority(3);
		Thread t4 = new Thread(new Clerk(a));
		t4.setPriority(4);
		Thread t5 = new Thread(new Clerk(a));
		t5.setPriority(5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}

class Record {
	void add(int i) {
		System.out.println(Thread.currentThread() + "Record.add()" + ++i);
		System.out.println();
	}

}