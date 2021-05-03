package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class Game implements Runnable {
	int x  = 0; 

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	
	private BufferStrategy  bs; 
	private Graphics g; 
	
	//States
	private State gameState;
	private State menuState;
	
	
	//Input
	private KeyManager keyManager;


	//camera

	private GameCamera gameCamera;
	
	
	
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		gameCamera = new GameCamera(this,0, 0);
		
		gameState = new GameState(this);
		State.setState(gameState);
		menuState= new MenuState(this);
		
	}
	
	private void tick(){
		keyManager.tick();
		if(State.getState()!= null)
		{
			State.getState().tick();
		}
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) 
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g =bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// Draw heere
		
		if(State.getState()!= null)
		{
			State.getState().render(g);
			
		}
		
		// End drawing!
		
		
		bs.show();
		g.dispose();
		
		
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000.0/fps;
		
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();
//		System.out.println(lastTime);
//		System.out.println(System.nanoTime());
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
//			System.out.println(delta);
			if(delta >=1 )
			{
				tick();
				render();
				delta -- ;
//				stop();
			}
		}
		
		stop();
		
	}
	
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


