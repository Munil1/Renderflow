package com.byabie.rdf.ui;

import java.awt.*;
import java.awt.event.*;

import com.jogamp.opengl.awt.GLCanvas;

public class Window extends Frame {
	public Window(String title, GLCanvas gc) {
		this.setTitle(title);
		this.add(gc);
		this.setVisible(true);
	}
}