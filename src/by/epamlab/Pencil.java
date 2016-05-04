package by.epamlab;

public class Pencil extends ThreadObject {
	public Pencil(Canvas canvas, Object monitor) {
		super(canvas, monitor, Canvas.CLEAN_CONDITION, Canvas.DRAWING_CONDITION);
	}

	@Override
	String getCondition() {
		return "Pencil draws something.";
	}
}
