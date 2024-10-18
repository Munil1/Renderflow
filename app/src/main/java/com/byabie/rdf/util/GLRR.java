package com.byabie.rdf.util;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;
import static com.jogamp.opengl.GL2.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import static com.byabie.rdf.util.GLUtil.*;

import java.nio.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GLRR {
	public enum GLMatrixMode {
		PROJECTION, MODELVIEW, TEXTURE, COLOR
	}
	private GL2 gl;
	private GLU glue = new GLU();
	//Constructor
	public GLRR(GLAutoDrawable gc) {
		this.gl = (gc.getGL()).getGL2();
	}
	public void Begin(GLTask task) {
		switch(task) {
			case LINES: gl.glBegin(GL_LINES); break;
			case QUADS: gl.glBegin(GL_QUADS); break;
			case TRIANGLES: gl.glBegin(GL_TRIANGLES); break;
			case POLYGON: gl.glBegin(GL_POLYGON); break;
			default: throw new IllegalArgumentException("Invalid GLTask");
		}
	}
	//Util methods
	public void Vertex3f(float x, float y, float z) {
		gl.glVertex3f(x, y, z);
	}
	public void Vertex3f(Vec3<Float> pos) {
		gl.glVertex3f(pos.x, pos.y, pos.z);
	}
	public void End() {
		gl.glEnd();
	}
	public void SetLighting(boolean enable) {
		if (enable) {
			gl.glEnable(GL_LIGHTING);
		} else {
			gl.glDisable(GL_LIGHTING);
		}
	}
	public void Clear() {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
	}
	public void AmbientLight(Vec4<Float> light)  {
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, new float[]{light.x, light.y, light.z, light.w}, 0);    
	}
	public void DiffuseLight(Vec4<Float> light)  {
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, new float[]{light.x, light.y, light.z, light.w}, 0);    
	}
	public void EnableTextures() {
		gl.glEnable(GL2.GL_TEXTURE_2D);
	}
	public int GenTexture() {
		int[] texture = new int[1];
		gl.glGenTextures(1, texture, 0);
		return texture[0];
	}
	public void TexCoord2f(float x, float y) {
		gl.glTexCoord2f(x, y);
	}
	public void Parametric() {
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_LINEAR);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_LINEAR);
	}
	public void BindTexture2D(int textureID) {
		gl.glBindTexture(GL2.GL_TEXTURE_2D, textureID);
	}
	public void LoadImage2D(Texture texture, boolean alpha) {
		texture.bind(gl);
		int width = texture.getWidth();
		int height = texture.getHeight();
		ByteBuffer buffer = ByteBuffer.allocateDirect(width * height * 4);
		buffer.order(ByteOrder.nativeOrder());
		gl.glReadPixels(0, 0, width, height, alpha ? GL2.GL_RGBA : GL_RGB, GL2.GL_UNSIGNED_BYTE, buffer);
		buffer.flip();
		gl.glTexImage2D(GL2.GL_TEXTURE_2D, 0, alpha ? GL2.GL_RGBA : GL2.GL_RGB, width, height, 0, alpha ? GL2.GL_RGBA : GL2.GL_RGB, GL2.GL_UNSIGNED_BYTE, buffer);
	}
	public Texture getTexture(String path) {
		try {
            return TextureIO.newTexture(new File(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	public void Translatef(float x, float y, float z) {
		gl.glTranslatef(x, y, z);
	}
	public void Scalef(float x, float y, float z) {
		gl.glScalef(x, y, z);
	}
	public void Rotatef(float x, float y, float z, float angle) {
		gl.glRotatef(x, y, z, angle);
	}
	public void LoadIdentity() {
		gl.glLoadIdentity();
	}
	public void MatrixMode(GLMatrixMode mode) {
		switch(mode) {
			case GLMatrixMode.PROJECTION: gl.glMatrixMode(GL2.GL_PROJECTION);
			case GLMatrixMode.MODELVIEW: gl.glMatrixMode(GL2.GL_MODELVIEW);
			case GLMatrixMode.TEXTURE: gl.glMatrixMode(GL2.GL_TEXTURE);
			case GLMatrixMode.COLOR: gl.glMatrixMode(GL2.GL_COLOR);
		}
	}
	public void Color3f(float x, float y, float z) {
		gl.glColor3f(x, y, z);
	}
	public void Perspective(float y, float asp, float zNear, float zFar) {
		glue.gluPerspective(y, asp, zNear, zFar);
	}
	public void enableDepth() {
		gl.glEnable(GL2.GL_DEPTH_TEST);
	}
}