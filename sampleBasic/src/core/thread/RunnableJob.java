package core.thread;

public class RunnableJob implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")");
	}

}
