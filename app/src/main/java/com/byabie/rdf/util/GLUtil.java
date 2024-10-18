package com.byabie.rdf.util;

public /*abstract*/ class GLUtil {
	public static class Vec3<T> {
		public T x, y, z;
		public Vec3(T x, T y, T z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static class Vec4<T> {
		public T x, y, z, w;
		public Vec4(T x, T y, T z, T w) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}
	}
	public static class Vec2<T> {
		public T x, y;
		public Vec2(T x, T y) {
			this.x = x;
			this.y = y;
		}
	}
	public static class Mat3<T> {
		private Object[] a = new Object[3];
		private Object[] b = new Object[3];
		private Object[] c = new Object[3];
		public Mat3(Vec3<T> a, Vec3<T> b, Vec3<T> c) {
			this.a = new Object[]{a.x, a.y, a.z};
			this.b = new Object[]{b.x, b.y, b.z};
			this.c = new Object[]{c.x, c.y, c.z};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1 -> {
                                    return this.a[column - 1];
                        }
				case 2 -> {
                                    return this.b[column - 1];
                        }
				case 3 -> {
                                    return this.c[column - 1];
                        }
				default -> throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Mat4<T> {
		private Object[] a = new Object[4];
		private Object[] b = new Object[4];
		private Object[] c = new Object[4];
		private Object[] d = new Object[4];
		public Mat4(Vec4<T> a, Vec4<T> b, Vec4<T> c, Vec4<T> d) {
			this.a = new Object[]{a.x, a.y, a.z, a.w};
			this.b = new Object[]{b.x, b.y, b.z, b.w};
			this.c = new Object[]{c.x, c.y, c.z, c.w};
			this.d = new Object[]{d.x, d.y, d.z, d.w};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1 -> {
                                    return this.a[column - 1];
                        }
				case 2 -> {
                                    return this.b[column - 1];
                        }
				case 3 -> {
                                    return this.c[column - 1];
                        }
				case 4 -> {
                                    return this.d[column - 1];
                        }
				default -> throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Mat2<T> {
		private Object[] a = new Object[4];
		private Object[] b = new Object[4];
		public Mat2(Vec2<T> a, Vec2<T> b) {
			this.a = new Object[]{a.x, a.y};
			this.b = new Object[]{b.x, b.y};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1 -> {
                                    return this.a[column - 1];
                        }
				case 2 -> {
                                    return this.b[column - 1];
                        }
				default -> throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Main {
		//GLUtil Main class
	}
	public static Vec3<Float> vec3(float x, float y, float z) {
			return new Vec3<>(x, y, z);
	}
	public static Vec2<Float> vec2(float x, float y) {
			return new Vec2<>(x, y);
	}
	public static Vec4<Float> vec4(float x, float y, float z, float w) {
			return new Vec4<>(x, y, z, w);
	}
	public static float mix(float n1, float n2, float a) {
		return diff(n1, n2) * a;
	}
	public static float abs(float toAbs) {
		return Math.max(toAbs, -toAbs);
	}
	public static float diff(float n1, float n2) {
		return abs(n1 - n2);
	}
	public static float clamp(float n, float minValue, float maxValue) {
		return Math.max(Math.min(n, maxValue), minValue);
	}
	public static float step(float edge, float x) {
    		return (x < edge) ? 0.0f : 1.0f;
	}
	public static float dot(Vec3<Float> a, Vec3<Float> b) {
		return a.x * b.x + a.y * b.y + a.z * b.z;
	}
	public static float dot(Vec2<Float> a, Vec2<Float> b) {
		return a.x * b.x + a.y * b.y;
	}
	public static float dot(Vec4<Float> a, Vec4<Float> b) {
		return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
	}
	public static Vec3<Float> mult(Vec3<Float> m, float multBy) {
		return new Vec3<>(m.x * multBy, m.y * multBy, m.z * multBy);
	}
}