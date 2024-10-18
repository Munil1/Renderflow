package com.byabie.rdf;

import com.byabie.rdf.framing.JGame; //Interface JGame
import com.byabie.rdf.util.Input;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;


public class Renderflow implements GLEventListener {
	public boolean running;
	public JGame game;
	private final Input input;
	private GLCanvas cgc;
	public Config cfg = new Config();
	public Renderflow(JGame game, Config cfg) {
		this.cfg = cfg;
		this.game = game;
		this.input = new Input(cfg);
	}
	@Override
	public void init(GLAutoDrawable drawable) {
		running = true;
		System.setProperty("jogl.debug", "true");
		this.game.init();
		if(drawable instanceof GLCanvas canvas) {
			this.cgc = canvas;
			 new Thread(this::gameLoop).start();
		}
	} 
	@Override
	public void display(GLAutoDrawable drawable) {
		
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		this.game.resize((GLCanvas) drawable, x, y, width, height);
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
		running = false;
		this.game.clean();
	}

	//Game loop
	double secsPerUpdate = 1.0d / cfg.FPS;
	double steps = 0.0;
	public void gameLoop() {
    		double lastTime = System.nanoTime();
    		double frameTime = 1_000_000_000.0 / cfg.FPS; // Time per frame in nanoseconds

    		while (running) {
        		double currentTime = System.nanoTime();
        		double elapsed = currentTime - lastTime;
   		     lastTime = currentTime;
   		     steps += elapsed;

 			this.game.input(this.input);

        		while (steps >= secsPerUpdate) {
            		this.game.update(cfg.INTERVAL);
            		steps -= secsPerUpdate;
        		}
        
        		this.game.render(this.cgc);

        		// Sync without blocking
        		double sleepTime = (lastTime + frameTime) - System.nanoTime();
        		if (sleepTime > 0) {
          	  	try {
          	     	Thread.sleep((long) (sleepTime / 1_000_000));
          	  	} catch (InterruptedException ie) {
                		Thread.currentThread().interrupt();
            		}
        		}
    		}
	}
	public Input getInput() {
		return this.input;
	}
}