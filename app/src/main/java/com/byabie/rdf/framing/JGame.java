package com.byabie.rdf.framing;

import com.byabie.rdf.util.Input;
import com.byabie.rdf.ui.*;

public interface JGame {
	public void init();
	public void input(Input input);
	public void update(float interval);
	public void render();
	public void clean();
}