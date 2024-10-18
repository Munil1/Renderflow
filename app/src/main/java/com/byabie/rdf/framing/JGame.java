package com.byabie.rdf.framing;

import com.byabie.rdf.util.Input;
import com.byabie.rdf.util.GLRR;
import com.byabie.rdf.ui.*;

import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.GL2;

public interface JGame {
	public void init();
	public void input(Input input);
	public void update(float interval);
	public void render(GLCanvas gc);
	default void resize(GLCanvas canvas, int x, int y, int width, int height) {
		GL2 gl = canvas.getGL().getGL2();
		GLRR rr = new GLRR(canvas);
		gl.glViewport(0, 0, width, height);
		rr.Perspective(50f, (float) width / (float) height, 1f, 50f);
	}
	public void clean();
}