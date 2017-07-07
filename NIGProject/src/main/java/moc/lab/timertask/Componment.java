package moc.lab.timertask;

import ej.bon.TimerTask;
import ej.microui.display.Display;
import moc.lab.widget.GameContent;

public class Componment extends TimerTask {

	private final GameContent animated;
	
	public Componment(GameContent gameContent){
		this.animated = gameContent;
	}
	
	@Override
	public void run() {
		
		animated.ElH -= 1;
		
		if(animated.ElH <0){
			animated.ElH = Display.getDefaultDisplay().getWidth();
			animated.score += 1; 
		}
		if(animated.ElH == animated.BlV && animated.ElH > animated.BlH){
			this.cancel();
			System.out.println(animated.score);
			// To stop timerTask
			//animated.ElH = Display.getDefaultDisplay().getWidth();
		}
		animated.repaint();
		
	}

}
