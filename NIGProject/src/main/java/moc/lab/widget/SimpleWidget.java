package moc.lab.widget;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;

public class SimpleWidget extends Widget {

	private static final int MINIMUM_SIZE = 20;

	private int ElH;
	private int ElV;
	private final int margin;
	private final int Col;

	public SimpleWidget(int dimH, int dimV, int col) {
		super();
		this.margin = 5;
		this.Col = col;
	}

	@Override
	public void render(GraphicsContext g) {
		// Set white background
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Ellipse
		g.setColor(Colors.BLACK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(this.Col);
		g.fillEllipse(0 + this.margin, 0 + this.margin, this.ElH, this.ElV);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		
		setPreferredSize(MINIMUM_SIZE, MINIMUM_SIZE);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		this.ElH = width - 2 * this.margin;
		this.ElV = height - 2 * this.margin;
	}

	@Override
	public boolean handleEvent(int event) {
		//System.out.println("SIMPLE Event = " + event);
		// Analyze event
		if (Event.getType(event) == Event.POINTER) {
			if (Pointer.isPressed(event) || Pointer.isDragged(event)) {
				Pointer ptr = (Pointer) Event.getGenerator(event);
				this.ElH = getRelativeX(ptr.getX());
				this.ElV = getRelativeY(ptr.getY());
				repaint();
				return true;
			}
		}
		return false;
	}

}
