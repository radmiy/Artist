package by.epamlab;

public class Eraser extends ThreadObject {
	public Eraser(Canvas canvas, Object monitor) {
		super(canvas, monitor, Canvas.DRAWING_CONDITION, Canvas.CLEAN_CONDITION);
	}

	@Override
	String getCondition() {
		return "Eraser cleans up the drawings.";
	}
}
