package by.epamlab;

public class Artist implements Runnable{
	private volatile Object pencilMonitor = new Object();
	private volatile Object eraserMonitor = new Object();
	private volatile boolean interrupt;
	private volatile Canvas canvas;
	
	public void setInterrupt() {
		interrupt = true;
	}
	
	public Artist(Canvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void run() {
		Pencil pencil = new Pencil(canvas, pencilMonitor);
		Thread threadPencil = new Thread(pencil);
		threadPencil.start();
		
		Eraser eraser = new Eraser(canvas, eraserMonitor);
		Thread threadEraser = new Thread(eraser);
		threadEraser.start();
		
		while(!interrupt) {
			synchronized (pencilMonitor) {
				pencilMonitor.notify();
			}
			synchronized (eraserMonitor) {
				eraserMonitor.notify();
			}
		}
		
		synchronized (pencilMonitor) {
			pencil.setInterrupt();
			pencilMonitor.notify();
		}
		synchronized (eraserMonitor) {
			eraser.setInterrupt();
			eraserMonitor.notify();
		}
	}

}
