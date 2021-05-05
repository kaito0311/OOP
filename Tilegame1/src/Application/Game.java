package Application;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Api.KeyAction;
import Api.creature.Player;
import Game.map.*;
import state.GameState;

public class Game implements Runnable{          // bo sung KEyEvent
	private Display display;
	public int width, height;
	public String title;
	private map map;
	private GameState gamestate;
	private KeyAction key;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title,int width,int height) {
		this.width =width;
		this.height = height;
		this.title = title;
		key=new KeyAction();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running) {
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
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		map = new map();
		map.render(g);
		gamestate.render(g);
		bs.show();
		g.dispose();
	}
	public KeyAction getKeyaction() {
		return key;
	}

	@Override
	public void run() {
		init();


		int fps = 60;
		double timePerTick = 1000000000.0/fps;
		
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
//			System.out.println(delta);
			if(delta >=1 )
			{
				update();
				render();
				delta -- ;
			}
//				stop();
		}
		stop();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(key);
		gamestate= new GameState(this);
	}
}