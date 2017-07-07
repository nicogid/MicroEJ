package moc.lab.widget;

import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;
import ej.mwt.Widget;

public class CoteACote extends Composite {

	Widget Gauche;
	Widget Droit;

	public CoteACote(Widget gauche, Widget droit) {
		super();
		this.Gauche = gauche;
		this.Droit = droit;
		add(gauche);
		add(droit);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		System.out.println("CoteACote validate H = " + widthHint + " V = " + heightHint);

		this.Gauche.validate(widthHint / 2, heightHint);
		this.Droit.validate(widthHint / 2, heightHint);

		if (widthHint == 0) {
			widthHint = this.Gauche.getPreferredWidth() + this.Droit.getPreferredWidth();
		}
		if (heightHint == 0) {
			heightHint = Math.max(this.Gauche.getPreferredWidth(), this.Droit.getPreferredWidth());
		}
		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		this.Gauche.setBounds(0, 0, width-50, height);
		this.Droit.setBounds(width - 50, 0,width - 50, height);
	}

	@Override
	public void render(GraphicsContext g) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public boolean handleEvent(int event) {
//		System.out.println("CoteACote Event = " + event);
//		return false;
//	}

}
