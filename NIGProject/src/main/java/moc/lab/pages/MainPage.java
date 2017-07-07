package moc.lab.pages;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.composed.Button;
import ej.widget.container.List;
import ej.widget.container.Scroll;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

public class MainPage extends Page {
	private static Scroll scroll;
	private static List list;
	
	private Button bt1 = new Button("Start");
	private Button bt2 = new Button("Result");
	private Button bt3 = new Button("Exit");
	
	public MainPage() {
		list = new List(false);
		
		bt1.addOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Start game");
				MyActivity.show(Game.class.getName());// url de navigation
			}
		});
		
		bt2.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Result");
				//MyActivity.show(ResultPage.class.getName());// url de navigation
			}
		});
		
		bt3.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ExitHandler exitHandler = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if(exitHandler != null)
					exitHandler.exit();
			}
		});
		
		for(int i = 1;i<4;i++){
			switch(i){
			case 1:
				list.add(bt1);
				break;
			case 2:
				list.add(bt2);
				break;
			case 3:
				list.add(bt3);
				break;
			default:
				System.out.println("error");
				break;
			}
		}
			
		scroll = new Scroll(false,true);
		scroll.setWidget(list);
		this.setWidget(scroll); // racine de l'arbre des widgets 
	}
	
}