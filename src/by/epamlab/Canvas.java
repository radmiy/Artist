package by.epamlab;

public class Canvas {
	//Pencil draws something
	public static final int DRAWING_CONDITION = 1;
	//Eraser cleans up the drawings
	public static final int CLEAN_CONDITION = 0;
	
	private volatile int condition;

	public synchronized int getCondition() {
		return condition;
	}
	
	public synchronized void setCondition(int condition) {
		this.condition = condition;
	}
}
