package application;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.map.*;

public class Game implements Runnable{
	private Display display;
	public int width, height;
	public String title;
	private Map map;
	
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title,int width,int height) {
		this.width =width;
		this.height = height;
		this.title = title;
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
		
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		map = new Map();
		map.render(g);
		
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
		stop();
	}
	private void init() {
		display = new Display(title, width, height);
		
	}
}
