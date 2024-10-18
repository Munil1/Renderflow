package com.byabie.rdf; //Renderflow

import com.byabie.rdf.framing.JGame;
import com.byabie.rdf.ui.GLRenderer;
import com.byabie.rdf.util.GLRR;
import static com.byabie.rdf.util.GLTask.LINES;
import com.byabie.rdf.util.GLUtil.Vec4;
import static com.byabie.rdf.util.GLUtil.vec4;
import com.byabie.rdf.util.Input;
import com.byabie.rdf.util.Key;
import com.jogamp.opengl.awt.GLCanvas;

public class Game implements JGame {
	public GLRenderer renderer = new GLRenderer();
	public static Vec4<Float> vector4D = vec4(1f, 1f, 1f, 0.1f);
	@Override
	public void init() {
		GLRR gl = new GLRR(renderer.getGC());
		gl.Begin(LINES);
		gl.Vertex3f(0f, 0f, 0f);
		gl.Vertex3f(1f, 1f, 1f);
		gl.End();
	}
	@Override
	public void input(Input input) {
		if(input.keyIsPressed(Key.ENTER)) {
			//enterKeyBinding();
		}
	}
	@Override
	public void update(float interval) {
		//Nothing here
	}
	@Override
	public void render(GLCanvas gc) {
		GLRR gl = new GLRR(gc);
		gl.Clear();
		gl.Rotatef(1f, 1f, 1f, 0.01f);
	}
	@Override
	public void clean() {
		//No cleanup
	}
	public void launch() {
		Main.run(this, this.renderer, new Config(), "Line stdOut");
	}
}