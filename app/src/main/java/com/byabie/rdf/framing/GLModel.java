package com.byabie.rdf.framing;

public class GLModel {
	public ModelGroup[] groups;
	public ModelCube[] cubes;
	public Animation[] animations;
	public class ModelGroup {
		public ModelCube[] cubesIn;
	}
	public class ModelCube {
			public int[] from = new int[3];
			public int[] to = new int[3];
			public String id;
	}
	public class Animation {
		public String of;
		public String id;
		public KeyFrame[] keyFrames;
		public class KeyFrame {
			public int[] rotation;
			public int[] translation;
			public int[] scaling;
			public float secs;
		}
	}
}