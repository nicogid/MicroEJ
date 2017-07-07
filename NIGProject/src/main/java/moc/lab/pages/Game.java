package moc.lab.pages;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.navigation.page.Page;
import moc.lab.widget.CoteACote;
import moc.lab.widget.GameContent;
import moc.lab.widget.SimpleWidget;

public class Game extends Page {
	
	public Game(){
		MicroUI.start();

		Desktop myDesk = new Desktop(Display.getDefaultDisplay());
		Panel myPanel = new Panel();
		myPanel.setSize(myDesk.getWidth(), myDesk.getHeight());
		myPanel.setPreferredSize(myDesk.getWidth(), myDesk.getHeight());
		myPanel.setLocation(0, 0);

		GameContent left = new GameContent(null);
		SimpleWidget right = new SimpleWidget(100, 100, Colors.BLUE);
		CoteACote Rsplit = new CoteACote(left, right);
		
		myPanel.setWidget(Rsplit);
		myPanel.show(myDesk, true);
		myDesk.show();
	}
	
	
}
