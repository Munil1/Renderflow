package com.byabie.rdf.util;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import java.util.Set;
import java.util.HashSet;

import static com.byabie.rdf.util.GLUtil.*;
import com.byabie.rdf.Config;

public class Input extends InputAdapter {
	private Set<Integer> pressedKeys = new HashSet<Integer>();
	public static Cursor currentCursor;
	public Config cfg;
	public Input(Config cfg) {
		this.cfg = cfg;
	}
	@Override
	public boolean keyDown(int keyCode) {
		pressedKeys.add(keyCode);
		return true;
	}
	@Override
	public boolean keyUp(int keyCode) {
		pressedKeys.remove(keyCode);
		return true;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		currentCursor = new Cursor(true, new Vec2<Integer>(screenX, screenY), pointer, button);
		try {
			Thread.sleep(1 / cfg.FPS);
			currentCursor = new Cursor();
		} catch (InterruptedException exc) {}
		return true;
	}
	public boolean keyIsPressed(int keyCode) {
		return pressedKeys.contains(keyCode);
	}
	public Cursor getCursor() {
		return currentCursor;
	}
	public boolean cursor() {
		return currentCursor.isClicked;
	}
	public class Cursor {
		public boolean isClicked;
		public Vec2<Integer> screenPos;
		public int pointer;
		public int button;
		public Cursor(boolean isClicked, Vec2<Integer> screenPos, int pointer, int button) {
			this.isClicked = isClicked;
			this.screenPos = screenPos;
			this.pointer = pointer;
			this.button = button;
		}
		public Cursor() {
			this.isClicked = false;
		}
	}
}