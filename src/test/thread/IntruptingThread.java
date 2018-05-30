package test.thread;

public class IntruptingThread extends Thread {
	int i = 0;
	public void run() {
		for (Thread t : Thread.getAllStackTraces().keySet()) {
			if (t.getState() == Thread.State.RUNNABLE)
				t.interrupt();
		}

		// while (true) {
		// System.out.println("IntruptingThread.run()" + i++);
		// if(!Thread.currentThread().isInterrupted()){
		// System.out.println(Thread.interrupted());
		// Thread.currentThread().interrupt();
		// System.out.println(Thread.interrupted());
		// this.interrupt();
		// System.out.println(Thread.interrupted());
		// }
		// }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new IntruptingThread(), "IntruptingThread");
		t.start();
	}
}