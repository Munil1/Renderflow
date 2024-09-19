package com.byabie.rdf.framing;

public class GLModel {
	public GLCube[] cubes;
	public Animation[] animations;
	public String id;
	public class GLCube {
		public float[] from;
		public float[] to;
		public String id;
		public float[] rotation;
	}
	public class Animation {
		public String id;
		public KeyFrame[] keyframes;
		public class KeyFrame {
			public String of;
			public float[] rotation;
			public float[] translation;
			public float[] scale;
		}
	}
}