// sua mot cho dong 97 (tan minh)

package Application;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Api.KeyAction;
import Api.Sound;
import Api.Texture;
import Api.creature.Player;
import Game.map.*;
import state.GameState;

public class Game implements Runnable { // bo sung KEyEvent
	private Display display;
	public int width, height;
	public String title;
	private WorldMap worldMap;
	private Map temp;
	private GameState gamestate;
	private KeyAction key;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private String audioFilePath;
	   private Sound audio;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		key = new KeyAction();

	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		audioFilePath = "nhac.wav";
		audio = new Sound(audioFilePath);
		audio.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		key.update();
		gamestate.update();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//
		// worldMap = new WorldMap();

		temp.render(g);
		gamestate.render(g);
		bs.show();
		g.dispose();
	}

	public KeyAction getKeyaction() {
		return key;
	}

	
	public void run() {
		init();

		int fps = 30;
		double timePerTick = 1000000000.0/fps;
		
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			if(delta >=1 )
			{
				// System.out.println("loi");
				update();
				render();
				delta -- ;
			}
//				stop();
		}
		stop();
	}

	private void init() {

		worldMap = new WorldMap();
		temp = worldMap.getMap(0);
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(key);
		// minh sua
		// Texture.loadTextures();
		// end
		gamestate = new GameState(this);
	}

	public Map getTemp() {
		return temp;
	}

	public void setTemp(Map temp) {
		this.temp = temp;
	}
}