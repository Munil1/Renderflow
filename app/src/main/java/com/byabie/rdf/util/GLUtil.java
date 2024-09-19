package com.byabie.rdf.util;

public abstract class GLUtil {
	public static class Vec3<T> {
		public T x;
		public T y;
		public T z;
		public Vec3(T x, T y, T z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public static Vec3<Float> vec3(float x, float y, float z) {
			return new Vec3<Float>(x, y, z);
		}
	}
	public static class Vec4<T> {
		public T x;
		public T y;
		public T z;
		public T w;
		public Vec4(T x, T y, T z, T w) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}
		public static Vec4<Float> vec4(float x, float y, float z, float w) {
			return new Vec4<Float>(x, y, z, w);
		}
	}
	public static class Vec2<T> {
		public T x;
		public T y;
		public Vec2(T x, T y) {
			this.x = x;
			this.y = y;
		}
		public static Vec2<Float> vec2(float x, float y) {
			return new Vec2<Float>(x, y);
		}
	}
	public static class Mat3<T> {
		public Object[] a = new Object[3];
		public Object[] b = new Object[3];
		public Object[] c = new Object[3];
		public Mat3(Vec3<T> a, Vec3<T> b, Vec3<T> c) {
			this.a = new Object[]{a.x, a.y, a.z};
			this.b = new Object[]{b.x, b.y, b.z};
			this.c = new Object[]{c.x, c.y, c.z};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1: return this.a[column--];
				case 2: return this.b[column--];
				case 3: return this.c[column--];
				default : throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Mat4<T> {
		public Object[] a = new Object[4];
		public Object[] b = new Object[4];
		public Object[] c = new Object[4];
		public Object[] d = new Object[4];
		public Mat4(Vec4<T> a, Vec4<T> b, Vec4<T> c, Vec4<T> d) {
			this.a = new Object[]{a.x, a.y, a.z, a.w};
			this.b = new Object[]{b.x, b.y, b.z, b.w};
			this.c = new Object[]{c.x, c.y, c.z, c.w};
			this.d = new Object[]{d.x, d.y, d.z, d.w};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1: return this.a[column--];
				case 2: return this.b[column--];
				case 3: return this.c[column--];
				case 4: return this.d[column--];
				default : throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Mat2<T> {
		public Object[] a = new Object[4];
		public Object[] b = new Object[4];
		public Mat2(Vec2<T> a, Vec2<T> b) {
			this.a = new Object[]{a.x, a.y};
			this.b = new Object[]{b.x, b.y};
		}
		public Object get(int row, int column) throws ArrayIndexOutOfBoundsException {
			switch(row) {
				case 1: return this.a[column--];
				case 2: return this.b[column--];
				default : throw new ArrayIndexOutOfBoundsException("Row " + row + " not found.");
			}
		}
	}
	public static class Main {
		//GLUtil Main class
	}
}