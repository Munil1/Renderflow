package com.byabie.rdf;

import com.byabie.rdf.framing.JGame;
import com.byabie.rdf.ui.*;

import com.jogamp.opengl.GLEventListener;

public class Main {
	public static void main(String[] args) {
		new Game().launch();
	}
	public static void run(JGame game, GLRenderer renderer, Config cfg, String title) {
		Renderflow rdf = new Renderflow(game, cfg);
		renderer.init(rdf);
		Window window = new Window(title, renderer.gc);
	}
}
