package com.byabie.rdf.util;

import com.badlogic.gdx.InputAdapter;

import java.util.HashSet;
import java.util.Set;

import static com.byabie.rdf.util.GLUtil.*;
import com.byabie.rdf.Config;

public class Input extends InputAdapter {
    private Set<Integer> pressedKeys = new HashSet<>();
    public Cursor currentCursor = new Cursor(); // Initialize cursor in default state
    private Config cfg;

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
        currentCursor = new Cursor(true, new Vec2<>(screenX, screenY), pointer, button);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        currentCursor.isClicked = false; // Update cursor state when touch is released
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        currentCursor.screenPos = new Vec2<>(screenX, screenY);
        return true;
    }

    public boolean keyIsPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public Cursor getCursor() {
        return currentCursor;
    }

    public boolean isCursorClicked() {
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
            this.screenPos = new Vec2<>(0, 0); // Initialize to zero position
            this.pointer = -1; // Use -1 to indicate no pointer
            this.button = -1;  // Use -1 to indicate no button
        }
    }
}