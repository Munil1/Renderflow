package com.byabie.rdf.ui;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import com.byabie.rdf.Renderflow;

public class GLRenderer {
	public GLCanvas gc;
	public GLRenderer() {
		GLCapabilities cps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
		cps.setDoubleBuffered(true);
		cps.setSampleBuffers(true);
		cps.setNumSamples(4); 
		cps.setAlphaBits(8);    
		gc = new GLCanvas(cps);
	}
	public void init(Shader[] shaders) {
		for(Shader s : shaders) {
			s.load();
		}
	}
	public void init(Renderflow renderflow) {
		gc.addGLEventListener(renderflow);
		FPSAnimator animator = new FPSAnimator(gc, renderflow.cfg.FPS, true);
		animator.start();
	}
	public GLCanvas getGC() {
		return this.gc;
	}

}