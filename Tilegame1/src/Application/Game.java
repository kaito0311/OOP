// sua mot cho dong 97 (tan minh)

package Application;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import Api.KeyAction;
import Api.Sound;

import Game.map.*;
import state.GameState;

public class Game implements Runnable { // bo sung KEyEvent
	private Display display;
	public int width, height,currentMap;
	public String title;
	private WorldMap worldMap;
	private Map temp;
	private Rectangle[] rect;
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
//		System.out.println(gamestate.getCurrentCoodinate_X() + " "+ gamestate.getCurrentCoodinate_Y());
		g = bs.getDrawGraphics();
		temp = worldMap.getMap(currentMap);
		rect = temp.getRectangle();
		
//		Tuyen Sua
		if(currentMap == 0) {
			if(gamestate.getPlayer().getRectangle().intersects(rect[0])) {
				currentMap = 2;
				gamestate.getPlayer().setX(731);
				gamestate.getPlayer().setY(381);
			}else if(gamestate.getPlayer().getRectangle().intersects(rect[1])) {
				currentMap = 1;
				gamestate.getPlayer().setX(320);
				gamestate.getPlayer().setY(35);
			}
		}else if(currentMap == 1) {
			if(gamestate.getPlayer().getRectangle().intersects(rect[0])) {
				currentMap = 0;
				gamestate.getPlayer().setX(348);
				gamestate.getPlayer().setY(550);
		    }
		}else if(currentMap == 2) {
			if(gamestate.getPlayer().getRectangle().intersects(rect[0])) {
				currentMap = 0;

				gamestate.getPlayer().setX(60);
				gamestate.getPlayer().setY(270);
		    }
		}
//		Ket Thuc
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
		currentMap = 0;
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(key);
		// minh sua
		// Texture.loadTextures();
		// end
		gamestate = new GameState(this);
	}
	
	public void swapMap() {
		
	}

	public Map getTemp() {
		return temp;
	}

	public void setTemp(Map temp) {
		this.temp = temp;
	}
}