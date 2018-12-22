package movement2;
import movement2.*;
import java.awt.Color;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GameLoop2 implements Runnable{
	private boolean isRunning;
	private Demo demo;
	private List<Character> characters;
	private List<KinematicWandering> kinematicWanderings;
        private List<KinematicSeek> kinematicSeeks;
        private List<KinematicFlee> kinematicFlees;
	public GameLoop2(boolean isRunning, Demo demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		
		Character c1 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
                
                this.characters = new ArrayList<Character>();
		this.kinematicWanderings = new ArrayList<KinematicWandering>();
		this.kinematicFlees = new ArrayList<KinematicFlee>();
		this.characters.add(c1);
		this.characters.add(c2);
                this.kinematicWanderings.add(new KinematicWandering(c1, 6, 2));
                this.kinematicFlees.add(new KinematicFlee(c2, c1,6));
		
                
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		while (true) {
                    
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			this.characters.get(0).update(kinematicWanderings.get(0).generateKinematicOutput(), 1);
                        this.characters.get(0).render(this.demo.getGraphics());
                        this.characters.get(1).update(kinematicFlees.get(0).generateKinematicOutput(), 1);
                        this.characters.get(1).applyNewOrientation();
                        this.characters.get(1).render(this.demo.getGraphics());
                       
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
