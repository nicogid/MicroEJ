package moc.lab.timertask;

import ej.bon.TimerTask;
import ej.microui.display.Display;
import moc.lab.widget.GameContent;

public class Person extends TimerTask {

	private int cmp = 0;
	private final GameContent animated;
	
	public Person(GameContent gameContent){
		this.animated = gameContent;
	}
	
	@Override
	public void run() {
		
		if(animated.state == true){
			if(cmp<=15){
				animated.BlV -= 10;
			}
			else{
				animated.BlV += 1;
			}
			cmp++;
			if(animated.BlV == Display.getDefaultDisplay().getHeight()-30){
				cmp = 0;
				animated.state = false;
			}
		}
		
	}

}
