package movement2;

import movement.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo extends JFrame {
	private GameLoop2 gameLoop2;
	
	public Demo() {
		this.setSize(600, 600);
		this.setVisible(true);
		gameLoop2 = new GameLoop2(true, this);
		new Thread(gameLoop2).start();
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
	}
	
	
}
