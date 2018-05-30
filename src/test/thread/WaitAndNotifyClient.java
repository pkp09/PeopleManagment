package test.thread;

class Stack {
	private Object[] stackArray;
	private volatile int topOfStack;

	public Stack(int stackCapacity) {
		stackArray = new Object[stackCapacity];
		topOfStack = -1;
	}

	public synchronized void push(Object element) {
		System.out.println("Stack.push() : " + Thread.currentThread()
				+ " : is pushing.");
		while (isFull()) {
			System.out.println(Thread.currentThread() + " waiting to push.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Pushing element is : " + element.toString());
		stackArray[++topOfStack] = element;
		System.out.println(Thread.currentThread()
				+ ": notifying after pushing.");

		notify();
	}

	public synchronized Object pop() {
		System.out.println("Stack.pop() : " + Thread.currentThread()
				+ " : is poping out.");
		while (isEmpty()) {
			try {
				System.out.println(Thread.currentThread()
						+ " : Waiting to pop out.");
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread() + " interrupted.");
				e.printStackTrace();
			}
		}
		Object element = stackArray[topOfStack];
		System.out.println("Popping out Element is:" + element.toString());
		stackArray[topOfStack--] = null;
		System.out.println(Thread.currentThread()
				+ ": notifying after popping.");

		notify();
		return element;
	}

	public boolean isEmpty() {
		return topOfStack < 0;
	}

	public boolean isFull() {
		return topOfStack >= stackArray.length - 1;
	}
}

abstract class StackUser implements Runnable {
	protected Stack stack;

	StackUser(String sThreadName, Stack stack) {
		this.stack = stack;
		Thread worker = new Thread(this, sThreadName);
		System.out.println("StackUser.StackUser() : " + worker);
		worker.setDaemon(true);
		worker.start();
	}
}

class StackPopper extends StackUser {

	StackPopper(String sThreadName, Stack stack) {
		super(sThreadName, stack);
	}

	public void run() {
		while (true) {
			stack.pop();
		}
	}
}

class StackPusher extends StackUser {
	StackPusher(String sThreadName, Stack stack) {
		super(sThreadName, stack);
	}

	public void run() {
		while (true) {
			stack.push(2008);
		}
	}
}

public class WaitAndNotifyClient {
	public static void main(String[] args) throws InterruptedException {
		Stack stack = new Stack(5);
		new StackPusher("First Thread", stack);
		new StackPusher("Second Thread", stack);
		//new StackPusher("A Thread", stack);
		//new StackPusher("B Thread", stack);
		new StackPopper("Third Thread", stack);
		//new StackPopper("C", stack);
		System.out.println("Main Thread sleeping.");
		Thread.sleep(10);
		System.out.println("Exit from Main Thread.");
	}
}