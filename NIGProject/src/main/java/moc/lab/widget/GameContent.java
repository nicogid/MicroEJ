package moc.lab.widget;

import java.io.IOException;

import ej.bon.Timer;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import moc.lab.timertask.Componment;
import moc.lab.timertask.Person;

public class GameContent extends Widget {

	private static final int NO_DELAY = 0;
	private static final int DEFAULT_PERIOD = 10;

	public Boolean state = false;
	
	// Coords Background Image
	int DimH; //Px
	int DimV; //Py
	
	// Coords Block
	public int ElH; //Px
	public int ElV; //Py
	
	// Coords Perso
	public int BlV; // Py
	public int BlH; // Px
	
	// Image Declaration
	private Image saut; 
	private Image carre;
	private Image fond;
	
	public int score;
	
	private final Font font = Font.getFont(Font.LATIN, 26 , Font.STYLE_PLAIN);
	
	
	public GameContent(Display display){
		super();
		Display disp = Display.getDefaultDisplay();
		DimH = disp.getWidth();
		DimV = disp.getHeight(); 
		ElH = disp.getWidth();
		ElV = disp.getHeight()-20;
		BlV = disp.getHeight()-30;
		BlH = disp.getWidth()/2;
		score = 0;
		try{
			saut = Image.createImage("/images/carapace.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		try{
			carre = Image.createImage("/images/mario.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		try{
			fond = Image.createImage("/images/fond.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		
		Componment object = new Componment(this);
		Person person = new Person(this);

		// Create a timer (implicitly, create a new Thread)
		Timer timer = new Timer();

		// Use the same timer to schedule multiple tasks
		timer.schedule(object, NO_DELAY, DEFAULT_PERIOD);
		timer.schedule(person, NO_DELAY, DEFAULT_PERIOD);
		
		
	}

	
	
	@Override
	public void render(GraphicsContext g) {
		
		g.setColor(Colors.WHITE);
		g.fillRect(0,0,DimH,DimV);
		
		g.drawImage(fond,0,0,GraphicsContext.TOP|GraphicsContext.LEFT);
		
		String myString = new String("Votre scrore : " + score);
		g.setFont(font);
		
		g.setColor(Colors.BLACK);
		g.drawString(myString, 0, 0, GraphicsContext.TOP|GraphicsContext.LEFT);
		
		g.drawImage(saut,ElH,ElV,GraphicsContext.
				HCENTER|GraphicsContext.VCENTER);
		
		g.drawImage(carre,BlH,BlV,GraphicsContext.
				HCENTER|GraphicsContext.VCENTER);
		
		
		//To debug 
		//System.out.println("BlV = " + BlV);
		//System.out.println("ElH = " + ElH);
		
		
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		// TODO Auto-generated method stub

	}
	
	// Action in handler
		@Override
		public boolean handleEvent(int event) {
			if(Event.getType(event)== Event.POINTER){
				if(Pointer.isDragged(event)){
						state = true;
				}
			}
			return false;
		}

}
