package com.byabie.rdf.ui;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class GLRenderer {
	public GLCanvas gc;
	public GLRenderer() {
		GLCapabilities cps = new GLCapabilities(null);
		gc = new GLCanvas(cps);
		FPSAnimator animator = new FPSAnimator(gc, 50, true);
		animator.start();
	}
	public void init(Shader[] shaders) {
		for(Shader s : shaders) {
			s.load();
		}
	}
	public void init() {
		new Shader().load();
	}
	public GL getGL() {
		return gc.getGL();
	}
	public GL2 getGL2() {
		return gc.getGL().getGL2();
	}
	public GL3 getGL3() {
		return gc.getGL().getGL2().getGL3();
	}
}