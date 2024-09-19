package com.byabie.rdf;

import static com.byabie.rdf.util.GLUtil.*;
import static com.byabie.rdf.util.GLTask.*;

import com.byabie.rdf.framing.*;
import com.byabie.rdf.ui.*;
import com.byabie.rdf.util.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Game implements JGame {
	public GLRenderer renderer = new GLRenderer();
	@Override
	public void init() {
		renderer.init();
	}
	@Override
	public void input(Input input) {
		if (input.keyIsPressed(12)) {
			///
		}
	}
	@Override
	public void update(float interval) {
		//Nothing here
	}
	@Override
	public void render() {
		GLRR gl = new GLRR(renderer.getGL2());
		gl.Begin(LINES);
		gl.Vertex3f(0f, 0f, 0f);
		gl.Vertex3f(1f, 1f, 1f);
		gl.End();
	}
	@Override
	public void clean() {
		//No cleanup
	}
	public void launch() {
		Main.run(this, this.renderer, "Line stdOut");
	}
}