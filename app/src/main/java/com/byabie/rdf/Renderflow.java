package com.byabie.rdf;

import com.byabie.rdf.framing.JGame;
import com.byabie.rdf.util.Input;

import java.util.Date;

public class Renderflow implements Runnable {
	public JGame game;
	private Input input;
	public Config cfg;
	public Renderflow(JGame game) {
		cfg = new Config();
		this.game = game;
		this.input = new Input(cfg);
	}
	public Renderflow(JGame game, Config cfg) {
		this.cfg = cfg;
		this.game = game;
		this.input = new Input(cfg);
	}
	@Override
	public void run() {
		this.game.init();
		gameLoop();
		this.game.clean();
	} 

	//Game loop
	static Date time = new Date();
	double secsPerUpdate = 1 / cfg.FPS;
	double previous = time.getTime();
	double steps = 0.0;
	public void gameLoop() {
		while (true) {
			double loopStartTime = time.getTime();
			double elapsed = loopStartTime - previous;
			previous = time.getTime();
			steps += elapsed;

			this.game.input(this.input);

			while (steps >= secsPerUpdate) {
				this.game.update(1f);
				steps -= secsPerUpdate;
			}
			this.game.render();
			sync(time.getTime());
		}
	}
    public void sync(double loopStartTime) {
		float loopSlot = 1f / 50;
		double endTime = loopStartTime + loopSlot; 
		while(time.getTime() < endTime) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException ie) {}
		}
	}
	public void start() {
		new Thread(this).start();
	}
}