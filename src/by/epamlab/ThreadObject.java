package by.epamlab;

public abstract class ThreadObject implements Runnable {
	private volatile boolean interrupt;
	private volatile Canvas canvas;
	private volatile Object monitor;
	private final int CURRENT_CONDITION;
	private final int NEXT_CONDITION;
	
	public ThreadObject(Canvas canvas, Object monitor, int conditionFrom, int conditionTo) {
		this.canvas = canvas;
		this.monitor = monitor;
		CURRENT_CONDITION = conditionFrom;
		NEXT_CONDITION = conditionTo;
	}
	
	public void setInterrupt() {
		interrupt = true;
	}
	
	@Override
	public void run() {
		while(!interrupt) {
			setCondition();
			
			synchronized (monitor) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	abstract String getCondition();

	private void setCondition() {
		if(canvas.getCondition() == CURRENT_CONDITION) {
			synchronized (canvas) {
				canvas.setCondition(NEXT_CONDITION);
				System.out.println(getCondition());
			}
		}
	}
}
